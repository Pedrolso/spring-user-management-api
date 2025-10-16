package com.exercise.spring001.controller;

import com.exercise.spring001.DTO.UserRequestDTO;
import com.exercise.spring001.DTO.UserResponseDTO;
import com.exercise.spring001.entity.User;
import com.exercise.spring001.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO dto) {
        User user = userService.saveUser(dto);
        UserResponseDTO response = UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> findUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        UserResponseDTO response = UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<UserResponseDTO> deleteUserByEmail(@RequestParam String email) {
        User user = userService.deleteByEmail(email);
        UserResponseDTO response = UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateById(@RequestParam Integer id, @RequestBody User user) {//ARRUMAR
        User update = userService.updateUserById(id, user);
        UserResponseDTO responseDTO = UserResponseDTO.builder()
                .id(update.getId())
                .email(update.getEmail())
                .name(update.getName())
                .build();
        return ResponseEntity.ok(responseDTO);
    }

}

