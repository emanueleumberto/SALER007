package com.example.SpringDataJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String city;
    private Integer age;
    private String email;

}
