#Criando o banco de dados
create database bd_aula03;

#Acessando o banco de dados
use bd_aula03;

#Script para criar a tabela de endereço
create table endereco(
	id				char(36)		primary key,
	logradouro		varchar(150)	not null,
	numero			varchar(15)		not null,
	complemento		varchar(50)		not null,
	bairro			varchar(100)	not null,
	cidade			varchar(50)		not null,
	estado			varchar(50)		not null,
	cep				varchar(10)		not null
);

#Script para criar a tabela de funcionário
create table funcionario(
	id				char(36)		primary key,
	nome			varchar(100)	not null,
	cpf				varchar(14)		not null,
	dataadmissao	date			not null,
	endereco_id		char(36),
	foreign key(endereco_id) references endereco(id)
);