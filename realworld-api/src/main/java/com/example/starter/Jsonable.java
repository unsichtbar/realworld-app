package com.example.starter;

import io.vertx.core.json.JsonObject;

public interface Jsonable {

  JsonObject toJson();
}
