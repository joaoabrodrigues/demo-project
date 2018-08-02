CREATE TABLE aluno (
	aluno_id 		NUMBER(19) NOT NULL AUTO_INCREMENT,
	nome 	        VARCHAR(255),
	data_nascimento DATE,
	nome_mae        VARCHAR(255),
	PRIMARY KEY     (aluno_id),
	UNIQUE          (aluno_id)
);

CREATE TABLE nota (
	nota_id 		NUMBER(19) NOT NULL AUTO_INCREMENT,
	nota 	        NUMBER(19),
	aluno_id        NUMBER(19) NOT NULL,
	PRIMARY KEY     (nota_id),
	UNIQUE          (nota_id),
	CONSTRAINT fk_aluno_id FOREIGN KEY (aluno_id) REFERENCES aluno(aluno_id)
);
