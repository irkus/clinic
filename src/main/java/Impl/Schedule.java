package Impl;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.List;

/**
 * Created by iushakova on 08/11/15.
 */
public interface Schedule {

    void addAppointment(Appointment newAppointment);

    void removeAppointment(Appointment appointment);

    List<Appointment> getAppointments();

    List<Appointment> getAppointments(Patient patient);

    List<Appointment> getAppointments(Doctor doctor);

}
