package test;

import model.Doctor;
import Utils.FileUtils;
import model.Gender;
import model.Patient;
import model.PatientVIP;
import Impl.ScheduleInFile;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import model.AppointmentOperation;

/**
 * Created by iushakova on 19/07/15.
 */
public class ClinicTest {
    private final static Logger LOGGER = Logger.getLogger(ClinicTest.class);

    //TODO: file path should be in class path
    private static final String APPOINTMENT_FILENAME = "/Users/iushakova/Documents/workspace/clinic/src/main/resources/appointment.csv";
//    private static final String PATIENT_FILENAME = "patient.csv";
//    private static final String DOCTOR_FILENAME = "doctor.csv";

    public static void main(String[] args) {

//        FileUtils.delete(APPOINTMENT_FILENAME);
//
//        Patient patient1 = new Patient("Markus", "Igel", Gender.MALE, new DateTime());
//        Patient patient2 = new Patient("Carlos", "Abarca", Gender.MALE, new DateTime());
//
//        PatientVIP patientVIP = new PatientVIP("Egor", "Popelyaev", Gender.MALE, new DateTime(), 30.0f);
//
//        Doctor doctor1 = new Doctor("Katja", "Sommer", "Augenartzt");
//        Doctor doctor2 = new Doctor("Julian", "Fleischer", "Hautartzt");
//
//        DateTime dateTime = new DateTime();
//
//
//
//        AppointmentOperation appointmentOperation = new AppointmentOperation(new ScheduleInFile(APPOINTMENT_FILENAME));
//
//
//        appointmentOperation.createAppointment(patient1, doctor1, dateTime);
//        appointmentOperation.createAppointment(patient1, doctor1, new DateTime());
//        appointmentOperation.createAppointment(patient1, doctor2, dateTime);
////        AppointmentOperation.createAppointment(patientVIP, doctor2, new DateTime());
//
//        appointmentOperation.listAppointmentByPatient(patient1);
//        appointmentOperation.listAppointmentByDoctor(doctor2);
//        appointmentOperation.listAllAppointments();
//
//        appointmentOperation.cancelAppointment(patient1, doctor2, dateTime);
//
//        appointmentOperation.listAppointmentByPatient(patient1);
//        appointmentOperation.listAppointmentByDoctor(doctor2);
//        appointmentOperation.listAllAppointments();



    }
}
