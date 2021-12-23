package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

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
      response.putHeader("content-type", "text/plain").send("Hey there").result();
    });

    router.post("/users").handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      vertx.eventBus().send("create_user_command", new JsonObject());
      vertx.eventBus().consumer("user_created", (handler) -> {
          response.putHeader("content-type", "text/plain").send("Your user was created!").result();

      });
    });

    router.get("/users").handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      vertx.eventBus().send("read_all_users_query", null);
      vertx.eventBus().<JsonObject>consumer("read_all_users_query_response", handler -> {
        response.putHeader("content-type", "application/json").send(handler.body().toBuffer()).result();

      });
    });


    return Future.succeededFuture(router);
  }
}
