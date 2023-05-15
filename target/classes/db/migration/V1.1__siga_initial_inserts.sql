/* Populate tables */
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('MAT1MED','MATEMÁTICA','1°','MEDIA'),
                                                        ('MAT2MED','MATEMÁTICA','2°','MEDIA'),
                                                        ('MAT3MED','MATEMÁTICA','3°','MEDIA'),
                                                        ('MAT4MED','MATEMÁTICA','4°','MEDIA'),
                                                        ('MAT5MED','MATEMÁTICA','5°','MEDIA'),
                                                        ('CIE1MED','CIENCIAS NATURALES','1°','MEDIA'),
                                                         ('CIE2MED','CIENCIAS NATURALES','2°','MEDIA'),
                                                         ('CAS1MED','CASTELLANO','1°','MEDIA'),
                                                        ('CASMED','CASTELLANO','2°','MEDIA'),
                                                         ('ING1MED','INGLÉS','1°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('ING2MED','INGLÉS','2°','MEDIA'),
                                                        ('ING3MED','INGLÉS','3°','MEDIA'),
                                                        ('ING4MED','INGLÉS','4°','MEDIA'),
                                                        ('ING5MED','INGLÉS','5°','MEDIA'),
                                                        ('ART1MED','ARTE Y PATRIMONIO','1°','MEDIA'),
                                                        ('ART2MED','ARTE Y PATRIMONIO','2°','MEDIA'),
                                                        ('GHC1MED','GHC','1°','MEDIA'),
                                                        ('GHC1MED','GHC','1°','MEDIA'),
                                                        ('GHC2MED','GHC','2°','MEDIA'),
                                                        ('EFI1BAS','EDUCACIÓN FISICA','1°','MEDIA');
INSERT INTO materias (codigo,nombre,annio,nivel) VALUES ('EFI2BAS','EDUCACIÓN FISICA','2°','MEDIA');

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














