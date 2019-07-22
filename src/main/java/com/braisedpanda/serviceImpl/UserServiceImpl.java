package com.braisedpanda.serviceImpl;

import com.braisedpanda.bean.User;
import com.braisedpanda.mapper.UserMapper;
import com.braisedpanda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(String uid) {
      User user =   userMapper.getUserById(uid);
        return user;
    }



    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User findUser(String username,String password) {
       User user1 = userMapper.findUser(username,password);
       return user1;
    }

    @Override
    public List<User> findAllUsers() {
       List<User> userList =  userMapper.findAllUsers();
       return userList;
    }

    @Override
    public List<User> findUserByUsername(String username) {
       List<User> userList =  userMapper.findUserByUsername(username);
       return userList;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(String uid) {
        userMapper.delete(uid);
    }
}
