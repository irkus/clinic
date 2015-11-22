package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Created by iushakova on 19/07/15.
 */
public class Patient {

    private static int lastId;

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private DateTime dob;

    public Patient(String firstName, String lastName, Gender gender, DateTime dob) {
        this.id = lastId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
    }

    public Patient(int id, String firstName, String lastName, Gender gender, DateTime dob) {
        this.id = id;
        lastId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public DateTime getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }



    // TODO: override equals and hashCode with builders


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (!dob.equals(patient.dob)) return false;
        if (!firstName.equals(patient.firstName)) return false;
        if (gender != patient.gender) return false;
        if (!lastName.equals(patient.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }
}

