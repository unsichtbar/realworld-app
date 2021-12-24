package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TemperatureQueryVerticle extends AbstractVerticle {


  private ConcurrentLinkedDeque<TemperatureUpdate> readings = new ConcurrentLinkedDeque<TemperatureUpdate>();

  @Override
  public void start() throws Exception {

    vertx.eventBus().<JsonObject>consumer("temperature_update", this::updateCounter);
  }


  private void updateCounter(Message<JsonObject> jsonObjectMessage) {

    TemperatureUpdate update = TemperatureUpdate.fromJson(jsonObjectMessage.body());
    this.readings.add(update);
    vertx.eventBus().publish("temperature_query",
      new JsonObject()
        .put("average", readings.stream().map(v -> v.getValue()).reduce(0D, (a, b) -> a+ b) / readings.size()));
  }


}
