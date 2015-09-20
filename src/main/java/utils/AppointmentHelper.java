package utils;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Schedule;
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

    public static void createAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment newAppointment = new Appointment(patient, doctor, dateTime);
        Schedule.addAppointment(newAppointment);
    }

    public static void listAllAppointments() {
        for (Appointment appointment : Schedule.getAppointments()) {
            if ( new DateTime().compareTo(appointment.getDateTime()) > 0) {
                System.out.println(appointment);
            }
        }
    }

    public static void listAppointmentByPatient(Patient patient) {
        System.out.println(Schedule.getAppointments(patient));
    }

    public static void listAppointmentByDoctor(Doctor doctor) {
        System.out.println(Schedule.getAppointments(doctor));
    }

    public static void cancelAppointment(Patient patient, Doctor doctor, DateTime dateTime) {
        Appointment appointment = new Appointment(patient, doctor, dateTime);
        Schedule.removeAppointment(appointment);
    }

}
