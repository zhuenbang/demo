package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * @author zhangkai
 * @date 2017/11/21
 */
@MappedSuperclass
public class Bean {
    private String id;
    @JsonIgnore
    private Long modifiedTime;

    private Long createTime;

    private Integer state = 1;
    @JsonIgnore
    private String createUserId;
    @JsonIgnore
    private String modifiedUserId;

    @Id
    @GeneratedValue(generator = "customized-generator")
    @GenericGenerator(name = "customized-generator", strategy = "com.dpy.platform.common.util.HibernateUUIDKeyGenerator")
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public Bean setId(String id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "modified_time", columnDefinition = "bigint(11)", nullable = true)
    public Long getModifiedTime() {
        return modifiedTime;
    }

    public Bean setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    @Basic
    @Column(name = "create_time", columnDefinition = "bigint(11)", nullable = true)
    public Long getCreateTime() {
        return createTime;
    }

    public Bean setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    @Basic
    @Column(name = "state", length = 2)
    public Integer getState() {
        return state;
    }

    public Bean setState(Integer state) {
        this.state = state;
        return this;
    }

    @Basic
    @Column(name = "create_user_id", length = 32)
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "modified_user_id", length = 32)
    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }
}
