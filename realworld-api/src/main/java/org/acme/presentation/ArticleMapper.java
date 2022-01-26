package org.acme.presentation;

import org.acme.domain.models.Article;
import org.acme.presentation.openapitools.model.ArticleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
interface ArticleMapper {

    ArticleDto map(Article article);
    
}
