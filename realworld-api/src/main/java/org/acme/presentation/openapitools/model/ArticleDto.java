package org.acme.presentation.openapitools.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.ProfileDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Article")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class ArticleDto   {
  
  private @Valid String slug;
  private @Valid String title;
  private @Valid String description;
  private @Valid String body;
  private @Valid List<String> tagList = new ArrayList<String>();
  private @Valid Date createdAt;
  private @Valid Date updatedAt;
  private @Valid Boolean favorited;
  private @Valid Integer favoritesCount;
  private @Valid ProfileDto author;

  /**
   **/
  public ArticleDto slug(String slug) {
    this.slug = slug;
    return this;
  }

  

  
  @JsonProperty("slug")
  @NotNull
  public String getSlug() {
    return slug;
  }

  @JsonProperty("slug")
  public void setSlug(String slug) {
    this.slug = slug;
  }

/**
   **/
  public ArticleDto title(String title) {
    this.title = title;
    return this;
  }

  

  
  @JsonProperty("title")
  @NotNull
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

/**
   **/
  public ArticleDto description(String description) {
    this.description = description;
    return this;
  }

  

  
  @JsonProperty("description")
  @NotNull
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

/**
   **/
  public ArticleDto body(String body) {
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
  public ArticleDto tagList(List<String> tagList) {
    this.tagList = tagList;
    return this;
  }

  

  
  @JsonProperty("tagList")
  @NotNull
  public List<String> getTagList() {
    return tagList;
  }

  @JsonProperty("tagList")
  public void setTagList(List<String> tagList) {
    this.tagList = tagList;
  }

/**
   **/
  public ArticleDto createdAt(Date createdAt) {
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
  public ArticleDto updatedAt(Date updatedAt) {
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
  public ArticleDto favorited(Boolean favorited) {
    this.favorited = favorited;
    return this;
  }

  

  
  @JsonProperty("favorited")
  @NotNull
  public Boolean getFavorited() {
    return favorited;
  }

  @JsonProperty("favorited")
  public void setFavorited(Boolean favorited) {
    this.favorited = favorited;
  }

/**
   **/
  public ArticleDto favoritesCount(Integer favoritesCount) {
    this.favoritesCount = favoritesCount;
    return this;
  }

  

  
  @JsonProperty("favoritesCount")
  @NotNull
  public Integer getFavoritesCount() {
    return favoritesCount;
  }

  @JsonProperty("favoritesCount")
  public void setFavoritesCount(Integer favoritesCount) {
    this.favoritesCount = favoritesCount;
  }

/**
   **/
  public ArticleDto author(ProfileDto author) {
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
    ArticleDto article = (ArticleDto) o;
    return Objects.equals(this.slug, article.slug) &&
        Objects.equals(this.title, article.title) &&
        Objects.equals(this.description, article.description) &&
        Objects.equals(this.body, article.body) &&
        Objects.equals(this.tagList, article.tagList) &&
        Objects.equals(this.createdAt, article.createdAt) &&
        Objects.equals(this.updatedAt, article.updatedAt) &&
        Objects.equals(this.favorited, article.favorited) &&
        Objects.equals(this.favoritesCount, article.favoritesCount) &&
        Objects.equals(this.author, article.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, title, description, body, tagList, createdAt, updatedAt, favorited, favoritesCount, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Article {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    tagList: ").append(toIndentedString(tagList)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    favorited: ").append(toIndentedString(favorited)).append("\n");
    sb.append("    favoritesCount: ").append(toIndentedString(favoritesCount)).append("\n");
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

