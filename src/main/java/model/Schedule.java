package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by iushakova on 30/08/15.
 */
public class Schedule {


    private static List<Appointment> appointments = new ArrayList<Appointment>();
    private static Map<Patient, List<Appointment>> patientAppointment = new HashMap();
    private static Map<Doctor, List<Appointment>> doctorAppointment = new HashMap();

    public static void addAppointment(Appointment newAppointment) {
        appointments.add(newAppointment);

        Patient patient = newAppointment.getPatient();
        List<Appointment> patientAppList = patientAppointment.get(patient);
        if ( patientAppList == null) {
            patientAppList = new ArrayList<Appointment>();
        }
        patientAppList.add(newAppointment);
        patientAppointment.put(patient, patientAppList);

        Doctor doctor = newAppointment.getDoctor();
        List<Appointment> doctorAppList = doctorAppointment.get(doctor);
        if ( doctorAppList == null) {
            doctorAppList = new ArrayList<Appointment>();
        }
        doctorAppList.add(newAppointment);
        doctorAppointment.put(doctor, doctorAppList);
    }


    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static List<Appointment> getAppointments(Patient patient) {
        return patientAppointment.get(patient);
    }

    public static List<Appointment> getAppointments(Doctor doctor) {
        return doctorAppointment.get(doctor);
    }

    public static void removeAppointment(Appointment appointment) {
        removeFromAppointments(appointment);
        removeFromPatient(appointment);
        removeFromDoctor(appointment);
    }

    private static void removeFromPatient(Appointment appointment) {
        Patient patient = appointment.getPatient();
        List<Appointment> appointmentList = patientAppointment.get(patient);
        if (appointmentList != null) {
            Iterator<Appointment> i = appointmentList.iterator();
            removeAppointment(appointment, i);
        }
        if (patientAppointment.get(patient).isEmpty()) {
            patientAppointment.remove(patient);
        }
    }

    private static void removeFromDoctor(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        List<Appointment> appointmentList = doctorAppointment.get(doctor);
        if (appointmentList != null) {
            Iterator<Appointment> i = appointmentList.iterator();
            removeAppointment(appointment, i);
        }
        if (doctorAppointment.get(doctor).isEmpty()) {
            patientAppointment.remove(doctor);
        }
    }

    private static void removeFromAppointments(Appointment appointment) {
        Iterator<Appointment> i = appointments.iterator();
        removeAppointment(appointment, i);
    }

    private static void removeAppointment(Appointment appointment, Iterator<Appointment> i) {
        while (i.hasNext()) {
            if (i.next().equals(appointment)){
                i.remove();
            }
        }
    }
}
