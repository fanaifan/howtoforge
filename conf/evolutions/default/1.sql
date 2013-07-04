# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article_list (
  id                        bigint auto_increment not null,
  article_title             varchar(255),
  article_title_cn          varchar(255),
  article_code              varchar(255),
  article_href              varchar(255),
  article_content           longtext,
  article_content_cn        longtext,
  categroy_name             varchar(255),
  categroy_code             varchar(255),
  constraint pk_article_list primary key (id))
;

create table articles (
  id                        bigint auto_increment not null,
  article_code              varchar(255),
  article_href              varchar(255),
  article_title             varchar(255),
  categroy_name             varchar(255),
  categroy_code             varchar(255),
  article_content           longtext,
  article_content_cn        longtext,
  constraint pk_articles primary key (id))
;

create table categroies (
  id                        bigint auto_increment not null,
  categroy_code             varchar(255),
  categroy_name             varchar(255),
  categroy_href             varchar(255),
  categroy_parent           varchar(255),
  constraint pk_categroies primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table article_list;

drop table articles;

drop table categroies;

SET FOREIGN_KEY_CHECKS=1;

