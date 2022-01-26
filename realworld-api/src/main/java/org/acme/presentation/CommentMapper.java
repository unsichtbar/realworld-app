package org.acme.presentation;

import org.acme.domain.models.Comment;
import org.acme.presentation.openapitools.model.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
interface CommentMapper {

    CommentDto map(Comment comment);
    
}
