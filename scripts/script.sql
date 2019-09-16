CREATE TABLE usuario(
	cpf VARCHAR(14),
	nome VARCHAR(50) NOT NULL ,
	sobreNome VARCHAR(200) NOT NULL ,
	telefone VARCHAR(20) NOT NULL ,
	dataNascimento DATE NOT NULL ,
	email VARCHAR(200) UNIQUE,
	senha VARCHAR(50) NOT NULL ,
	foto VARCHAR(50),
    CONSTRAINT cpf_pk PRIMARY KEY(cpf)
);

INSERT INTO usuario(cpf, nome, sobreNome, telefone, dataNascimento, email, senha, foto)
VALUES ('111.111.111-11', 'Tester', 'Padrão', '(83)99633-8557', '1999-09-09', 'teste@teste.com', '1234', 'teste.jpg');

CREATE TABLE imovel(
    id VARCHAR(100),
    proprietario VARCHAR(14),
    nome VARCHAR(200),
    rua VARCHAR(200),
    bairro VARCHAR(100),
    numero VARCHAR(10),
    cep VARCHAR(9),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    valor FLOAT,
    disponibilidade BOOLEAN,
    foto VARCHAR(200),
    descricao VARCHAR(500),
    CONSTRAINT id_pk PRIMARY KEY(id),
    CONSTRAINT proprietario_fk FOREIGN KEY(proprietario)
        REFERENCES usuario(cpf)
);

CREATE TABLE comodidade(
    id_imovel VARCHAR(100),
    recurso VARCHAR(200),
    CONSTRAINT comodidade_pk PRIMARY KEY(id_imovel, recurso),
    CONSTRAINT id_fk FOREIGN KEY(id_imovel)
        REFERENCES imovel(id)

);

CREATE TABLE foto(
   id_imovel VARCHAR(100),
   foto VARCHAR(100),
   CONSTRAINT foto_pk PRIMARY KEY(id_imovel, foto),
   CONSTRAINT id_fk FOREIGN KEY(id_imovel)
       REFERENCES imovel(id)

);

