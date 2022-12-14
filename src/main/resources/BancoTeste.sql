INSERT INTO colaborador (id_colaborador, custo, status_colaborador, nome_colaborador, 
                         matricula, salario_base)
VALUES   (1, 0.0, true, 'PATRICIA MARISTANI DE SOUZA E SILVA', 2012,0.0 ),
(2, 0.0, true, 'GEORGE PETERSON RAMOS DE MORAES',2044,0.0 ),
(3, 0.0, true, 'LETÍCIA RIBEIRO E SILVA', 3028, 0.0),
(4, 0.0, true, 'VALERIA REGINA DE AGUIAR COIMBRA', 3040,0.0),
(5, 0.0, true, 'ELIZABETH NASCIMENTO BORGES LINS', 3057,0.0 );

INSERT INTO papel(id_papel, nome_papel, taxa_hora, taxa_hora_extra)
VALUES(1, 'GERENTE DE TI II', 0.0, 0.0),
(2, 'COORDENADOR(A) TI JR I',0.0,0.0),
(3, 'Supervisora Administrativa PL',0.0,0.0),
(4, 'ANALISTA TESTE SR II',0.0,0.0),
(5, 'ANALISTA TI SENIOR II',0.0,0.0);

INSERT INTO cliente (id_cliente, nome_cliente, cnpj, status_cliente)
VALUES(1,'Prudential RJ', '20.415.973/0001-07' ,true),
(2,'Prudential','72.154.854/0001-33' , true),
(3,'RH','22.331.682/0001-58',true),
(4,'Azul Seguros','47.585.844/0001-05',true),
(5,'TokStok','90.103.906/0001-24', true);

INSERT INTO contrato(id_contrato, cliente_id_cliente, nome_contrato, status_contrato, 
                     arquivo_contrato, modalidade, data_inicio, data_final, carga_horaria_prevista)
VALUES(1, 1,'Prudential RJ',true,'','','2021-02-01','2022-02-01', 0),
(2, 2,'Prudential RJ',true, '', '','2021-02-01','2022-02-01', 0),
(3, 3,'Prudential RJ',true,'','','2021-02-01','2022-02-01', 0),
(4, 4,'Prudential RJ',true,'','','2021-02-01','2022-02-01', 0),
(5, 5,'Prudential RJ',true,'','','2021-02-01','2022-02-01', 0);

INSERT INTO nota_fiscal (id_nota_fiscal, data_emissao_nota, num_controle_nota, 
                         status_nota, valor_total_nota, contrato_id_contrato)
VALUES (1, '2022-01-13', 1000, true, 100000, 1),
(2, '2022-01-13', 1999, true, 100100, 2),
(3, '2022-01-13', 1088, true, 100123, 3),
(4, '2022-01-13', 1034, true, 100234, 4),
(5, '2022-01-13', 1023, true, 100023, 5);

INSERT INTO colaborador_contrato (id_colaborador_contrato, data_batida, esforco_extra_total, esforco_total, 
                                  faturamento_total, impostos, colaborador_id_colaborador, 
                                  contrato_id_contrato, papel_id_papel)
VALUES (1, '2022-01-15', 10,11,100,20,1,1,1),
(2, '2022-01-15', 10,11,100,20,1,2,1),
(3, '2022-01-15', 10,11,100,20,1,2,2),
(4, '2022-01-15', 10,11,100,20,2,1,1),
(5, '2022-01-15', 10,11,100,20,2,2,2);
