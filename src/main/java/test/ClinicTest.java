package test;

import model.Doctor;
import model.Gender;
import model.Patient;
import model.PatientVIP;
import org.joda.time.DateTime;
import utils.AppointmentHelper;

import java.util.Set;

/**
 * Created by iushakova on 19/07/15.
 */
public class ClinicTest {

    public static void main(String[] args) {

        Patient patient1 = new Patient("Markus", "Igel", Gender.MALE, new DateTime());
        Patient patient2 = new Patient("Carlos", "Abarca", Gender.MALE, new DateTime());

        PatientVIP patientVIP = new PatientVIP("Egor", "Popelyaev", Gender.MALE, new DateTime(), 30.0f);

        System.out.println(patient1);
        System.out.println(patient2);
        System.out.println(patientVIP);

        Doctor doctor1 = new Doctor("Katja", "Sommer", "Augenartzt");
        Doctor doctor2 = new Doctor("Julian", "Fleischer", "Hautartzt");

        System.out.println(doctor1);
        System.out.println(doctor2);

        DateTime dateTime = new DateTime();

        AppointmentHelper.createAppointment(patient1, doctor1, dateTime);
        AppointmentHelper.createAppointment(patient1, doctor1, new DateTime());
        AppointmentHelper.createAppointment(patient1, doctor2, dateTime);
        AppointmentHelper.createAppointment(patientVIP, doctor2, new DateTime());

        AppointmentHelper.cancelAppointment(patient1, doctor2, dateTime);

        AppointmentHelper.listAppointmentByPatient(patient1);
        AppointmentHelper.listAppointmentByDoctor(doctor2);
        AppointmentHelper.listAllAppointments();



    }
}
