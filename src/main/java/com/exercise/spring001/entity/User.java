package com.exercise.spring001.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)//Significa que o EMAIL eh unico, nao pode cadastrar 2 usuario com mesmo email
    private String email;

    @Column(name = "name")
    private String name;

}
