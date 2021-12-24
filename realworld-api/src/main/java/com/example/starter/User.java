package com.example.starter;

import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class User implements Jsonable {

  UUID id;


  @Override
  public JsonObject toJson() {
    return new JsonObject().put("id", id.toString());
  }
}
