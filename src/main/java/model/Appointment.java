package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;


public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private DateTime dateTime;

    public Appointment(Patient patient, Doctor doctor, DateTime dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment that = (Appointment) o;

        if (!dateTime.equals(that.dateTime)) return false;
        if (!doctor.equals(that.doctor)) return false;
        if (!patient.equals(that.patient)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patient.hashCode();
        result = 31 * result + doctor.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }
}
