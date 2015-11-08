package model;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * Created by iushakova on 25/07/15.
 */
public class AppointmentOperation {

    private final static Logger LOGGER = Logger.getLogger(AppointmentOperation.class);

    Schedule schedule;

    public void createAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment newAppointment = new Appointment(patient, doctor, dateTime);
        schedule.addAppointment(newAppointment);
    }

    public void listAllAppointments() {
        StringBuilder sb = new StringBuilder();
        for (Appointment appointment : schedule.getAppointments()) {
            if (new DateTime().compareTo(appointment.getDateTime()) > 0) {
                sb.append(appointment);
            }
        }
        LOGGER.debug("All actual appointments:\n" + sb);
    }

    public void listAppointmentByPatient(Patient patient) {
        String patientName = patient.getFirstName() + " " + patient.getLastName();
        LOGGER.debug("Appointment list by patient " + patientName + ":\n" + schedule.getAppointments(patient));
    }

    public void listAppointmentByDoctor(Doctor doctor) {
        String doctorName = doctor.getFirstName() + " " + doctor.getLastName();
        LOGGER.debug("Appointment list by doctor " + doctorName + ":\n" + schedule.getAppointments(doctor));
    }

    public void cancelAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment appointment = new Appointment(patient, doctor, dateTime);
        schedule.removeAppointment(appointment);
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
