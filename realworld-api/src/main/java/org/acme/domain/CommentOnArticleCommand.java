package org.acme.domain;

import org.acme.domain.annotations.CommandFor;
import org.acme.domain.models.Comment;

@CommandFor(Actions.COMMENT_ON_ARTICLE)
public record CommentOnArticleCommand(String slug, String comment) implements Message<Comment> {

}
