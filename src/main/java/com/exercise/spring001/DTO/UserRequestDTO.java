package com.exercise.spring001.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {//USAR QUANDO ENVIA DADOS PARA API. "POST, PUT, PATH"
    private String email;
    private String name;

}
