package com.exercise.spring001.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {//USAR QUANDO API RETORNA DADOS. "GET, POST, PUT, DELETE"
    private Integer id;
    private String email;
    private String name;

}
