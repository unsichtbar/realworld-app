package org.acme.presentation.openapitools.api;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.TagsResponseDto;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/tags")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")public interface TagsApi {

    @GET
    @Produces({ "application/json" })
    TagsResponseDto tagsGet();
}
