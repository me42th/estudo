create table instrutor(
idinstrutor int primary key auto_increment,
rg int not null,
nome varchar(45) not null,
nascimento date,
titulacao int
);
create table telefone_instrutor(
idtelefone int primary key auto_increment,
numero int not null,
tipo varchar(45),
idinstrutor int not null,
foreign key(idinstrutor) references instrutor(idinstrutor)
);
create table aluno(
idAluno int primary key auto_increment,
dataMatricula date not null,
nome varchar(45) not null,
endereco varchar(150),
telefone int,
dataNascimento date,
altura float(10,2),
peso int
);
create table atividade(
idatividade int primary key auto_increment,
nome varchar(100) not null
);
create table turma(
idturma int primary key auto_increment,
horario time not null,
duracao int not null,
dataInicio date not null,
dataFim date not null,
idatividade int not null,
idinstrutor int not null,
foreign key(idatividade) references atividade(idatividade),
foreign key(idinstrutor) references instrutor(idinstrutor)
);
create table matricula(
idaluno int not null,
idturma int not null,
foreign key(idaluno) references aluno(idaluno),
foreign key(idturma) references turma(idturma)
)
