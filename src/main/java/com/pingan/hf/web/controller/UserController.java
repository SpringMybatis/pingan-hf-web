package com.pingan.hf.web.controller;

import com.pingan.hf.web.dto.UserDTO;
import com.pingan.hf.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: zhongjun
 * Date: 2017/6/20
 * Time: 21:56
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<UserDTO> findUsers(){
        return userService.findUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public UserDTO getUserByName(@RequestParam("userName") String userName){
        return userService.getUserByName(userName);
    }

}
