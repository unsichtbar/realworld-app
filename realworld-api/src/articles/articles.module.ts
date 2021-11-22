import { MikroOrmModule } from '@mikro-orm/nestjs';
import { Module } from '@nestjs/common';
import { Article } from './article.entity';
import { ArticlesController } from './articles.controller';
import { ArticlesService } from './articles.service';

@Module({
  imports: [MikroOrmModule.forFeature([Article])],
  controllers: [ArticlesController],
  exports: [ArticlesService],
  providers: [ArticlesService],
})
export class ArticlesModule {}
