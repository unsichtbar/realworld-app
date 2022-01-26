package org.acme.application.article;

import java.util.Optional;

import org.acme.domain.models.Article;
import org.acme.domain.models.Comment;

import io.smallrye.mutiny.Uni;

public interface ArticleRepository {

    Uni<Optional<Article>> findBySlug(String slug);

    Uni<Article> save(Article article);

    Uni<Comment> saveComment(Comment comment, Article article);
    
}
