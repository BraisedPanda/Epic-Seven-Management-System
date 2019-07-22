package com.braisedpanda.service;

import com.braisedpanda.bean.User;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
public interface UserService {



//    @Cacheable(value = {"user"},key="#uid")
     User findUserById(String uid);




    void addUser(User user);
//    @Cacheable(value={"user"},key="#user.uid")
    User findUser(String username,String password);

    List<User> findAllUsers();

    List<User> findUserByUsername(String username);

    void update(User user);

    void delete(String uid);
}
