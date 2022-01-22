package org.acme.presentation.openapitools.api;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.ProfileResponseDto;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/profiles/{username}")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public interface ProfilesApi {

    @POST
    @Path("/follow")
    @Produces({ "application/json" })
    ProfileResponseDto followUserByUsername(@PathParam("username") String username);

    @GET
    @Produces({ "application/json" })
    ProfileResponseDto getProfileByUsername(@PathParam("username") String username);

    @DELETE
    @Path("/follow")
    @Produces({ "application/json" })
    ProfileResponseDto unfollowUserByUsername(@PathParam("username") String username);
}
