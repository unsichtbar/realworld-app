package org.acme.presentation.openapitools.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("UpdateUser")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class UpdateUserDto   {
  
  private @Valid String email;
  private @Valid String token;
  private @Valid String username;
  private @Valid String bio;
  private @Valid String image;

  /**
   **/
  public UpdateUserDto email(String email) {
    this.email = email;
    return this;
  }

  

  
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

/**
   **/
  public UpdateUserDto token(String token) {
    this.token = token;
    return this;
  }

  

  
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @JsonProperty("token")
  public void setToken(String token) {
    this.token = token;
  }

/**
   **/
  public UpdateUserDto username(String username) {
    this.username = username;
    return this;
  }

  

  
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  @JsonProperty("username")
  public void setUsername(String username) {
    this.username = username;
  }

/**
   **/
  public UpdateUserDto bio(String bio) {
    this.bio = bio;
    return this;
  }

  

  
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  @JsonProperty("bio")
  public void setBio(String bio) {
    this.bio = bio;
  }

/**
   **/
  public UpdateUserDto image(String image) {
    this.image = image;
    return this;
  }

  

  
  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserDto updateUser = (UpdateUserDto) o;
    return Objects.equals(this.email, updateUser.email) &&
        Objects.equals(this.token, updateUser.token) &&
        Objects.equals(this.username, updateUser.username) &&
        Objects.equals(this.bio, updateUser.bio) &&
        Objects.equals(this.image, updateUser.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, token, username, bio, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUser {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
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

