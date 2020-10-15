INSERT INTO tb_cidade (nome) values ('Teresina'), ('Palmas'), ('Aracaju'), ('Maceió'), ('Florianópolis'), ('Manaus'), ('Boa Vista'), ('Salvador'), ('Rio de Janeiro'), ('Porto Velho'), ('Fortaleza'),('Porto Alegre'), ('São Paulo'), ('Natal'), ('Rio Branco'), ('Recife'), ('Macapá'), ('Curitiba'), ('Brasília'), ('João Pessoa'), ('Vitória'), ('Belém'), ('Goiânia'), ('Belo Horizonte'), ('São Luís'), ('Cuiabá'), ('Campo Grande');

INSERT INTO tb_uf (sigla, nome, cidade_id) values ('PI', 'Piauí', 1), ('TO', 'Tocantins', 2), ('SE', 'Sergipe', 3), ('AL', 'Alagoas', 4), ('AC', 'Acre', 15), ('AM', 'Amazonas', 6), ('AP', 'Amapá', 17), ('BA', 'Bahia', 8), ('RJ', 'Rio de Janeiro', 9), ('RO', 'Rondônia', 10), ('CE', 'Ceará', 11), ('RS', 'Rio Grande do Sul', 12), ('SP', 'São Paulo', 13), ('RN', 'Rio Grande do Norte', 14), ('SC', 'Santa Catarina', 5), ('PE', 'Pernambuco', 16), ('RR', 'Roraima', 7), ('PR', 'Paraná', 18), ('DF', 'Distrito Federal', 19), ('PB', 'Paraíba', 20), ('ES', 'Espírito Santo', 21), ('PA', 'Pará', 22), ('GO', 'Goiás', 23), ('MG', 'Minas Gerais', 24), ('MA', 'Maranhão', 25), ('MT', 'Mato Grosso', 26), ('MS', 'Mato Grosso do Sul', 27);

INSERT INTO tb_endereco (logradouro, cep, uf_id) values ('Rua Da Alegria', '01234-567', 13);
INSERT INTO tb_endereco (logradouro, cep, uf_id) values ('Rua Da Felicidade', '98765-432', 1);

INSERT INTO tb_cliente (nome, cpf, endereco_id) values ('Amalia', '111.111.111-11', 1);
INSERT INTO tb_cliente (nome, cpf, endereco_id) values ('Thiago', '000.000.000-00', 2);
