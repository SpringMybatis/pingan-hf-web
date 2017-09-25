package com.pingan.hf.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingan.hf.web.dto.UserDTO;
import com.pingan.hf.web.dwr.HelloService;
import com.pingan.hf.web.service.UserService;

/**
 * User: zhongjun
 * Date: 2017/6/20
 * Time: 21:56
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<UserDTO> findUsers(){
    	helloService.printUser();
        return userService.findUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public UserDTO getUserByName(@RequestParam("userName") String userName){
        return userService.getUserByName(userName);
    }

}
