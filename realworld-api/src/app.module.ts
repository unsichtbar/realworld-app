import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ArticlesModule } from './articles/articles.module';
import { AuthModule } from './auth/auth.module';
import { MikroOrmModule } from '@mikro-orm/nestjs';
import { UsersModule } from './users/users.module';
@Module({
  imports: [
    ArticlesModule,
    UsersModule,
    AuthModule,
    MikroOrmModule.forRoot({
      autoLoadEntities: true,
      dbName: 'realworld-nest-db',
      type: 'postgresql',
    }),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
