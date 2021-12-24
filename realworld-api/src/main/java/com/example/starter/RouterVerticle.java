package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RouterVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    createRouter()
      .compose(this::startHttpServer);

  }

  private Future<HttpServer> startHttpServer(Router router) {
    return vertx.createHttpServer().requestHandler(router).listen(8888);
  }

  private Future<Router> createRouter() {
    Router router = Router.router(vertx);

    router.get("/echo").handler(routingContext -> {

      HttpServerResponse response = routingContext.response();
      response.putHeader("content-type", "text/plain").end("Hey there");
    });

    router.post("/users").handler(routingContext -> {
      HttpServerResponse response = routingContext.response();

      vertx.eventBus().request("create_user_command", new JsonObject())
        .onSuccess(result -> {
          response.putHeader("content-type", "text/plain").end("Your user was created");
        });
    });

    router.get("/users").handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      vertx.eventBus().request("read_all_users_query", null)
        .onSuccess(result -> {
          response.putHeader("content-type", "application/json").end(result.body().toString());
        });
    });

    router.get("/temps").handler(this::tempQuery);

    return Future.succeededFuture(router);
  }

  private void tempQuery(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/event-stream").putHeader("cache-control", "no-cache").setChunked(true);

    Future<String> verticle = vertx.deployVerticle(new TemperatureQueryVerticle());
    verticle.onSuccess(deployedVerticle -> {
        MessageConsumer<JsonObject> consumer = vertx.eventBus().consumer("temperature_query", reply -> {
          System.out.println("sending temp count to client " + reply.body());
          response.write("event: count\n");
          response.write("data: " + reply.body() + "\n\n");
        });
        response.endHandler(v -> {
          System.out.println("temp query closed by client");
          vertx.undeploy(deployedVerticle);
          consumer.unregister();
        });

      });


  }
}
