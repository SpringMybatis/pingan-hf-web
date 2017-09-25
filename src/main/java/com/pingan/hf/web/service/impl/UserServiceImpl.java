package com.pingan.hf.web.service.impl;

import com.pingan.hf.web.dto.UserDTO;
import com.pingan.hf.web.mapper.UserMapper;
import com.pingan.hf.web.model.User;
import com.pingan.hf.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhongjun
 * Date: 2017/6/20
 * Time: 21:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> findUsers() {

        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        List<User> users = userMapper.findUsers();
        if (null != users && !users.isEmpty()) {
            for (User user : users) {
                UserDTO dto = new UserDTO();
                dto.setUserName(user.getUserName());
                dto.setPassWord(user.getPassWord());
                userDTOS.add(dto);
            }
        }
        return userDTOS;
    }

    public UserDTO getUserByName(String userName) {
        User user = userMapper.getUserByName(userName);
        if (user != null) {
            UserDTO dto = new UserDTO();
            dto.setUserName(user.getUserName());
            dto.setPassWord(user.getPassWord());
            return dto;
        }
        return null;
    }
}
