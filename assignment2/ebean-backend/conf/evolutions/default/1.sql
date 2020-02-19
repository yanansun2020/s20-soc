# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table pub_author (
  id                            bigint auto_increment not null,
  pub_id                        bigint,
  author_id                     bigint,
  constraint pk_pub_author primary key (id)
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
  key_word                      varchar(255),
  mdate                         varchar(255),
  constraint pk_publication primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists author;

drop table if exists pub_author;

drop table if exists publication;

drop table if exists user;

