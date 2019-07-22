package com.braisedpanda.mapper;

import com.braisedpanda.bean.User;
import org.apache.ibatis.annotations.Mapper;
;import java.util.List;

@Mapper
public interface UserMapper {

     User getUserById(String uid);




    void addUser(User user);


    User findUser(String username, String password);

    List<User> findAllUsers();

    List<User> findUserByUsername(String username);

    void update(User user);

    void delete(String uid);
}
