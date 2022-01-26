package org.acme.domain;

import org.acme.domain.annotations.CommandFor;

@CommandFor(Actions.COMMENT_ON_ARTICLE)
public record CommentOnArticleCommand(String slug, String comment) {

}
