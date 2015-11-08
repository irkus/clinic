package utils;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Schedule;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.print.attribute.standard.SheetCollate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by iushakova on 25/07/15.
 */
public class AppointmentHelper {

    private final static Logger LOGGER = Logger.getLogger(AppointmentHelper.class);

    public static void createAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment newAppointment = new Appointment(patient, doctor, dateTime);
        Schedule.addAppointment(newAppointment);
    }

    public static void listAllAppointments() {
        StringBuilder sb = new StringBuilder();
        for (Appointment appointment : Schedule.getAppointments()) {
            if (new DateTime().compareTo(appointment.getDateTime()) > 0) {
                sb.append(appointment);
            }
        }
        LOGGER.debug("All actual appointments:\n" + sb);
    }


    public static void listAppointmentByPatient(Patient patient) {
        String patientName = patient.getFirstName() + " " + patient.getLastName();
        LOGGER.debug("Appointment list by patient " + patientName + ":\n" + Schedule.getAppointments(patient));
    }

    public static void listAppointmentByDoctor(Doctor doctor) {
        String doctorName = doctor.getFirstName() + " " + doctor.getLastName();
        LOGGER.debug("Appointment list by doctor " + doctorName + ":\n" + Schedule.getAppointments(doctor));
    }

    public static void cancelAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment appointment = new Appointment(patient, doctor, dateTime);
        Schedule.removeAppointment(appointment);
    }

}
