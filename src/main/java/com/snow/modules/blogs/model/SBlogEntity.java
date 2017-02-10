package com.snow.modules.blogs.model;

import com.snow.modules.users.model.SUserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Kelvin on 2017/2/9.
 */
@Entity
@Table(name = "s_blog", schema = "snowy", catalog = "")
public class SBlogEntity {
    private int id;
    private String title;
    private Timestamp publishTime;
    private Integer hide;
    private String content;
    private SUserEntity userById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "publishTime", nullable = true)
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "hide", nullable = true)
    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SBlogEntity that = (SBlogEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (hide != null ? !hide.equals(that.hide) : that.hide != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (hide != null ? hide.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    public SUserEntity getUserById() {
        return userById;
    }

    public void setUserById(SUserEntity userById) {
        this.userById = userById;
    }
}
