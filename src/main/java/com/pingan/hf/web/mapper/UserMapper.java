package com.pingan.hf.web.mapper;

import com.pingan.hf.web.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface UserMapper {

    public List<User> findUsers();

    public User getUserByName(String userName);
}
