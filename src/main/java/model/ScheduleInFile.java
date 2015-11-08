package model;

import java.util.List;

/**
 * Created by iushakova on 08/11/15.
 */
public class ScheduleInFile implements Schedule {

    private static final String PATIENT_FILENAME = "patient.csv";
    private static final String DOCTOR_FILENAME = "patient.csv";
    private static final String APPONTMENT_FILENAME = "patient.csv";

    @Override
    public void addAppointment(Appointment newAppointment) {

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

    @Override
    public void removeAppointment(Appointment appointment) {

    }
}
