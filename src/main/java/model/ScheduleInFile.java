package model;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iushakova on 08/11/15.
 */
public class ScheduleInFile implements Schedule {


    private String appointmentFilename;


    public ScheduleInFile(String getAppointmentFilename) {
        this.appointmentFilename = getAppointmentFilename;
    }

    public String getAppointmentFilename() {
        return appointmentFilename;
    }

    public void addAppointment(Appointment newAppointment) {
        appendToFile(appointmentFilename, convertAppointmentToString(newAppointment));
    }

    public void removeAppointment(Appointment appointment) {

        try (FileInputStream is = new FileInputStream(appointmentFilename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        ) {
            String line;
            while ((line = br.readLine()) != null){
                if (convertStringToAppointment(line).equals(appointment)) {
                    continue;
                }
                appendToFile(appointmentFilename + ".tmp", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAppointments() {
        List<Appointment> result = new ArrayList<>();
        try (FileInputStream is = new FileInputStream(appointmentFilename);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));) {
            String line;
            while ((line = br.readLine()) != null){
                result.add(convertStringToAppointment(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Appointment> getAppointments(Patient patient) {
        List<Appointment> appointments = getAppointments();
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient)) {
                result.add(appointment);
            }
        }
        return result;
    }

    public List<Appointment> getAppointments(Doctor doctor) {
        List<Appointment> appointments = getAppointments();
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                result.add(appointment);
            }
        }
        return result;
    }



    public void appendToFile(String filename, String str) {
        writeToFile(filename, str, true);
    }

    public void addToFile(String filename, String str) {
        writeToFile(filename, str, false);
    }

    private void writeToFile(String filename, String str, boolean isAppend) {
        try (FileOutputStream os = new FileOutputStream(filename, isAppend);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            bw.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Appointment convertStringToAppointment(String str) {
        String[] data = StringUtils.split(str.trim(), ",");
        Patient patient = new Patient(Integer.valueOf(data[0]), data[1], data[2], Gender.valueOf(data[3]), new DateTime(Long.valueOf(data[4])));
        Doctor doctor = new Doctor(Integer.valueOf(data[5]), data[6], data[7], data[8]);
        return new Appointment(patient, doctor, new DateTime(Long.valueOf(data[9])));
    }

    private String convertAppointmentToString (Appointment appointment) {
        StringBuilder sb = new StringBuilder();
        sb.append(convertPatientToString(appointment.getPatient())).append(",");
        sb.append(convertDoctorToString(appointment.getDoctor())).append(",");
        sb.append(appointment.getDateTime().getMillis());
        sb.append("\n");
        return sb.toString();
    }

    private String convertPatientToString(Patient patient) {
        StringBuilder sb = new StringBuilder();
        sb.append(patient.getId()).append(",");
        sb.append(patient.getFirstName()).append(",");
        sb.append(patient.getLastName()).append(",");
        sb.append(patient.getGender()).append(",");
        sb.append(patient.getDob().getMillis());
        return sb.toString();
    }

    public String convertDoctorToString(Doctor doctor) {
        StringBuilder sb = new StringBuilder();
        sb.append(doctor.getId()).append(",");
        sb.append(doctor.getFirstName()).append(",");
        sb.append(doctor.getLastName()).append(",");
        sb.append(doctor.getSpeciality());
        return sb.toString();
    }

}
