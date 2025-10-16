package com.exercise.spring001.service;

import com.exercise.spring001.DTO.UserRequestDTO;
import com.exercise.spring001.entity.User;
import com.exercise.spring001.exception.UserConflictException;
import com.exercise.spring001.exception.UserException;
import com.exercise.spring001.exception.UserNotFound;
import com.exercise.spring001.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(UserRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserConflictException("Email already exists: -----service" + dto.getEmail());
        }
        User user = User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .build();
        return repository.saveAndFlush(user);//Salva e fecha a conexao com o banco de dados.
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new UserException("User not found. ------service" + email)
        );
    }

    public User deleteByEmail(String email) {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFound("User not found with email:  ----service " + email));

        repository.deleteByEmail(email);
        return user;
    }

    public User updateUserById(Integer id, User user) { //ID do OBJ, User o novo usuario digitado no postman
        User userEntity = repository.findById(id).orElseThrow(() ->
                new UserNotFound("ID User not found: ---service"));

        User userUpdate = User.builder()
                .email(user.getEmail() != null ?
                        user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ?
                        user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        return repository.saveAndFlush(userUpdate);
    }

}

