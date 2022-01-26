package org.acme.presentation.openapitools.api;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.MultipleArticlesResponseDto;
import org.acme.presentation.openapitools.model.MultipleCommentsResponseDto;
import org.acme.presentation.openapitools.model.NewArticleRequestDto;
import org.acme.presentation.openapitools.model.NewCommentRequestDto;
import org.acme.presentation.openapitools.model.SingleArticleResponseDto;
import org.acme.presentation.openapitools.model.SingleCommentResponseDto;
import org.acme.presentation.openapitools.model.UpdateArticleRequestDto;
import org.jboss.resteasy.reactive.RestResponse;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/articles")
@javax.annotation.Generated(value = "org.acme.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-14T06:07:13.430233404Z[Etc/UTC]")
public interface ArticlesApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<RestResponse<SingleArticleResponseDto>> createArticle(@Valid @NotNull NewArticleRequestDto article);

    @POST
    @Path("/{slug}/comments")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<RestResponse<SingleCommentResponseDto>> createArticleComment(@PathParam("slug") String slug,
            @Valid @NotNull NewCommentRequestDto comment);

    @POST
    @Path("/{slug}/favorite")
    @Produces({ "application/json" })
    Uni<RestResponse<SingleArticleResponseDto>> createArticleFavorite(@PathParam("slug") String slug);

    @DELETE
    @Path("/{slug}")
    @Produces({ "application/json" })
    void deleteArticle(@PathParam("slug") String slug);

    @DELETE
    @Path("/{slug}/comments/{id}")
    @Produces({ "application/json" })
    void deleteArticleComment(@PathParam("slug") String slug, @PathParam("id") Integer id);

    @DELETE
    @Path("/{slug}/favorite")
    @Produces({ "application/json" })
    Uni<RestResponse<SingleArticleResponseDto>> deleteArticleFavorite(@PathParam("slug") String slug);

    @GET
    @Path("/{slug}")
    @Produces({ "application/json" })
    Uni<RestResponse<SingleArticleResponseDto>> getArticle(@PathParam("slug") String slug);

    @GET
    @Path("/{slug}/comments")
    @Produces({ "application/json" })
    Uni<RestResponse<MultipleCommentsResponseDto>> getArticleComments(@PathParam("slug") String slug);

    @GET
    @Produces({ "application/json" })
    Uni<RestResponse<MultipleArticlesResponseDto>> getArticles(@QueryParam("tag") String tag, @QueryParam("author") String author,
            @QueryParam("favorited") String favorited, @QueryParam("limit") @DefaultValue("20") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);

    @GET
    @Path("/feed")
    @Produces({ "application/json" })
    Uni<RestResponse<MultipleArticlesResponseDto>> getArticlesFeed(@QueryParam("limit") @DefaultValue("20") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);

    @PUT
    @Path("/{slug}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Uni<RestResponse<SingleArticleResponseDto>> updateArticle(@PathParam("slug") String slug,
            @Valid @NotNull UpdateArticleRequestDto article);
}
