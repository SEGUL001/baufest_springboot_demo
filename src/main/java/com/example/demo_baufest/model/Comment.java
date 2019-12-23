package com.example.demo_baufest.model;


import javax.persistence.*;

@Entity
public class Comment extends BaseEntity{

    @Column
    private String text;

    public Comment(String text, User user, Post post) {
        this.text = text;
        this.user = user;
        this.post = post;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment(String text) {
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
