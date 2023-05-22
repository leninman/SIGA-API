/* Populate tables */
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('MAT1MED','MATEMÁTICA','1°','MEDIA'),
                                                        ('MAT2MED','MATEMÁTICA','2°','MEDIA'),
                                                        ('MAT3MED','MATEMÁTICA','3°','MEDIA'),
                                                        ('MAT4MED','MATEMÁTICA','4°','MEDIA'),
                                                        ('MAT5MED','MATEMÁTICA','5°','MEDIA'),
                                                        ('CIE1MED','CIENCIAS NATURALES','1°','MEDIA'),
                                                         ('CIE2MED','CIENCIAS NATURALES','2°','MEDIA'),
                                                         ('CAS1MED','CASTELLANO','1°','MEDIA'),
                                                        ('CAS2MED','CASTELLANO','2°','MEDIA'),
                                                         ('ING1MED','INGLÉS Y OTRAS LENGUAS EXTRANJERAS','1°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('ING2MED','INGLÉS Y OTRAS LENGUAS EXTRANJERAS','2°','MEDIA'),
                                                        ('ING3MED','INGLÉS Y OTRAS LENGUAS EXTRANJERAS','3°','MEDIA'),
                                                        ('ING4MED','INGLÉS Y OTRAS LENGUAS EXTRANJERAS','4°','MEDIA'),
                                                        ('ING5MED','INGLÉS Y OTRAS LENGUAS EXTRANJERAS','5°','MEDIA'),
                                                        ('ART1MED','ARTE Y PATRIMONIO','1°','MEDIA'),
                                                        ('ART2MED','ARTE Y PATRIMONIO','2°','MEDIA'),
                                                        ('GHC1MED','GEOGRAFIA, HISTORIA Y CIUDADANIA','1°','MEDIA'),
                                                        ('GHC2MED','GEOGRAFIA, HISTORIA Y CIUDADANIA','2°','MEDIA'),
                                                        ('GHC3MED','GEOGRAFIA, HISTORIA Y CIUDADANIA','3°','MEDIA'),
                                                        ('EFI1MED','EDUCACION FISICA','1°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('EFI2MED','EDUCACION FISICA','2°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('CAS3MED','CASTELLANO','3°','MEDIA'),
                                                        ('EFI3MED','EDUCACION FISICA','3°','MEDIA'),
                                                        ('FIS3MED','FISICA','3°','MEDIA'),
                                                        ('QUI3MED','QUIMICA','3°','MEDIA'),
                                                        ('BIO3MED','BIOLOGIA','3°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('GIN3MED','GRUPOS DE INTERES','3°','MEDIA'),
                                                        ('CAS5MED','CASTELLANO','5°','MEDIA'),
                                                        ('EFI5MED','EDUCACION FISICA','5°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('FIS5MED','FISICA','5°','MEDIA'),
                                                        ('QUI5MED','QUIMICA','5°','MEDIA'),
                                                        ('BIO5MED','BILOGIA','5°','MEDIA'),
                                                        ('CST5MED','CIENCIAS DE LA TIERRA','5°','MEDIA'),
                                                        ('GHC5MED','GEOGRAFIA, HISTORIA Y CIUDADANIA','5°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('FSN5MED','FORMACIÓN PARA LA SOBERANIA NACIONAL','5°','MEDIA'),
                                                        ('ORI5MED','ORIENTACION Y CONVIVENCIA','5°','MEDIA'),
                                                        ('GIN5MED','GRUPOS DE INTERES','5°','MEDIA'),
                                                        ('ORI1MED','ORIENTACION Y CONVIVENCIA','1°','MEDIA'),
                                                        ('ORI2MED','ORIENTACION Y CONVIVENCIA','2°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('GIN2MED','GRUPOS DE INTERES','2°','MEDIA'),
                                                        ('GIN1MED','GRUPOS DE INTERES','1°','MEDIA'),
                                                        ('GIN4MED','GRUPOS DE INTERES','4°','MEDIA'),
                                                        ('ORI3MED','ORIENTACION Y CONVIVENCIA','3°','MEDIA'),
                                                        ('ORI4MED','ORIENTACION Y CONVIENCIA','4°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('CAS4MED','CASTELLANO','4°','MEDIA'),
                                                        ('EFI4MED','EDUCACION FISICA','4°','MEDIA'),
                                                        ('FIS4MED','FISICA','4°','MEDIA'),
                                                        ('QUI4MED','QUIMICA','4°','MEDIA'),
                                                        ('BIO4MED','BIOLOGIA','4°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('GHC4MED','GEOGRAFIA, HISTORIA Y CIUDADANIA','4°','MEDIA'),
                                                        ('FSN4MED','FORMACIÓN PARA LA SOBERANIA NACIONAL','4°','MEDIA');




INSERT INTO periodos (valor,estado) VALUES ('2022-2023','ACTIVO');
INSERT INTO niveles (valor) VALUES ('PRIMARIA'),
                                    ('MEDIA');
INSERT INTO annios (valor) VALUES('1°'),
                            ('2°'),
                            ('3°'),
                            ('4°'),
                            ('5°'),
                            ('6°');
INSERT INTO turnos (valor) VALUES('DIURNO'),
                           ('NOCTURNO°');
INSERT INTO secciones (valor) VALUES('A'),
                                ('B'),
                                ('C'),
                                ('D'),
                                ('E'),
                                ('F');
INSERT INTO condiciones (valor) VALUES('REGULAR'),
                                    ('GRADUADO'),
                                    ('RETIRADO'),
                                    ('EN EJERCICIO');
INSERT INTO roles (rol_nombre) VALUES('ROLE_SISTEMA'),
                                      ('ROLE_DIRECTOR'),
                                      ('ROLE_ADMINISTRATIVO'),
                                     ('ROLE_PROFESOR'),
                                     ('ROLE_EMPLEADO');
INSERT INTO roles (rol_nombre) VALUES('ROLE_ALUMNO'),
                                     ('ROLE_REPRESENTANTE');

INSERT INTO usuarios (nombre, apellido, nombre_usuario, password, email, num_intentos_fallidos, activo, fecha_ultima_conexion) VALUES ('', '', 'director', '$2a$10$jhhc/FL4CzvRkn365duK4.QO4OiT0UE8aNNSSYl1ZT0hQtsIhASRS', '', 0, true, '2023-04-30'),
                                                                                                                                          ('', '', 'administrativo', '$2a$10$PW.agLCV1UFb6p/f08ogTOoezTCDZP2Gs562O7.LGBRik9KEjYV0a', '.', 0, true, '2023-04-30');

INSERT INTO siga.usuario_rol (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO siga.usuario_rol (usuario_id, rol_id) VALUES (2, 3);














