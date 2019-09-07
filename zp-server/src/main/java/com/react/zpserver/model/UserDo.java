package com.react.zpserver.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserDo implements Serializable {

    private static final long serialVersionUID = 6777497212440718695L;

    private String id;
    //用户名
    @NotBlank(message = "username 不能为空")
    private String username;
    //密码
    @NotBlank(message = "password 不能为空")
    private String password;
    //用户类型 dashen/laoban
    @NotBlank(message = "type 不能为空")
    private String type;
    //头像
//    @NotBlank(message = "header 不能为空")
    private String header;
    //职位
    private String post;
    //个人或职位简介
    private String info;
    //公司名称
    private String company;
    //月薪
    private String salary;
    private String createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", header='" + header + '\'' +
                ", post='" + post + '\'' +
                ", info='" + info + '\'' +
                ", company='" + company + '\'' +
                ", salary='" + salary + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
