package com.example.introSpringDI.DependencyInjection;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String fullname;
    //private EuropeanAddress address = new EuropeanAddress("Via Marconi 1", "Roma", "Italia");
    private Address address;
    private Phone phone;

//    public User(String fullname) {
//        this.fullname = fullname;
//        this.address = new EuropeanAddress("Via Marconi 1", "Roma", "Italia");
//        this.phone = new Phone("+39 123.456.789");
//    }


    public User(String fullname, Address address, Phone phone) {
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
    }
}
