package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by iushakova on 25/07/15.
 */
public class Doctor {

    private static int lastId;

    private int id;
    private String firstName;
    private String lastName;
    private String speciality;

    public Doctor(String lastName, String firstName, String speciality) {
        this.id = lastId++;
        this.speciality = speciality;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Doctor(int id, String lastName, String firstName, String speciality) {
        this.id = id;
        lastId = id;
        this.speciality = speciality;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        return new EqualsBuilder()
                .append(id, doctor.id)
                .append(firstName, doctor.firstName)
                .append(lastName, doctor.lastName)
                .append(speciality, doctor.speciality)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(speciality)
                .toHashCode();
    }
}
