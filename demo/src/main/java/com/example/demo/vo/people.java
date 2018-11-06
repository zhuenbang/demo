package com.example.demo.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhuenbang
 * @description
 * @date 2018/9/3 19:22
 */
public class people {
    private String name;
    private Integer age;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
