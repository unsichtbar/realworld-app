package org.acme.presentation.openapitools.model;

import java.util.Date;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.ProfileDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Comment")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class CommentDto   {
  
  private @Valid Integer id;
  private @Valid Date createdAt;
  private @Valid Date updatedAt;
  private @Valid String body;
  private @Valid ProfileDto author;

  /**
   **/
  public CommentDto id(Integer id) {
    this.id = id;
    return this;
  }

  

  
  @JsonProperty("id")
  @NotNull
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

/**
   **/
  public CommentDto createdAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  

  
  @JsonProperty("createdAt")
  @NotNull
  public Date getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("createdAt")
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

/**
   **/
  public CommentDto updatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  

  
  @JsonProperty("updatedAt")
  @NotNull
  public Date getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("updatedAt")
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

/**
   **/
  public CommentDto body(String body) {
    this.body = body;
    return this;
  }

  

  
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }

  @JsonProperty("body")
  public void setBody(String body) {
    this.body = body;
  }

/**
   **/
  public CommentDto author(ProfileDto author) {
    this.author = author;
    return this;
  }

  

  
  @JsonProperty("author")
  @NotNull
  public ProfileDto getAuthor() {
    return author;
  }

  @JsonProperty("author")
  public void setAuthor(ProfileDto author) {
    this.author = author;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentDto comment = (CommentDto) o;
    return Objects.equals(this.id, comment.id) &&
        Objects.equals(this.createdAt, comment.createdAt) &&
        Objects.equals(this.updatedAt, comment.updatedAt) &&
        Objects.equals(this.body, comment.body) &&
        Objects.equals(this.author, comment.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, body, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

