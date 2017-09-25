package com.pingan.hf.web.service;

import com.pingan.hf.web.dto.UserDTO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface UserService {

    public List<UserDTO> findUsers();

    public UserDTO getUserByName(String userName);

}
