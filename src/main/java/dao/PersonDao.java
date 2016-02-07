package dao;

import model.Doctor;
import model.PatientVIP;
import model.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by iushakova on 24/01/16.
 */
public class PersonDao {

    private Connection connection;

    public PersonDao(Connection connection) {
        this.connection = connection;
    }

    private static final String PERSONS_INSERT = "INSERT INTO persons (first_name, middle_name, last_name, isDoctor, " +
            "gender, address, speciality, discount, dob) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void addPerson(Person person){
        try {
            PreparedStatement statement = connection.prepareStatement(PERSONS_INSERT);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getMiddleName());
            statement.setString(3, person.getLastName());
            statement.setBoolean(4, person.isDoctor());
            statement.setString(5, person.getGender().toString());
            statement.setString(6, person.getAddress());
            statement.setString(7, null);
            if (person instanceof Doctor) {
                statement.setString(7, ((Doctor) person).getSpeciality());
            }
            statement.setDate(8, null);
            if (person instanceof PatientVIP) {
                statement.setDouble(8, ((PatientVIP) person).getDiscount());
            }
            statement.setDate(9, new Date(person.getDob().getMillis()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void removePerson(Person person) {

    }
}
