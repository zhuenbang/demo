package com.example.demo.vo;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/30 18:34
 */
public class TestUser {
    private Integer id;
    private String userName;
    private String address;

    public Integer getId() {
        return id;
    }

    public TestUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TestUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TestUser setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
