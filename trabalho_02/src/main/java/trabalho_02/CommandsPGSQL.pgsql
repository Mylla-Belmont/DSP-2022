create table Ator (
    id_ator integer not null,
    nome varchar(30) not null,
    dataNascimento varchar(30) not null,
    filme_ator varchar(50)[],

    constraint id_pkey primary key(id)
);

create table Filme (
    id_filme integer not null,
    titulo varchar(30) not null,
    anoLancamento varchar(30) not null,
    atores_filme varchar(50)[],

    constraint id_pkey2 primary key(id)
);

----- Atores ---------

insert into Ator (id, nome, datanascimento, filme_ator) 
       values (1, 'David Tennant', '18-04-1971', '{
                                                "Good Omens",
                                                "Doctor who",
                                                "Final Space"}')

insert into Ator (id, nome, datanascimento, filme_ator) 
       values (2, 'Michael Sheen', '05-02-1969', '{
                                                "Good Omens",
                                                "Alice no País das Maravilhas",
                                                "Anjos da Noite"}')

insert into Ator (id, nome, datanascimento, filme_ator) 
       values (3, 'Mads Mikkelsen', '22-11-1965', '{
                                                "Hannibal",
                                                "Animais Fantásticos: Os Segredos de Dumbledore",
                                                "Doutor Estranho"}')

insert into Ator (id, nome, datanascimento, filme_ator) 
       values (4, 'Hugh Dancy', '19-05-1975', '{
                                                "Hannibal",
                                                "Rei Arthur",
                                                "Lei & Ordem"}') 

----- Filmes ---------

insert into Filme (id, titulo, anoLancamento, atores_filme) 
       values (1, 'Good Omens', '2019', '{
                                            "David Tennant",
                                            "Michael Sheen",
                                            "Benedict Cumberbatch"}')

insert into Filme (id, titulo, anoLancamento, atores_filme) 
       values (2, 'Hannibal', '2013', '{
                                        "Mads Mikkelsen",
                                        "Hugh Dancy",
                                        "Kacey Rohl"}')

insert into Filme (id, titulo, anoLancamento, atores_filme) 
       values (3, 'Doutor estranho', '2016', '{
                                                "Benedict Cumberbatch",
                                                "Tilda Swinton",
                                                "Joaquin Phoenix"}')
                                            
insert into Filme (id, titulo, anoLancamento, atores_filme) 
       values (4, 'Animais Fantásticos', '2016', '{
                                                    "Mads Mikkelsen",
                                                    "Eddie Redmayne",
                                                    "Ezra Miller"}')

select * from Ator
select * from Filme

drop table ator
drop table filme