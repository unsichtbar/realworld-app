package org.acme.application.article;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.application.Handler;
import org.acme.domain.Actions;
import org.acme.domain.models.Article;
import org.acme.domain.PublishArticleCommand;
import org.acme.domain.exceptions.ArticleAlreadyExistsException;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
class PublishArticleHandler implements Handler<Article, PublishArticleCommand> {

    @Inject
    private ArticleRepository articleRepository;

    @ConsumeEvent(Actions.PUBLISH_ARTICLE)
    @Transactional
    public Uni<Article> handle(PublishArticleCommand payload) {

        return articleRepository.findBySlug(slugify(payload.title()))
                .flatMap(item -> {
                    if (item.isPresent())
                        throw new ArticleAlreadyExistsException(payload.title());

                    Article article = new Article();
                    return articleRepository.save(article);

                });
    }

    public String slugify(String title) {
        return title.replace(" ", "-");
    }
}
