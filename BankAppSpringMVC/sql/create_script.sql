create table Cliente (
	id_cliente int auto_increment,
	nome varchar(30) not null,
	cognome varchar(30) not null, 
	indirizzo varchar(100) not null,
	numero varchar(15) not null,
	nascita date not null,
	constraint p_idcli primary key(id_cliente)
);

create table Conto (
	id_conto int auto_increment,
	id_cliente int not null,
	saldo double not null,
	apertura date not null,
	constraint p_idcon primary key(id_conto),
	constraint f_idcli foreign key(id_cliente) references Cliente(id_cliente)
);

create table Transazione (
	id_transazione int auto_increment,
	id_sorgente int not null,
	id_destinaz int,
	data date not null,
	importo double not null,
	tipo varchar (30) not null,
	constraint p_idtra primary key(id_transazione),
	constraint f_idsor foreign key(id_transazione) references Conto(id_conto),
	constraint f_iddes foreign key(id_sorgente) references Conto(id_conto)
);

create table Ruolo (
	id_ruolo int auto_increment,
	descrizione varchar (30) not null,
	constraint p_idruo primary key(id_ruolo)
);