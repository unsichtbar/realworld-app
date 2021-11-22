import { EntityRepository, Repository } from '@mikro-orm/core';
import { Article } from './article.entity';

@Repository(Article)
export class ArticlesRepository extends EntityRepository<Article> {
  public async findBySlug(slug: string) {
    return this.findOne({ slug });
  }
}
