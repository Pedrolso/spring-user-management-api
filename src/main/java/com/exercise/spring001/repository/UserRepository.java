package com.exercise.spring001.repository;

import com.exercise.spring001.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {//nome da tabela"User" tipo de id"Integer"

    Optional<User> findByEmail(String email);//Optional evita o nullPointexception. mas devo criar uma excecao ou alternativa caso nao exista o email

    @Transactional //Para caso de algum erro, ele NAO pode deletar
    void deleteByEmail(String email);

}
