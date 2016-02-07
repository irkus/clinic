package Impl;

import dao.PersonDao;
import model.Doctor;
import model.Gender;
import model.Patient;
import model.Person;
import org.joda.time.DateTime;


/**
 * Created by iushakova on 24/01/16.
 */
public class PersonInDB {

    PersonDao personDao;

    public PersonInDB(PersonDao personDao) {
        this.personDao = personDao;
    }


    public void addDoctor(Doctor doctor){
        personDao.addPerson(doctor);
    }

    public void addDoctor(String firstName, String middleName, String lastName, Gender gender,
                          String address, DateTime dob, String speciality){
        Doctor person = Doctor.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .gender(gender)
                .address(address)
                .dob(dob)
                .speciality(speciality)
                .build();
        addDoctor(person);
    }

    public void addPatient(Patient patient){
        personDao.addPerson(patient);
    }

    public void addPatient(String firstName, String middleName, String lastName, Gender gender,
                           String address, DateTime dob){
        Patient patient = Patient.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .gender(gender)
                .address(address)
                .dob(dob)
                .build();
        addPatient(patient);
    }


}
