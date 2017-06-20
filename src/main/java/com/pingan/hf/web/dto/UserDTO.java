package com.pingan.hf.web.dto;

import java.util.UUID;

/**
 * User: zhongjun
 * Date: 2017/6/20
 * Time: 21:48
 */
public class UserDTO {

    private String userName;

    private String passWord;

    private String uuid = UUID.randomUUID().toString();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
