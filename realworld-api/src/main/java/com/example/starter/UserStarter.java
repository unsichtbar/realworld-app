package com.example.starter;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class UserStarter {

  public static void main(String [] args) {
    Vertx.clusteredVertx(new VertxOptions(), ar -> {
      if(ar.succeeded()) {
        Vertx vertx = ar.result();
        vertx.deployVerticle(new UserVerticle());
      }
    });
  }
}
