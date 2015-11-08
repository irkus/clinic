package test;

import model.Doctor;
import model.Gender;
import model.Patient;
import model.PatientVIP;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import utils.AppointmentHelper;

import java.util.Set;

/**
 * Created by iushakova on 19/07/15.
 */
public class ClinicTest {
    private final static Logger LOGGER = Logger.getLogger(ClinicTest.class);


    public static void main(String[] args) {

        Patient patient1 = new Patient("Markus", "Igel", Gender.MALE, new DateTime());
        Patient patient2 = new Patient("Carlos", "Abarca", Gender.MALE, new DateTime());

        PatientVIP patientVIP = new PatientVIP("Egor", "Popelyaev", Gender.MALE, new DateTime(), 30.0f);


        Doctor doctor1 = new Doctor("Katja", "Sommer", "Augenartzt");
        Doctor doctor2 = new Doctor("Julian", "Fleischer", "Hautartzt");

        DateTime dateTime = new DateTime();

        AppointmentHelper.createAppointment(patient1, doctor1, dateTime);
        AppointmentHelper.createAppointment(patient1, doctor1, new DateTime());
        AppointmentHelper.createAppointment(patient1, doctor2, dateTime);
//        AppointmentHelper.createAppointment(patientVIP, doctor2, new DateTime());

        AppointmentHelper.listAppointmentByPatient(patient1);
        AppointmentHelper.listAppointmentByDoctor(doctor2);
        AppointmentHelper.listAllAppointments();

        AppointmentHelper.cancelAppointment(patient1, doctor2, dateTime);

        AppointmentHelper.listAppointmentByPatient(patient1);
        AppointmentHelper.listAppointmentByDoctor(doctor2);
        AppointmentHelper.listAllAppointments();



    }
}
