CREATE DATABASE LIVRARIA;

DROP DATABASE LIVRARIA;

SELECT livraria;

CREATE TABLE cliente (
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    data VARCHAR(45) NOT NULL,
    PRIMARY KEY (cpf)
);

CREATE TABLE ENDERECO (
    ID INT AUTO_INCREMENT NOT NULL,
    rua VARCHAR(45) NOT NULL,
    numero VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    complemento VARCHAR(45),
    cidade VARCHAR(45) NOT NULL,
    uf VARCHAR(45) NOT NULL,
    FK_cpf varchar(11) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (FK_cpf) REFERENCES cliente(cpf) ON DELETE CASCADE
);

CREATE TABLE livro (
    nome VARCHAR(45) NOT NULL,
    isbn VARCHAR(45) unique NOT NULL,
    edicao VARCHAR(45) NOT NULL,
    ano VARCHAR(4) NOT NULL,
    autor VARCHAR(45) NOT NULL,
    pag INT NOT NULL,
    preco DOUBLE NOT NULL,
    quant INT NOT NULL,
    data VARCHAR(45) NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE venda (
    codVenda INT AUTO_INCREMENT NOT NULL,
    valor_total DOUBLE NOT NULL,
    data_registro VARCHAR(45) NOT NULL,
    pagamento VARCHAR(45) NOT NULL,
    statusVenda VARCHAR(45) NOT NULL,
    FK_cpf varchar(45) NOT NULL,
    PRIMARY KEY (codVenda),
    FOREIGN KEY(FK_cpf) REFERENCES cliente(cpf)
);

CREATE TABLE livrosVendidos(
id INT AUTO_INCREMENT NOT NULL,
FK_isnb VARCHAR(45) NOT NULL,
FK_codVenda INT NOT NULL,
primary key(id),
FOREIGN KEY(FK_isnb) REFERENCES livro(isbn) ON DELETE CASCADE,
FOREIGN KEY(FK_codVenda) REFERENCES venda(codVenda) ON DELETE CASCADE
);
