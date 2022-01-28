package org.acme.application.article;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.application.Handler;
import org.acme.application.UserPrincipal;
import org.acme.domain.Actions;
import org.acme.domain.CommentOnArticleCommand;
import org.acme.domain.exceptions.ArticleNotFoundException;
import org.acme.domain.models.Article;
import org.acme.domain.models.Comment;
import org.acme.domain.models.Profile;
import org.acme.domain.models.User;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
class CommentOnArticleHandler implements Handler<Comment, CommentOnArticleCommand> {

    @Inject
    private ArticleRepository repository;

    @Inject
    private Clock clock;

    @Inject
    private UserPrincipal userPrincipal;

    @ConsumeEvent(Actions.COMMENT_ON_ARTICLE)
    @Transactional
    public Uni<Comment> handle(CommentOnArticleCommand command) {

        return repository.findBySlug(command.slug()).flatMap(maybeArticle -> {

            Article article = maybeArticle.orElseThrow(() -> new ArticleNotFoundException());

            Comment comment = new Comment();
            comment.setBody(command.comment());
            comment.setCreatedAt(LocalDateTime.now(clock));
            comment.setUpdatedAt(comment.getCreatedAt());
            comment.setAuthor(getProfile(userPrincipal.getUser()));
            return this.repository.saveComment(comment, article);
        });
    }

    private Profile getProfile(User user) {
        return new Profile();
    }

}
