package com.example.demo_baufest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PostDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    @NotNull
    private Long userId;

    public String getText() {
        return text;
    }

    public PostDTO(String text, Long userId) {
        this.text = text;
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
