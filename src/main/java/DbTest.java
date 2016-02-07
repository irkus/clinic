/**
 * Created by iushakova on 06/01/16.
 */

import Impl.PersonInDB;
import dao.PersonDao;
import model.Doctor;
import model.Gender;
import model.Patient;
import model.Person;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.logging.*;

import javax.print.Doc;

public class DbTest {

    private static final Logger logger = Logger.getLogger(DbTest.class.getName());

    private static final String PERSONS = "CREATE TABLE IF NOT EXISTS persons\n" +
            "(\n" +
            "  id serial CONSTRAINT person_id_pk PRIMARY KEY,\n" +
            "  first_name text NOT NULL,\n" +
            "  middle_name text,\n" +
            "  last_name text NOT NULL,\n" +
            "  isDoctor boolean NOT NULL,\n" +
            "  gender text,\n" +
            "  address text,\n" +
            "  speciality text,\n" +
            "  discount text,\n" +
            "  dob date \n" +
            ")";

    private static final String PERSONS_INSERT = "INSERT INTO persons (first_name, last_name, gender, dob) " +
            "VALUES (?, ?, ?, ?)";
    private static final String PERSONS_SELECT = "SELECT * FROM persons";

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:postgresql://127.0.0.1:5432/testDB";
        String name = "postgres";
        String password = "R17smZ456";
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, name, password)) {
            Statement statement = connection.createStatement();
            logger.log(Level.INFO, PERSONS);
            statement.execute(PERSONS);

            PersonDao personDao = new PersonDao(connection);
            PersonInDB personInDB = new PersonInDB(personDao);

            Doctor doctor1 = Doctor.builder()
                    .firstName("Vasily")
                    .lastName("Chapaev")
                    .gender(Gender.MALE)
                    .speciality("Teamleiter")
                    .dob(new DateTime(1887, 1, 9, 12, 0, 0, 0))
                    .build();
            personInDB.addDoctor(doctor1);

            Patient patient1 = Patient.builder()
                    .firstName("Anna")
                    .lastName("Pulemetchitsa")
                    .gender(Gender.FEMALE)
                    .dob(new DateTime(1897, 7, 7, 12, 0, 0, 0))
                    .build();
            personInDB.addPatient(patient1);



//            PreparedStatement pStatement = connection.prepareStatement(PERSONS_INSERT);
//            pStatement.setString(1, "first_name");
//            pStatement.setString(2, "last_name");
//            pStatement.setString(3, "MALE");
//            pStatement.setDate(4, new Date(new DateTime().getMillis()));
//            pStatement.execute();
//
//            pStatement = connection.prepareStatement(PERSONS_SELECT);
//            ResultSet resultSet = pStatement.executeQuery();

//            List<Person> persons = new ArrayList<>();
//            while (resultSet.next()) {
//                Person person = Person.builder()
//                        .firstName(resultSet.getString("first_name"))
//                        .lastName(resultSet.getString("last_name"))
//                        .gender(resultSet.getString("gender"))
//                        .dob(new DateTime(resultSet.getDate("dob")))
//                        .build();
//                persons.add(person);
//            }

//            System.out.println("Persons: " + persons);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }
}
