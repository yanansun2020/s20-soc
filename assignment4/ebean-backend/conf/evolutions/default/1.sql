# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table pub_abstract (
  id                            bigint auto_increment not null,
  abs                           varchar(255),
  title                         varchar(255),
  ee                            varchar(255),
  pub_id                        bigint,
  constraint pk_pub_abstract primary key (id)
);

create table pub_author (
  id                            bigint auto_increment not null,
  pub_id                        bigint,
  author_id                     bigint,
  constraint pk_pub_author primary key (id)
);

create table pub_category (
  id                            bigint,
  pub_id                        bigint,
  category1                     varchar(255),
  category2                     varchar(255),
  category3                     varchar(255),
  category4                     varchar(255),
  category5                     varchar(255),
  category6                     varchar(255),
  category7                     varchar(255),
  category8                     varchar(255),
  category9                     varchar(255),
  category10                    varchar(255),
  max_rate                      varchar(255),
  max_index                     integer,
  count                         integer
);

create table publication (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  channel                       varchar(255),
  year                          varchar(255),
  pages                         varchar(255),
  cross_ref                     varchar(255),
  ee                            varchar(255),
  url                           varchar(255),
  book_title                    varchar(255),
  isbn                          varchar(255),
  publisher                     varchar(255),
  editor                        varchar(255),
  volume                        varchar(255),
  number                        varchar(255),
  journal                       varchar(255),
  series                        varchar(255),
  key                           varchar(255),
  mdate                         varchar(255),
  constraint pk_publication primary key (id)
);


# --- !Downs

drop table if exists author;

drop table if exists pub_abstract;

drop table if exists pub_author;

drop table if exists pub_category;

drop table if exists publication;

