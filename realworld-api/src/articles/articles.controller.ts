import { Body, Controller, Delete, Get, Param, Post, Put } from '@nestjs/common';
import {
  MultipleArticlesResponse,
  NewArticleRequest,
  SingleArticleResponse,
  UpdateArticleRequest,
} from 'src/openapi';
import { ArticlesService } from './articles.service';

interface GetArticlesParameters {
  tag?: string;
  name?: string;
  favorited?: string;
  limit?: number;
  offset?: number;
}

@Controller('articles')
export class ArticlesController {
  constructor(private service: ArticlesService) {}

  @Get('/')
  public async getArticles(
    @Param() params: GetArticlesParameters = { limit: 20, offset: 0 },
  ): Promise<MultipleArticlesResponse> {
    return { articles: [], articlesCount: 0 };
  }

  @Get('/feed')
  public async getArticleFeed(): Promise<MultipleArticlesResponse> {
    return { articles: [], articlesCount: 0 };
  }

  @Post('/')
  public async createArticle(@Body() body: NewArticleRequest): Promise<SingleArticleResponse> {
    await this.service.createArticle(body.article);
    return { article: {} as any };
  }

  @Get('/:slug')
  public async getArticleBySlug(@Param() params): Promise<SingleArticleResponse> {
    console.log(params.slug);
    return { article: { slug: params.slug } } as any;
  }

  @Put('/:slug')
  public async updateArticle(@Body() body: UpdateArticleRequest): Promise<SingleArticleResponse> {
    return {} as any;
  }

  @Delete('/:slug')
  public async deleteArticle(@Param() params): Promise<void> {
    this.service.deleteArticle(params.slug);
  }
}
