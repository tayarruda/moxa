create database moxa;
use moxa;

create table servidor(
id int primary key auto_increment not null,
nome varchar(200) not null,
matricula varchar(30) not null unique,
classificacao varchar(15) not null,
senha char(8) not null 
);

create table produto(
id int primary key auto_increment not null,
quantidade int not null,
nome varchar(70) not null,
preco double not null,
fornecedor varchar(70) not null,
categoria varchar(70));


create table entrada(
id int primary key auto_increment not null,
data_entrada date not null,
quantidade int not null,
servidor_id int,
foreign key (servidor_id) references servidor(id)
);


create table requisicao(
dataR date not null,
id int primary key auto_increment not null,
idSolic int not null,
idAutoriza int not null,
foreign key (idSolic) references servidor(id),
foreign key (idAutoriza) references servidor(id));


select * from servidor;

select * from entrada;

