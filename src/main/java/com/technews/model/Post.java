package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.List;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="post")

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;

    @Transient
    private String userName;
    
    @Transient
    private int voteCount;
    private Integer userid;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="posted_at")
    private Date postedAt=new Date();
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="updated_at")
    private Date updatedAt=new Date();
    
    private List<Comment> comments;

    public Post() {
    }

    public Post(Integer id, String title, String postUrl, int voteCount, Integer userid) {
        id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.voteCount = voteCount;
        this.userid = userid;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getVoteCount() == post.getVoteCount() &&
                Objects.equals(getid(), post.getid()) &&
                Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getPostUrl(), post.getPostUrl()) &&
                Objects.equals(getUserName(), post.getUserName()) &&
                Objects.equals(getUserid(), post.getUserid()) &&
                Objects.equals(getPostedAt(), post.getPostedAt()) &&
                Objects.equals(getUpdatedAt(), post.getUpdatedAt()) &&
                Objects.equals(getComments(), post.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getid(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserid(), getPostedAt(), getUpdatedAt(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userid=" + userid +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
