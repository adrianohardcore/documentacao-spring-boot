INSERT INTO PERMISSAO (ID, NOME_PERMISSAO) VALUES (1, 'ADMIN') MATCHING (ID);
INSERT INTO PERMISSAO (ID, NOME_PERMISSAO) VALUES (2, 'USER') MATCHING (ID);
INSERT INTO USUARIO (ID, EMAIL, NOME, NOMEUSUARIO, SENHA) VALUES (1, 'admin@adrianohardcore.com', 'Adiministrador', 'admin', '$2a$10$yhQOEMGLR5BPsSPzYipc/eKWIbQlt7xdE3f8fUL5wiWx9F1XmhcPm')                   MATCHING (ID);
INSERT INTO USER_ROLE (ID_USUARIO, ID_PERMISAO) VALUES (1, 1);
INSERT INTO USER_ROLE (ID_USUARIO, ID_PERMISAO) VALUES (1, 2);
INSERT INTO USUARIO (ID, EMAIL, NOME, NOMEUSUARIO, SENHA) VALUES (2, 'adriano.faria@gmail.com', 'Adriano Faria Alves', 'adrianohardcore', '$2a$10$yhQOEMGLR5BPsSPzYipc/eKWIbQlt7xdE3f8fUL5wiWx9F1XmhcPm')                   MATCHING (ID);
INSERT INTO USER_ROLE (ID_USUARIO, ID_PERMISAO) VALUES (2, 1);
INSERT INTO USER_ROLE (ID_USUARIO, ID_PERMISAO) VALUES (2, 2);

                       