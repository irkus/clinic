package model;

import lombok.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by iushakova on 19/07/15.
 */

public class PatientVIP extends Patient {

    private float discount;

//    TODO: @Builder
    public PatientVIP(String firstName, String middleName, String lastName, Gender gender, String address, DateTime dob, float discount) {
        super(firstName, middleName, lastName, gender, address, dob);
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PatientVIP)) return false;

        PatientVIP that = (PatientVIP) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(discount, that.discount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(discount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(super.toString())
                .append("discount", discount)
                .toString();
    }
}
