package org.acme.presentation.openapitools.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.acme.presentation.openapitools.model.NewCommentDto;

import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("NewCommentRequest")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class NewCommentRequestDto   {
  
  private @Valid NewCommentDto comment;

  /**
   **/
  public NewCommentRequestDto comment(NewCommentDto comment) {
    this.comment = comment;
    return this;
  }

  

  
  @JsonProperty("comment")
  @NotNull
  public NewCommentDto getComment() {
    return comment;
  }

  @JsonProperty("comment")
  public void setComment(NewCommentDto comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewCommentRequestDto newCommentRequest = (NewCommentRequestDto) o;
    return Objects.equals(this.comment, newCommentRequest.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewCommentRequest {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

