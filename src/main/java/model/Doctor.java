package model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by iushakova on 25/07/15.
 */
public class Doctor {

    private static int lastId;

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String speciality;

    public Doctor(String lastName, String firstName, String speciality) {
        this.id = lastId++;
        this.speciality = speciality;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // TODO: override equals and hashCode with builders

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        if (id != doctor.id) return false;
        if (!firstName.equals(doctor.firstName)) return false;
        if (gender != doctor.gender) return false;
        if (!lastName.equals(doctor.lastName)) return false;
        if (!speciality.equals(doctor.speciality)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + speciality.hashCode();
        return result;
    }
}
