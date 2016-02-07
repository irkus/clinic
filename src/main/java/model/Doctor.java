package model;

import lombok.Builder;
import lombok.NonNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Created by iushakova on 25/07/15.
 */

public class Doctor extends Person {

    @NonNull
    private String speciality;

    @Builder
    public Doctor(String firstName, String middleName, String lastName, Gender gender, String address, DateTime dob, String speciality) {
        super(firstName, middleName, lastName, true, gender, address, dob);
        this.speciality = speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(speciality, doctor.speciality)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(speciality)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("speciality", speciality)
                .toString();
    }
}
