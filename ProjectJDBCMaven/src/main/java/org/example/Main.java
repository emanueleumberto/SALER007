package org.example;

import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Main  {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static DBConnection db;

    public static void main( String[] args ) {
        try {
            db = new DBConnection();
            //popolaDatabase(10);

            // User u = new User("Mario", "Rossi", 45, "Roma", "m.rossi@example.com");
            // db.insertUser(u);

            //User u = db.findUser(1);
            // u.setCity("Milano");
            // db.updateUser(u);
            //System.out.println(u);

            //db.removeUser(u);

            db.findAll().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void popolaDatabase(int n) throws SQLException {
        for (int i = 0; i < n ; i++) {
            String name = fake.name().firstName();
            String lastname = fake.name().lastName();
            User u = new User(
                    name,
                    lastname,
                    fake.number().numberBetween(18,80),
                    fake.address().cityName(),
                    name+"."+lastname+"@example.com"
            );
            db.insertUser(u);
        }
    }
}
