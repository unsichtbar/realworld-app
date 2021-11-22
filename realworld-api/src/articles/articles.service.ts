import { Injectable } from '@nestjs/common';
import { Article } from './article.entity';
import { ArticlesRepository } from './articles.repository';

@Injectable()
export class ArticlesService {
  constructor(private repository: ArticlesRepository) {}

  public async deleteArticle(slug: string): Promise<void> {
    const found = await this.repository.findBySlug(slug);
    if (found) this.repository.remove(found);
  }

  public async createArticle(createArticlePayload: CreateArticlePayload) {
    const found = await this.repository.findBySlug(slugify(createArticlePayload.title));
    if (found) throw new Error('slug already taken');
    const newArticle: Article = new Article();
    newArticle.slug = slugify(createArticlePayload.title);
    newArticle.title = createArticlePayload.title;
    this.repository.persist(newArticle);
  }

  public async save(article: any): Promise<any> {
    throw new Error('uh oh fucky wucky');
  }
}

interface CreateArticlePayload {
  title: string;
  description: string;
  body: string;
  tagList?: Array<string>;
}

function slugify(title: string) {
  return title.replace(/\s+/g, '-');
}
