package com.react.zpserver.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *直聘用户表
 */
public class ZpUserDO implements Serializable {
    private static final long serialVersionUID = -2157248936047541034L;
    private Long id;
    private String username;
    private String password;
    private String type;
    private String header;
    private String post;
    private String info;
    private String company;
    private BigDecimal salary;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ZpUserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", header='" + header + '\'' +
                ", post='" + post + '\'' +
                ", info='" + info + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
