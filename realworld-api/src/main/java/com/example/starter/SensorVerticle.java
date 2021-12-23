package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.util.Random;
import java.util.UUID;

public class SensorVerticle extends AbstractVerticle {

  UUID id;

  @Override
  public void start() throws Exception {
    this.id = UUID.randomUUID();
    startTemperatureReadings();
  }

  Future<Void> startTemperatureReadings(){
    vertx.setPeriodic(1000, (handler) -> {
      vertx.eventBus().send("temperature_update", new TemperatureUpdate(id, new Random().nextDouble()).toJson());
    });
    return Future.succeededFuture();
  }
}
