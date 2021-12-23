package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserVerticle extends AbstractVerticle {

  private Map<UUID, User> db = new HashMap<>();

  @Override
  public void start() throws Exception {

    vertx.eventBus().<JsonObject>consumer("create_user_command", handler -> {
        User user = new User();
        UUID id = UUID.randomUUID();
        user.id = id;
        db.put(id, user);
        vertx.eventBus().send("user_created", user.toJson());
    });

    vertx.eventBus().consumer("read_all_users_query", handler -> {
      vertx.eventBus().send("read_all_users_query_response", new JsonObject().put("content", new JsonArray(db.values().stream().map(User::toJson).collect(Collectors.toList()))));
    });
  }
}
