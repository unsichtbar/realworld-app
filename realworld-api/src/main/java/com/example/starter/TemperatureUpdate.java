package com.example.starter;

import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class TemperatureUpdate {

  private UUID id;
  private Double value;

  public TemperatureUpdate(UUID id, Double value) {
    this.id = id;
    this.value = value;
  }

  public JsonObject toJson(){
    JsonObject object = new JsonObject();
    object.put("id", id.toString());
    object.put("value", value);
    return object;
  }

  public static TemperatureUpdate fromJson(JsonObject object) {
    return new TemperatureUpdate(UUID.fromString(object.getString("id")), object.getDouble("value"));
  }

  public UUID getId() {
    return id;
  }

  public Double getValue() {
    return value;
  }
}
