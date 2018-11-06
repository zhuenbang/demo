package com.example.demo.db.entity;
import com.example.demo.common.BaseEntity;

import javax.persistence.*;

/**专家类别表
 * @author zhuenbang
 * @description
 * @date 2018/7/20 10:04
 */
@Entity
@Table(name = "user_test")
public class UserTest extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private Integer age;
    private Boolean isShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getShow() {
        return isShow;
    }
    public UserTest setShow(Boolean show) {
        isShow = show;
        return this;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", isShow=" + isShow +
                '}';
    }
}
