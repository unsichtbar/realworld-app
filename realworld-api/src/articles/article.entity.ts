import { BaseEntity, Entity, PrimaryKey, Property } from '@mikro-orm/core';

@Entity()
export class Article {
  @PrimaryKey()
  id: number;
  @Property()
  title!: string;

  @Property()
  slug!: string;
}
