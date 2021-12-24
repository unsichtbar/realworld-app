package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.util.Random;
import java.util.UUID;

public class SensorVerticle extends AbstractVerticle {

  UUID id;

  Random random = new Random();
  @Override
  public void start() throws Exception {
    this.id = UUID.randomUUID();
    Update();
  }

  Future<Void> Update(){
    vertx.setTimer(random.nextInt(3000), (handler) -> {
      Double temp = random.nextDouble() * 100;
      System.out.println("sensor " + id.toString() + ": " +temp);
      vertx.eventBus().publish("temperature_update", new TemperatureUpdate(id, temp ).toJson());
      Update();
    });
    return Future.succeededFuture();
  }
}
