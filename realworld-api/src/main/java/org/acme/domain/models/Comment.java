package org.acme.domain.models;

import java.time.LocalDateTime;

public class Comment {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String body;
    private Profile author;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Profile getAuthor() {
        return author;
    }
    public void setAuthor(Profile author) {
        this.author = author;
    }





}
