# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table livro (
  id                            bigint auto_increment not null,
  titulo                        varchar(255),
  autor                         varchar(255),
  editora                       varchar(255),
  genero                        varchar(255),
  preco                         float not null,
  descricao                     varchar(255),
  constraint pk_livro primary key (id)
);


# --- !Downs

drop table if exists livro;

