create database registrocomissionamento;
use registrocomissionamento;

create table ordemdeservicoconcluida(
	id int auto_increment,
    cliente int,
    protocolo int,
    empresa varchar(255),
    utepRresponsavel varchar(100),
    motivo varchar(80),
    situacao varchar(20),
    orgaoExecutor varchar(10),
    localObra varchar(30),
    dataAbertura date,
    dataLimite date,
    dataConclusao date,
    foraDoPrazo varchar(3),
    dias int,
	termos varchar(255),
    dataEnvio date,
    primary key(id)
);

create table ordemdeservicopendente (
	id int auto_increment,
    cliente int,
    protocolo int,
    empresa varchar(255),
    utepRresponsavel varchar(100),
    motivo varchar(80),
    situacao varchar(20),
    orgaoExecutor varchar(10),
    localObra varchar(30),
    dataAbertura date,
    dataLimite date,
    dataConclusao date,
    foraDoPrazo varchar(3),
    dias int,
    primary key(id)
);