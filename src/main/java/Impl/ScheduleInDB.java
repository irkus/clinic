package Impl;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.List;

/**
 * Created by iushakova on 24/01/16.
 */
public class ScheduleInDB implements Schedule {

    @Override
    public void addAppointment(Appointment newAppointment) {

    }

    @Override
    public void removeAppointment(Appointment appointment) {

    }

    @Override
    public List<Appointment> getAppointments() {
        return null;
    }

    @Override
    public List<Appointment> getAppointments(Patient patient) {
        return null;
    }

    @Override
    public List<Appointment> getAppointments(Doctor doctor) {
        return null;
    }
}
