package com.example.introSpringDI.LooseCoupling;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {

    private int numOrd;
    private List<String> listaProdotti;
    private double totalOrder;

}
