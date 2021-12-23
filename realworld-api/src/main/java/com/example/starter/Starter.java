package com.example.starter;

import io.vertx.core.Launcher;
import io.vertx.core.Vertx;

public class Starter {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }
}