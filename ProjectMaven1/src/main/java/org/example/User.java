package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private String name;
    private String lastname;
    private String city;
    private int age;
    private List<String> hobby;

    public User(String name, String lastname, String city, int age) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.hobby = new ArrayList<String>();
        /*if(age > 70) {
            this.age = 70;
            throw new RuntimeException("Età maggiore di 70");
        } else {
            this.age = age;
        }*/
    }

    public void addHobby(String h) {
        this.hobby.add(h);
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(this.hobby.toArray()) +
                '}';
    }
}
