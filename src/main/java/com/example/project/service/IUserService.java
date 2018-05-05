package com.example.project.service;

import com.example.project.dto.UserDTO;
import com.example.project.entity.User;

public interface IUserService {

    User findUserByName(String username);

    ServiceResult<UserDTO> findById(Long userId);
}
