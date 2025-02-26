package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String db_name = "saler007java";
    private Statement st;
    private Connection conn;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        System.out.println("DB Connesso!!");
        createDatabase();
        createTableUsers();
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + this.db_name;
        st.executeUpdate(sql);
        System.out.println("DB " + this.db_name + " connesso!!");
        conn = DriverManager.getConnection(url+db_name, user, pass);
        st = conn.createStatement();
    }

    private void createTableUsers() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "firstname VARCHAR(50) NOT NULL," +
                "lastname VARCHAR(50) NOT NULL," +
                "age INT UNSIGNED NULL ," +
                "city VARCHAR(50) NULL," +
                "email VARCHAR(100) NOT NULL UNIQUE" +
                ")";
        st.executeUpdate(sql);
        System.out.println("Table users creata!!");
    }

    // CRUD
    public void insertUser(User u) throws SQLException {
        String sql = "INSERT INTO users(firstname, lastname, age, city, email) " +
                     "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getFirstname());
        ps.setString(2, u.getLastname());
        ps.setInt(3, u.getAge());
        ps.setString(4, u.getCity());
        ps.setString(5, u.getEmail());
        ps.executeUpdate();
        System.out.println(u.getFirstname() + " " + u.getLastname() + " salvato nel DB!!");
    }

    public User findUser(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = " + id;
        ResultSet rs = st.executeQuery(sql);

        User u = null;
        if(rs.next()) {
          int user_id = rs.getInt("user_id");
          String firstname = rs.getString("firstname");
          String lastname = rs.getString("lastname");
          int age = rs.getInt("age");
          String city = rs.getString("city");
          String email = rs.getString("email");
          u = new User(user_id, firstname, lastname, age, city, email);
        }
        return u;
    }

    public void updateUser(User u) throws SQLException {
        String sql = "UPDATE users SET firstname = ?, lastname = ?, age = ?, city = ?, email = ? " +
                     "WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getFirstname());
        ps.setString(2, u.getLastname());
        ps.setInt(3, u.getAge());
        ps.setString(4, u.getCity());
        ps.setString(5, u.getEmail());
        ps.setInt(6, u.getUser_id());
        ps.executeUpdate();
        System.out.println(u.getFirstname() + " " + u.getLastname() + " modificato nel DB!!");
    }

    public void removeUser(User u) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, u.getUser_id());
        ps.executeUpdate();
        System.out.println(u.getFirstname() + " " + u.getLastname() + " eliminato dal DB!!");
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(sql);
        List<User> lista = new ArrayList<User>();
        while (rs.next()) {
            int user_id = rs.getInt("user_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            int age = rs.getInt("age");
            String city = rs.getString("city");
            String email = rs.getString("email");
            User u = new User(user_id, firstname, lastname, age, city, email);
            lista.add(u);
        }
        return lista;
    }

}
