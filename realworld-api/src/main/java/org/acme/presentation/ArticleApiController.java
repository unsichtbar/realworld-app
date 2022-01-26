package org.acme.presentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.acme.domain.Actions;
import org.acme.domain.CommentOnArticleCommand;
import org.acme.domain.models.Article;
import org.acme.domain.models.Comment;
import org.acme.domain.PublishArticleCommand;
import org.acme.presentation.openapitools.api.ArticlesApi;
import org.acme.presentation.openapitools.model.MultipleArticlesResponseDto;
import org.acme.presentation.openapitools.model.MultipleCommentsResponseDto;
import org.acme.presentation.openapitools.model.NewArticleRequestDto;
import org.acme.presentation.openapitools.model.NewCommentRequestDto;
import org.acme.presentation.openapitools.model.SingleArticleResponseDto;
import org.acme.presentation.openapitools.model.SingleCommentResponseDto;
import org.acme.presentation.openapitools.model.UpdateArticleRequestDto;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;

@ApplicationScoped
class ArticleApiController implements ArticlesApi {

    @Inject
    EventBus bus;

    @Inject
    ArticleMapper mapper;

    @Inject
    private CommentMapper commentMapper;

    @Override
    public Uni<RestResponse<SingleArticleResponseDto>> createArticle(@Valid @NotNull NewArticleRequestDto article) {

        PublishArticleCommand createArticlePayload = new PublishArticleCommand(article.getArticle().getTitle(),
                article.getArticle().getDescription(), article.getArticle().getBody(),
                article.getArticle().getTagList());

        return this.bus.<Article>request(Actions.PUBLISH_ARTICLE, createArticlePayload)
                .map(item -> {
                    SingleArticleResponseDto res = new SingleArticleResponseDto();
                    res.article(mapper.map(item.body()));
                    return ResponseBuilder.accepted(res).status(200).build();
                }).onFailure().recoverWithItem((item) -> {
                    return ResponseBuilder.accepted((SingleArticleResponseDto) null).status(401).build();
                });
    }

    @Override
    public Uni<RestResponse<SingleCommentResponseDto>> createArticleComment(String slug,
            @Valid @NotNull NewCommentRequestDto comment) {
        CommentOnArticleCommand message = new CommentOnArticleCommand(slug, comment.getComment().getBody());
        return this.bus.<Comment>request(Actions.COMMENT_ON_ARTICLE, message)
                .map(item -> {

                    Comment createdComment = item.body();
                    return ResponseBuilder
                            .ok(new SingleCommentResponseDto().comment(commentMapper.map(createdComment)))
                            .build();
                });
    }

    @Override
    public Uni<RestResponse<SingleArticleResponseDto>> createArticleFavorite(String slug) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteArticle(String slug) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteArticleComment(String slug, Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Uni<RestResponse<SingleArticleResponseDto>> deleteArticleFavorite(String slug) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<SingleArticleResponseDto>> getArticle(String slug) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<MultipleCommentsResponseDto>> getArticleComments(String slug) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<MultipleArticlesResponseDto>> getArticles(String tag, String author, String favorited,
            Integer limit, Integer offset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<MultipleArticlesResponseDto>> getArticlesFeed(Integer limit, Integer offset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<SingleArticleResponseDto>> updateArticle(String slug,
            @Valid @NotNull UpdateArticleRequestDto article) {
        // TODO Auto-generated method stub
        return null;
    }

}
