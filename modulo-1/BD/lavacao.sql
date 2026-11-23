-- criando db
CREATE DATABASE IF NOT EXISTS db_labacao;
USE db_labacao;

-- tabela cliente
CREATE TABLE cliente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  celular VARCHAR(50),
  email VARCHAR(100),
  endereco VARCHAR(100),
  dataCadastro DATE,
  dataNascimento DATE,
  PRIMARY KEY (id)
);

-- tabela pessoa fisica
CREATE TABLE pessoa_fisica (
  id_cliente INT NOT NULL,
  cpf VARCHAR(100),
  PRIMARY KEY (id_cliente),
  CONSTRAINT fk_pf_cliente
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- tabela pessoa juridica
CREATE TABLE pessoa_juridica (
  id_cliente INT NOT NULL,
  cnpj VARCHAR(100),
  inscricaoEstadual VARCHAR(100),
  PRIMARY KEY (id_cliente),
  CONSTRAINT fk_pj_cliente
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- populando os cliente CPF
INSERT INTO cliente (nome, celular, email, endereco, dataCadastro, dataNascimento) VALUES
('Joaninha da Silva', '84998761234', 'joaninha.silva@email.com', 'Av. Engenheiro Roberto Freire, 1520 - Natal/RN', '2026-03-10', '1994-05-15'),
('Zezinho XPTO', '85987654321', 'zezinho.xpto@email.com', 'Rua dos Tabajaras, 88 - Fortaleza/CE', '2026-03-14', '1989-08-22'),
('Toinho do Pneu Furado', '11976543210', 'toinho.pneufurado@email.com', 'Rua Augusta, 950 - Sao Paulo/SP', '2026-04-02', '1979-03-04'),
('Maria Fumaça de Souza', '84991237788', 'mariafumaca@email.com', 'Rua das Acacia, 12 - Parnamirim/RN', '2026-04-20', '2000-11-30'),
('Chiquinho Lava-Jato Lima', '85996541122', 'chiquinho.lima@email.com', 'Av. Bezerra de Menezes, 2300 - Fortaleza/CE', '2026-05-05', '1985-07-19');

INSERT INTO pessoa_fisica (id_cliente, cpf) VALUES
(1, '123.456.789-10'),
(2, '987.654.321-00'),
(3, '321.654.987-11'),
(4, '456.789.123-22'),
(5, '654.321.098-33');

-- populando os cliente CNPJ
INSERT INTO cliente (nome, celular, email, endereco, dataCadastro, dataNascimento) VALUES
('Empresa XPTO Ltda', '1132654321', 'contato@empresaxpto.com.br', 'Av. Paulista, 1000 - Sao Paulo/SP', '2026-05-18', '2010-04-02'),
('Mercadinho Seu Vizinho ME', '8432071234', 'mercadinho.seuvizinho@email.com', 'Travesa do Mercado, 7 - Natal/RN', '2026-06-01', '2018-02-11'),
('Empresa CNPJ Fulano SA', '1130457788', 'financeiro@cnpjfulano.com.br', 'Rua 25 de Março, 500 - Sao Paulo/SP', '2026-06-23', '2005-09-14'),
('Padaria Pão Quentinho Ltda', '8532269900', 'padaria.paoquentinho@email.com', 'Av. Beira Mar, 3100 - Fortaleza/CE', '2026-07-09', '2015-06-27'),
('Borracharia Tá Murcho ME', '8432115566', 'tamurcho.borracharia@email.com', 'Rua Chile, 45 - Natal/RN', '2026-08-15', '2012-12-09');

INSERT INTO pessoa_juridica (id_cliente, cnpj, inscricaoEstadual) VALUES
(6, '12.345.678/0001-90', '123.456.789.012'),
(7, '23.456.789/0001-01', '20.123.456-7'),
(8, '34.567.890/0001-12', '234.567.890.123'),
(9, '45.678.901/0001-23', '06.123456-7'),
(10, '56.789.012/0001-34', '20.987.654-3');

-- q1
SELECT * FROM cliente;

-- q2
SELECT *
FROM cliente c, pessoa_fisica pf
WHERE c.id = pf.id_cliente;

-- q3
SELECT *
FROM cliente c, pessoa_juridica pj
WHERE c.id = pj.id_cliente;

-- q4
SELECT c.nome, pf.cpf
FROM cliente c, pessoa_fisica pf
WHERE c.id = pf.id_cliente;

-- q5
SELECT c.nome, pj.cnpj, pj.inscricaoEstadual
FROM cliente c, pessoa_juridica pj
WHERE c.id = pj.id_cliente;

-- q6
SELECT c.nome, c.dataCadastro
FROM cliente c, pessoa_fisica pf
WHERE c.id = pf.id_cliente
ORDER BY c.nome ASC;
