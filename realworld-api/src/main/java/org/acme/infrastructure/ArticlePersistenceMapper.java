package org.acme.infrastructure;

import org.acme.domain.models.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
interface ArticlePersistenceMapper {

    Article map(ArticleEntity entity);
    ArticleEntity map(Article article);
    
}
