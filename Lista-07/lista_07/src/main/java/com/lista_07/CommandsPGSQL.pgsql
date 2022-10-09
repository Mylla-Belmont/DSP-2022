create table alunos(
    id serial not null,
    cpf varchar(30) not null,
    matricula varchar(30) not null,
    nome varchar(30) not null,
    email varchar(30) not null,
    telefone varchar(30) not null,

    constraint id_pkey primary key(id)
);