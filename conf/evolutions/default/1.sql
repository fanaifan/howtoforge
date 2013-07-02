# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table categroies (
  id                        bigint auto_increment not null,
  categroy_code             varchar(255),
  categroy_name             varchar(255),
  categroy_parent           varchar(255),
  constraint pk_categroies primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table categroies;

SET FOREIGN_KEY_CHECKS=1;

