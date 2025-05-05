package com.example.userservice.service;

import com.example.userservice.dto.*;
import com.example.userservice.entity.User;
import com.example.userservice.exception.*;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto registerUser(UserRequestDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + dto.getEmail());
        }

        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);
        return mapToDto(saved);
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return mapToDto(user);
    }

    private UserResponseDto mapToDto(User user) {
        return new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.getRole());
    }
}

