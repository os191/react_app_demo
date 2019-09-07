package com.react.zpserver.bean;

import java.io.Serializable;

/**
 * 注册接受参数对象
 */
public class RegisterVO implements Serializable {

    private String username;
    private String id;
    private String type;

    public static RegisterVO of(String username, String id, String type){
        RegisterVO bean = new RegisterVO();
        bean.setUsername(username);
        bean.setId(id);
        bean.setType(type);
        return bean;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
