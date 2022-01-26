package org.acme.domain.models;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("User")
public class User {

  private @Valid String email;
  private @Valid String token;
  private @Valid String username;
  private @Valid String bio;
  private @Valid String image;

  @JsonIgnore
  private String password;

  /**
   **/
  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
  **/
  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
  **/
  public String getPassword() {
    return this.password;
  }

  @JsonProperty("email")
  @NotNull
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  public User token(String token) {
    this.token = token;
    return this;
  }

  @JsonProperty("token")
  @NotNull
  public String getToken() {
    return token;
  }

  @JsonProperty("token")
  public void setToken(String token) {
    this.token = token;
  }

  /**
   **/
  public User username(String username) {
    this.username = username;
    return this;
  }

  @JsonProperty("username")
  @NotNull
  public String getUsername() {
    return username;
  }

  @JsonProperty("username")
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  public User bio(String bio) {
    this.bio = bio;
    return this;
  }

  @JsonProperty("bio")
  @NotNull
  public String getBio() {
    return bio;
  }

  @JsonProperty("bio")
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   **/
  public User image(String image) {
    this.image = image;
    return this;
  }

  @JsonProperty("image")
  @NotNull
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
    User user = (User) o;
    return Objects.equals(this.email, user.email) &&
        Objects.equals(this.token, user.token) &&
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.bio, user.bio) &&
        Objects.equals(this.image, user.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, token, username, bio, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");

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
