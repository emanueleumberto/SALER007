package org.example;

public class User {

    private String name;
    private String lastname;
    private String city;
    private int age;

    public User(String name, String lastname, String city, int age) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        if(age > 70) {
            this.age = 70;
            throw new RuntimeException("Età maggiore di 70");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
