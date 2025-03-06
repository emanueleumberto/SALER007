package com.example.GestionePizzeriaJDBC.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Cliente {

    private Long id;
    private String nome;
    private String telefono;

}
