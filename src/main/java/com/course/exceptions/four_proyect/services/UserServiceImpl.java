package com.course.exceptions.four_proyect.services;

import com.course.exceptions.four_proyect.Models.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    private List<User>userList;
    public UserServiceImpl() {
        this.userList = new ArrayList<>();
        userList.add(new User(1L,"Patrick","Woods",null ));
        userList.add(new User(1L,"Laura","Tiger",null));
        userList.add(new User(1L,"Andrew","Winters",null));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        for (User u:userList) {
            if(u.getId().equals(id)){
                user=u;
            }
        }
        return user;
    }
}
