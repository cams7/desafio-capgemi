DELETE FROM tb_cliente;
ALTER SEQUENCE sq_cliente RESTART WITH 1;
DELETE FROM tb_conta_corrente;
ALTER SEQUENCE sq_conta_corrente RESTART WITH 1;

INSERT INTO tb_cliente (id_cliente, nome, cpf, data_nascimento) VALUES (sq_cliente.nextval, 'Luana Maya Débora dos Santos', '90978765591', '1990-04-05');
INSERT INTO tb_cliente (id_cliente, nome, cpf, data_nascimento) VALUES (sq_cliente.nextval, 'Manoel Yuri Giovanni Teixeira', '58686090770', '1982-12-03');
INSERT INTO tb_cliente (id_cliente, nome, cpf, data_nascimento) VALUES (sq_cliente.nextval, 'Antonio Edson Bernardes', '85897765146', '1960-11-27');
INSERT INTO tb_conta_corrente (id_conta_corrente, id_cliente, saldo_atual) VALUES (sq_conta_corrente.nextval, 1, 12000);
INSERT INTO tb_conta_corrente (id_conta_corrente, id_cliente, saldo_atual) VALUES (sq_conta_corrente.nextval, 2, 2000);
INSERT INTO tb_conta_corrente (id_conta_corrente, id_cliente, saldo_atual) VALUES (sq_conta_corrente.nextval, 3, 500);