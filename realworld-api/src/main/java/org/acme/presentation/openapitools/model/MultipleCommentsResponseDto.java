package org.acme.presentation.openapitools.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.CommentDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("MultipleCommentsResponse")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class MultipleCommentsResponseDto   {
  
  private @Valid List<CommentDto> comments = new ArrayList<CommentDto>();

  /**
   **/
  public MultipleCommentsResponseDto comments(List<CommentDto> comments) {
    this.comments = comments;
    return this;
  }

  

  
  @JsonProperty("comments")
  @NotNull
  public List<CommentDto> getComments() {
    return comments;
  }

  @JsonProperty("comments")
  public void setComments(List<CommentDto> comments) {
    this.comments = comments;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultipleCommentsResponseDto multipleCommentsResponse = (MultipleCommentsResponseDto) o;
    return Objects.equals(this.comments, multipleCommentsResponse.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultipleCommentsResponse {\n");
    
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
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

