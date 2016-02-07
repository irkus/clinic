package Impl;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by iushakova on 30/08/15.
 */
public class ScheduleInMemory implements Schedule{

    private List<Appointment> appointments = new ArrayList<Appointment>();
    private Map<Patient, List<Appointment>> patientAppointment = new HashMap();
    private Map<Doctor, List<Appointment>> doctorAppointment = new HashMap();

    public void addAppointment(Appointment newAppointment) {
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


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Appointment> getAppointments(Patient patient) {
        return patientAppointment.get(patient);
    }

    public List<Appointment> getAppointments(Doctor doctor) {
        return doctorAppointment.get(doctor);
    }

    public void removeAppointment(Appointment appointment) {
        removeFromAppointments(appointment);
        removeFromPatient(appointment);
        removeFromDoctor(appointment);
    }

    private void removeFromPatient(Appointment appointment) {
        Patient patient = appointment.getPatient();
        List<Appointment> appointmentList = patientAppointment.get(patient);
        if (appointmentList != null) {
            removeAppointment(appointment, appointmentList.iterator());
        }
        if (patientAppointment.get(patient).isEmpty()) {
            patientAppointment.remove(patient);
        }
    }

    private void removeFromDoctor(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        List<Appointment> appointmentList = doctorAppointment.get(doctor);
        if (appointmentList != null) {
            removeAppointment(appointment, appointmentList.iterator());
        }
        if (doctorAppointment.get(doctor).isEmpty()) {
            doctorAppointment.remove(doctor);
        }
    }

    private void removeFromAppointments(Appointment appointment) {
        removeAppointment(appointment, appointments.iterator());
    }

    private void removeAppointment(Appointment appointment, Iterator<Appointment> i) {
        while (i.hasNext()) {
            if (i.next().equals(appointment)){
                i.remove();
                return;
            }
        }
    }
}
