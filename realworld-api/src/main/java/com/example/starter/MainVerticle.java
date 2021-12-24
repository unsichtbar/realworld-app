package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {


    vertx.deployVerticle(new RouterVerticle());
    //vertx.deployVerticle(new UserVerticle());
    vertx.deployVerticle(new SensorVerticle());

  }
}
