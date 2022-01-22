package org.acme.presentation.openapitools.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Profile")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public class ProfileDto   {
  
  private @Valid String username;
  private @Valid String bio;
  private @Valid String image;
  private @Valid Boolean following;

  /**
   **/
  public ProfileDto username(String username) {
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
  public ProfileDto bio(String bio) {
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
  public ProfileDto image(String image) {
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

/**
   **/
  public ProfileDto following(Boolean following) {
    this.following = following;
    return this;
  }

  

  
  @JsonProperty("following")
  @NotNull
  public Boolean getFollowing() {
    return following;
  }

  @JsonProperty("following")
  public void setFollowing(Boolean following) {
    this.following = following;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfileDto profile = (ProfileDto) o;
    return Objects.equals(this.username, profile.username) &&
        Objects.equals(this.bio, profile.bio) &&
        Objects.equals(this.image, profile.image) &&
        Objects.equals(this.following, profile.following);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, bio, image, following);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    following: ").append(toIndentedString(following)).append("\n");
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

