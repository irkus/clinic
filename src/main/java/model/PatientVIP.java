package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by iushakova on 19/07/15.
 */
public class PatientVIP extends Patient {

    private float discount;

    public PatientVIP(String firstName, String lastName, Gender gender, DateTime dob, float discount) {
        super(firstName, lastName, gender, dob);
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientVIP)) return false;
        if (!super.equals(o)) return false;

        PatientVIP that = (PatientVIP) o;

        if (Float.compare(that.discount, discount) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }
}
