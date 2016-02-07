package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Created by iushakova on 22/11/15.
 */
@AllArgsConstructor
public abstract class Person {

    @NonNull
    protected final String firstName;

    protected final String middleName;

    @NonNull
    protected final String lastName;

    protected final boolean isDoctor;

    protected final Gender gender;

    protected final String address;

    protected final DateTime dob;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public DateTime getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(isDoctor, person.isDoctor)
                .append(firstName, person.firstName)
                .append(middleName, person.middleName)
                .append(lastName, person.lastName)
                .append(gender, person.gender)
                .append(address, person.address)
                .append(dob, person.dob)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(isDoctor)
                .append(gender)
                .append(address)
                .append(dob)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("middleName", middleName)
                .append("lastName", lastName)
                .append("isDoctor", isDoctor)
                .append("gender", gender)
                .append("address", address)
                .append("dob", dob)
                .toString();
    }
}
