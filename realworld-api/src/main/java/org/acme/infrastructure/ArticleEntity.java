package org.acme.infrastructure;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class ArticleEntity  {

    @Id
    private Integer id;

    private String slug;

 
    
}
