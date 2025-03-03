package com.example.intoSpring.component;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component("user_component")
@Scope("prototype")
public class UserComponent {

    private Long id;
    private String name;
    private String lastname;
    private String city;
    private Integer age;
    private String email;

    public UserComponent(String name, String lastname, String city, Integer age, String email) {
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
