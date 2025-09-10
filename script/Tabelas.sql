DROP TABLE if exists banco.aluno;

CREATE TABLE banco.aluno (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

-- InnoDB is a general-purpose storage engine that balances high reliability and high
-- performance. In MySQL 8.0, InnoDB is the default MySQL storage engine. Unless you
-- have configured a different default storage engine, issuing a CREATE TABLE statement
-- without an ENGINE clause creates an InnoDB table.

-- MySQL supports multiple Unicode character sets: utf8mb4 : A UTF-8 encoding of the
-- Unicode character set using one to four bytes per character.

INSERT INTO banco.aluno(NOME, email)
VALUES('Rafael Vilares', 'vilares@gmail.com');

INSERT INTO banco.aluno(NOME, email)
VALUES('Nicole Espanha', 'espanha@gmail.com');
