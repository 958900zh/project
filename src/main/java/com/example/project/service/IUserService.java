package com.example.project.service;

import com.example.project.entity.User;

public interface IUserService {

    User findUserByName(String username);
}
