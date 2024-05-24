package com.course.exceptions.four_proyect.services;

import com.course.exceptions.four_proyect.Models.domain.User;

import java.util.List;

public interface IUserService {
    List<User>findAll();
    User findById(Long id);
}
