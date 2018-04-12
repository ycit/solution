package com.ycit.bean.base;

import java.util.Date;

/**
 * 基类
 *
 * @author xlch
 * @Date 2018-03-12 22:43
 */
public class Base {

    private Date createTime;
    private Date modifyTime;
    private int status;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
