package com.example.introSpringDI.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {

    private String firstname;
    private String lastname;
    private String city;
    private Integer age;
    private String email;

}
