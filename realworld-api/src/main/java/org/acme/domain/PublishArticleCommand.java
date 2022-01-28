package org.acme.domain;

import java.util.List;

import org.acme.domain.annotations.CommandFor;
import org.acme.domain.models.Article;

@CommandFor(Actions.PUBLISH_ARTICLE)
public record PublishArticleCommand(String title, String description, String body, List<String> tags) implements Message<Article> {
    
}
