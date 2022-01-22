package org.acme.presentation.openapitools.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.UpdateArticleDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("UpdateArticleRequest")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class UpdateArticleRequestDto   {
  
  private @Valid UpdateArticleDto article;

  /**
   **/
  public UpdateArticleRequestDto article(UpdateArticleDto article) {
    this.article = article;
    return this;
  }

  

  
  @JsonProperty("article")
  @NotNull
  public UpdateArticleDto getArticle() {
    return article;
  }

  @JsonProperty("article")
  public void setArticle(UpdateArticleDto article) {
    this.article = article;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateArticleRequestDto updateArticleRequest = (UpdateArticleRequestDto) o;
    return Objects.equals(this.article, updateArticleRequest.article);
  }

  @Override
  public int hashCode() {
    return Objects.hash(article);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateArticleRequest {\n");
    
    sb.append("    article: ").append(toIndentedString(article)).append("\n");
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

