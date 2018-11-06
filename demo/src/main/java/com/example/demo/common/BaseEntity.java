package com.example.demo.common;

/**
 * Created by lmh on 2017/5/9.
 */

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "create_time",columnDefinition = "datetime COMMENT '创建时间'")
    @Temporal(TIMESTAMP)
    @CreationTimestamp
    protected Date createTime;//创建时间

    @Column(name = "update_time",columnDefinition = "datetime COMMENT '修改时间时间'")
    @Temporal(TIMESTAMP)
    @UpdateTimestamp
    protected Date updateTime;//更新时间

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



}
