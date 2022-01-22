package org.acme.presentation.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("NewArticle")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class NewArticleDto   {
  
  private @Valid String title;
  private @Valid String description;
  private @Valid String body;
  private @Valid List<String> tagList = new ArrayList<String>();

  /**
   **/
  public NewArticleDto title(String title) {
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
  public NewArticleDto description(String description) {
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
  public NewArticleDto body(String body) {
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
  public NewArticleDto tagList(List<String> tagList) {
    this.tagList = tagList;
    return this;
  }

  

  
  @JsonProperty("tagList")
  public List<String> getTagList() {
    return tagList;
  }

  @JsonProperty("tagList")
  public void setTagList(List<String> tagList) {
    this.tagList = tagList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewArticleDto newArticle = (NewArticleDto) o;
    return Objects.equals(this.title, newArticle.title) &&
        Objects.equals(this.description, newArticle.description) &&
        Objects.equals(this.body, newArticle.body) &&
        Objects.equals(this.tagList, newArticle.tagList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, body, tagList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewArticle {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    tagList: ").append(toIndentedString(tagList)).append("\n");
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

