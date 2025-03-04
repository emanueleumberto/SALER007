package com.example.introSpringDI.DependencyInjection;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EuropeanAddress implements Address {

    private String street;
    private String city;
    private String state;

}
