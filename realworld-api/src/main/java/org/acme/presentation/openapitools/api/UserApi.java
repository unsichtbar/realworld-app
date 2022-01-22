package org.acme.presentation.openapitools.api;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.UpdateUserRequestDto;
import org.acme.presentation.openapitools.model.UserResponseDto;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/user")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public interface UserApi {

    @GET
    @Produces({ "application/json" })
    Uni<UserResponseDto> getCurrentUser();

    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<UserResponseDto> updateCurrentUser(@Valid @NotNull UpdateUserRequestDto body);
}
