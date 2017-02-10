package com.snow.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Kelvin on 2017/2/9.
 */
@Entity
@Table(name = "s_user", schema = "snowy", catalog = "")
public class SUserEntity implements Serializable {
    private int id;
    private String userId;
    private String nickName;
    private String pwd;
    private String realName;
    private String phoneNum;
    private Collection<SBlogEntity> blogsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = false, length = 39)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nickName", nullable = false, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 15)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "realName", nullable = true, length = 15)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "phoneNum", nullable = true, length = 11)
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SUserEntity that = (SUserEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userById")
    public Collection<SBlogEntity> getBlogsById() {
        return blogsById;
    }

    public void setBlogsById(Collection<SBlogEntity> blogsById) {
        this.blogsById = blogsById;
    }
}
