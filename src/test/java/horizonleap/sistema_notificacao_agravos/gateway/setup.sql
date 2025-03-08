
DELETE FROM INFORMACOES_AGRAVO;

DELETE FROM AGRAVO;


INSERT INTO  AGRAVO ( ID , CID , NOME )  VALUES ( '8183bb5e-de6f-4bef-8f54-3f0aec4e8a1d' , 'A01' , 'Agravo A01' );

INSERT INTO  AGRAVO ( ID , CID , NOME )  VALUES ( '945e974d-011d-4351-80da-9594745b192d' , 'A02' , 'Agravo A02' );

INSERT INTO  AGRAVO ( ID , CID , NOME )  VALUES ( 'db37ce52-a826-4fbe-b182-f352e3dd0849' , 'A03' , 'Agravo A03' );

INSERT INTO informacoes_agravo(id , chave_json, descricao, nome, agravo_id) VALUES ( 'db37ce52-a826-4faa-b182-f352e3dd0849' , 'porco', 'Contato com porco', 'Contato com porco', '8183bb5e-de6f-4bef-8f54-3f0aec4e8a1d');
INSERT INTO informacoes_agravo(id , chave_json, descricao, nome, agravo_id) VALUES ( 'db37ce52-a826-4fbb-b182-f352e3dd0849' ,  'galinha', 'Contato com galinha', 'Contato com galinha', '8183bb5e-de6f-4bef-8f54-3f0aec4e8a1d');
INSERT INTO informacoes_agravo(id , chave_json, descricao, nome, agravo_id) VALUES ( 'db37ce52-a826-4fcc-b182-f352e3dd0849' ,  'gado', 'Contato com gado', 'Contato com gado', '8183bb5e-de6f-4bef-8f54-3f0aec4e8a1d');

INSERT INTO informacoes_agravo(id ,  chave_json, descricao, nome, agravo_id) VALUES ( 'db37ce52-a826-4fdd-b182-f352e3dd0849' , 'exterior', 'Viagem para o exterior nos últimos 5 meses', 'Viagem para o exterior nos últimos 5 meses', '945e974d-011d-4351-80da-9594745b192d');
