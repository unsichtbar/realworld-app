package org.acme.application.article;

import java.util.Optional;

import org.acme.domain.models.Article;

import io.smallrye.mutiny.Uni;

public interface ArticleRepository {

    Uni<Optional<Article>> findBySlug(String slug);

    Uni<Article> save(Article article);
    
}
