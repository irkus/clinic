package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by iushakova on 25/07/15.
 */
// How to make the constructor is visible only for helper?
//    How to pass VIP or normal patient? How to make it more generic? Just pass VIP as Patient object?

public class Appointment {
    private static int lastId;

    private int id;
    private Patient patient;
    private Doctor doctor;
    private DateTime dateTime;

    public Appointment(Patient patient, Doctor doctor, DateTime dateTime) {
        this.id = lastId++;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
