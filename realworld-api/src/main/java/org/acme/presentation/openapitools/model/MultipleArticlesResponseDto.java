package org.acme.presentation.openapitools.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.ArticleDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("MultipleArticlesResponse")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class MultipleArticlesResponseDto   {
  
  private @Valid List<ArticleDto> articles = new ArrayList<ArticleDto>();
  private @Valid Integer articlesCount;

  /**
   **/
  public MultipleArticlesResponseDto articles(List<ArticleDto> articles) {
    this.articles = articles;
    return this;
  }

  

  
  @JsonProperty("articles")
  @NotNull
  public List<ArticleDto> getArticles() {
    return articles;
  }

  @JsonProperty("articles")
  public void setArticles(List<ArticleDto> articles) {
    this.articles = articles;
  }

/**
   **/
  public MultipleArticlesResponseDto articlesCount(Integer articlesCount) {
    this.articlesCount = articlesCount;
    return this;
  }

  

  
  @JsonProperty("articlesCount")
  @NotNull
  public Integer getArticlesCount() {
    return articlesCount;
  }

  @JsonProperty("articlesCount")
  public void setArticlesCount(Integer articlesCount) {
    this.articlesCount = articlesCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultipleArticlesResponseDto multipleArticlesResponse = (MultipleArticlesResponseDto) o;
    return Objects.equals(this.articles, multipleArticlesResponse.articles) &&
        Objects.equals(this.articlesCount, multipleArticlesResponse.articlesCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(articles, articlesCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultipleArticlesResponse {\n");
    
    sb.append("    articles: ").append(toIndentedString(articles)).append("\n");
    sb.append("    articlesCount: ").append(toIndentedString(articlesCount)).append("\n");
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

