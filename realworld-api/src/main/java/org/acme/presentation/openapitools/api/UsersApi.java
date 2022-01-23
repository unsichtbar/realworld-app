package org.acme.presentation.openapitools.api;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.LoginUserRequestDto;
import org.acme.presentation.openapitools.model.NewUserRequestDto;
import org.acme.presentation.openapitools.model.UserResponseDto;
import org.jboss.resteasy.reactive.RestResponse;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/users")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public interface UsersApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<RestResponse<UserResponseDto>> createUser(@Valid @NotNull NewUserRequestDto body);

    @POST
    @Path("/login")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<RestResponse<UserResponseDto>> login(@Valid @NotNull LoginUserRequestDto body);
}
