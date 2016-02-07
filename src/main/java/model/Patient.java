package model;

import lombok.Builder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Created by iushakova on 19/07/15.
 */

public class Patient extends Person{

    @Builder
    public Patient(String firstName, String middleName, String lastName, Gender gender, String address, DateTime dob) {
        super(firstName, middleName, lastName, false, gender, address, dob);
    }
}

