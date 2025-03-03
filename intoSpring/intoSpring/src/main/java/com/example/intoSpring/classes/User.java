package com.example.intoSpring.classes;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String lastname;
    private String city;
    private Integer age;
    private String email;

    public User(String name, String lastname, String city, Integer age, String email) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.email = email;
    }

    public void setAge(Integer age) {
        if(age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }
}
