package org.acme.infrastructure;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.application.article.ArticleRepository;
import org.acme.domain.models.Article;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
class ArticleRepositoryImpl implements ArticleRepository {

    @Inject
    private ArticlePanacheRepository delegate;

    @Inject
    private ArticlePersistenceMapper mapper;

    @Override
    public Uni<Optional<Article>> findBySlug(String slug) {
        return delegate.findBySlug(slug).map(item -> {
            return item.map(mapper::map);
        });
    }

    @Override
    public Uni<Article> save(Article article) {
        return delegate.persist(mapper.map(article)).onItem().transform(entity -> {
            if(entity == null ) throw new RuntimeException("something failed saving the article.");
            return mapper.map(entity);
        });
    }

}
