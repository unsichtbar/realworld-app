package org.acme.infrastructure;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped class ArticlePanacheRepository implements PanacheRepository<ArticleEntity> {

    public Uni<Optional<ArticleEntity>> findBySlug(String slug) {
        return find("slug", slug).firstResult().map(item -> {
            return Optional.ofNullable(item);
        });
    }
    
}
