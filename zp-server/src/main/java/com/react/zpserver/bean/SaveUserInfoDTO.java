package com.react.zpserver.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 保存补充信息
 */
public class SaveUserInfoDTO implements Serializable {
    private static final long serialVersionUID = -4311703908010326937L;

    private Long id;
    private String header;
    private String post;
    private String info;
    private String company;
    private BigDecimal salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SaveUserInfoDTO{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", post='" + post + '\'' +
                ", info='" + info + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
