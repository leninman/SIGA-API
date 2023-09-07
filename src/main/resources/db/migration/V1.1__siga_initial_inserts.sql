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
                           ('NOCTURNO');
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
INSERT INTO sexos (valor) VALUES('FEMENINO'),
                                 ('MASCULINO');
INSERT INTO lapsos (valor,descripcion,porcentaje) VALUES('1°','PRIMER MOMENTO','30'),
                                                        ('2°','SEGUNDO MOMENTO','30'),
                                                        ('3°','TERCER MOMENTO','40');
INSERT INTO estado_civil (valor) VALUES('CASADO(A)'),
                                 ('DIVORCIADO(A)'),
                                 ('SOLTERO(A)'),
                                 ('VIUDO(A)'),
                                 ('CONCUBINO(A)');
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

INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Afganistán','AFGANA','AFG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Albania','ALBANESA','ALB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Alemania','ALEMANA','DEU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Andorra','ANDORRANA','AND');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Angola','ANGOLEÑA','AGO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('AntiguayBarbuda','ANTIGUANA','ATG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('ArabiaSaudita','SAUDÍ','SAU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Argelia','ARGELINA','DZA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Argentina','ARGENTINA','ARG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Armenia','ARMENIA','ARM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Aruba','ARUBEÑA','ABW');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Australia','AUSTRALIANA','AUS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Austria','AUSTRIACA','AUT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Azerbaiyán','AZERBAIYANA','AZE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bahamas','BAHAMEÑA','BHS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bangladés','BANGLADESÍ','BGD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Barbados','BARBADENSE','BRB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Baréin','BAREINÍ','BHR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bélgica','BELGA','BEL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Belice','BELICEÑA','BLZ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Benín','BENINÉSA','BEN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bielorrusia','BIELORRUSA','BLR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Birmania','BIRMANA','MMR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bolivia','BOLIVIANA','BOL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('BosniayHerzegovina','BOSNIA','BIH');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Botsuana','BOTSUANA','BWA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Brasil','BRASILEÑA','BRA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Brunéi','BRUNEANA','BRN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bulgaria','BÚLGARA','BGR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('BurkinaFaso','BURKINÉS','BFA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Burundi','BURUNDÉSA','BDI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Bután','BUTANÉSA','BTN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CaboVerde','CABOVERDIANA','CPV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Camboya','CAMBOYANA','KHM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Camerún','CAMERUNESA','CMR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Canadá','CANADIENSE','CAN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Catar','CATARÍ','QAT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Chad','CHADIANA','TCD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Chile','CHILENA','CHL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('China','CHINA','CHN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Chipre','CHIPRIOTA','CYP');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CiudaddelVaticano','VATICANA','VAT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Colombia','COLOMBIANA','COL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Comoras','COMORENSE','COM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CoreadelNorte','NORCOREANA','PRK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CoreadelSur','SURCOREANA','KOR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CostadeMarfil','MARFILEÑA','CIV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('CostaRica','COSTARRICENSE','CRI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Croacia','CROATA','HRV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Cuba','CUBANA','CUB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Dinamarca','DANÉSA','DNK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Dominica','DOMINIQUÉS','DMA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Ecuador','ECUATORIANA','ECU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Egipto','EGIPCIA','EGY');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('ElSalvador','SALVADOREÑA','SLV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('EmiratosÁrabesUnidos','EMIRATÍ','ARE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Eritrea','ERITREA','ERI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Eslovaquia','ESLOVACA','SVK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Eslovenia','ESLOVENA','SVN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('España','ESPAÑOLA','ESP');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('EstadosUnidos','ESTADOUNIDENSE','USA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Estonia','ESTONIA','EST');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Etiopía','ETÍOPE','ETH');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Filipinas','FILIPINA','PHL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Finlandia','FINLANDÉSA','FIN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Fiyi','FIYIANA','FJI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Francia','FRANCÉSA','FRA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Gabón','GABONÉSA','GAB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Gambia','GAMBIANA','GMB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Georgia','GEORGIANA','GEO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Gibraltar','GIBRALTAREÑA','GIB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Ghana','GHANÉSA','GHA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Granada','GRANADINA','GRD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Grecia','GRIEGA','GRC');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Groenlandia','GROENLANDÉSA','GRL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Guatemala','GUATEMALTECA','GTM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Guineaecuatorial','ECUATOGUINEANA','GNQ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Guinea','GUINEANA','GIN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Guinea-Bisáu','GUINEANA','GNB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Guyana','GUYANESA','GUY');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Haití','HAITIANA','HTI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Honduras','HONDUREÑA','HND');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Hungría','HÚNGARA','HUN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('India','HINDÚ','IND');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Indonesia','INDONESIA','IDN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Irak','IRAQUÍ','IRQ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Irán','IRANÍ','IRN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Irlanda','IRLANDÉSA','IRL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Islandia','ISLANDÉSA','ISL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('IslasCook','COOKIANA','COK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('IslasMarshall','MARSHALÉSA','MHL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('IslasSalomón','SALOMONENSE','SLB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Israel','ISRAELÍ','ISR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Italia','ITALIANA','ITA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Jamaica','JAMAIQUINA','JAM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Japón','JAPONÉSA','JPN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Jordania','JORDANA','JOR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Kazajistán','KAZAJA','KAZ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Kenia','KENIATA','KEN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Kirguistán','KIRGUISA','KGZ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Kiribati','KIRIBATIANA','KIR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Kuwait','KUWAITÍ','KWT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Laos','LAOSIANA','LAO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Lesoto','LESOTENSE','LSO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Letonia','LETÓNA','LVA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Líbano','LIBANÉSA','LBN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Liberia','LIBERIANA','LBR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Libia','LIBIA','LBY');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Liechtenstein','LIECHTENSTEINIANA','LIE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Lituania','LITUANA','LTU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Luxemburgo','LUXEMBURGUÉSA','LUX');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Madagascar','MALGACHE','MDG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Malasia','MALASIA','MYS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Malaui','MALAUÍ','MWI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Maldivas','MALDIVA','MDV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Malí','MALIENSE','MLI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Malta','MALTÉSA','MLT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Marruecos','MARROQUÍ','MAR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Martinica','MARTINIQUÉS','MTQ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Mauricio','MAURICIANA','MUS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Mauritania','MAURITANA','MRT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('México','MEXICANA','MEX');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Micronesia','MICRONESIA','FSM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Moldavia','MOLDAVA','MDA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Mónaco','MONEGASCA','MCO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Mongolia','MONGOLA','MNG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Montenegro','MONTENEGRINA','MNE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Mozambique','MOZAMBIQUEÑA','MOZ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Namibia','NAMIBIA','NAM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Nauru','NAURUANA','NRU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Nepal','NEPALÍ','NPL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Nicaragua','NICARAGÜENSE','NIC');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Níger','NIGERINA','NER');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Nigeria','NIGERIANA','NGA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Noruega','NORUEGA','NOR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('NuevaZelanda','NEOZELANDÉSA','NZL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Omán','OMANÍ','OMN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('PaísesBajos','NEERLANDÉSA','NLD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Pakistán','PAKISTANÍ','PAK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Palaos','PALAUANA','PLW');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Palestina','PALESTINA','PSE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Panamá','PANAMEÑA','PAN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('PapúaNuevaGuinea','PAPÚ','PNG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Paraguay','PARAGUAYA','PRY');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Perú','PERUANA','PER');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Polonia','POLACA','POL');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Portugal','PORTUGUÉSA','PRT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('PuertoRico','PUERTORRIQUEÑA','PRI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('ReinoUnido','BRITÁNICA','GBR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicaCentroafricana','CENTROAFRICANA','CAF');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicaCheca','CHECA','CZE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicadeMacedonia','MACEDONIA','MKD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicadelCongo','CONGOLEÑA','COG');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicaDemocráticadelCongo','CONGOLEÑA','COD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicaDominicana','DOMINICANA','DOM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('RepúblicaSudafricana','SUDAFRICANA','ZAF');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Ruanda','RUANDÉSA','RWA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Rumanía','RUMANA','ROU');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Rusia','RUSA','RUS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Samoa','SAMOANA','WSM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SanCristóbalyNieves','CRISTOBALEÑA','KNA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SanMarino','SANMARINENSE','SMR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SanVicenteylasGranadinas','SANVICENTINA','VCT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SantaLucía','SANTALUCENSE','LCA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SantoToméyPríncipe','SANTOTOMENSE','STP');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Senegal','SENEGALÉSA','SEN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Serbia','SERBIA','SRB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Seychelles','SEYCHELLENSE','SYC');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SierraLeona','SIERRALEONÉSA','SLE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Singapur','SINGAPURENSE','SGP');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Siria','SIRIA','SYR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Somalia','SOMALÍ','SOM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SriLanka','CEILANÉSA','LKA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Suazilandia','SUAZI','SWZ');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('SudándelSur','SURSUDANÉSA','SSD');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Sudán','SUDANÉSA','SDN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Suecia','SUECA','SWE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Suiza','SUIZA','CHE');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Surinam','SURINAMESA','SUR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Tailandia','TAILANDÉSA','THA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Tanzania','TANZANA','TZA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Tayikistán','TAYIKA','TJK');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('TimorOriental','TIMORENSE','TLS');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Togo','TOGOLÉSA','TGO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Tonga','TONGANA','TON');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('TrinidadyTobago','TRINITENSE','TTO');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Túnez','TUNECINA','TUN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Turkmenistán','TURCOMANA','TKM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Turquía','TURCA','TUR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Tuvalu','TUVALUANA','TUV');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Ucrania','UCRANIANA','UKR');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Uganda','UGANDÉSA','UGA');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Uruguay','URUGUAYA','URY');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Uzbekistán','UZBEKA','UZB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Vanuatu','VANUATUENSE','VUT');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Venezuela','VENEZOLANA','VEN');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Vietnam','VIETNAMITA','VNM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Yemen','YEMENÍ','YEM');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Yibuti','YIBUTIANA','DJI');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Zambia','ZAMBIANA','ZMB');
INSERT INTO nacionalidad(pais_nac,gentilicio_nac,iso_nac)VALUES('Zimbabue','ZIMBABUENSE','ZWE');

INSERT INTO siga.cursos (annio,nivel,periodo_academico,seccion,turno) VALUES
                                                                          ('1°','MEDIA','2022-2023','A','MAÑANA'),
                                                                          ('5°','MEDIA','2022-2023','A','MAÑANA'),
                                                                          ('1°','MEDIA','2022-2023','B','MAÑANA'),
                                                                          ('1°','MEDIA','2022-2023','C','MAÑANA'),
                                                                          ('2°','MEDIA','2022-2023','A','MAÑANA'),
                                                                          ('2°','MEDIA','2022-2023','B','MAÑANA'),
                                                                          ('2°','MEDIA','2022-2023','C','MAÑANA'),
                                                                          ('3°','MEDIA','2022-2023','A','MAÑANA'),
                                                                          ('3°','MEDIA','2022-2023','B','MAÑANA'),
                                                                          ('3°','MEDIA','2022-2023','C','MAÑANA');
INSERT INTO siga.cursos (annio,nivel,periodo_academico,seccion,turno) VALUES
                                                                          ('4°','MEDIA','2022-2023','A','MAÑANA'),
                                                                          ('4°','MEDIA','2022-2023','B','MAÑANA'),
                                                                          ('4°','MEDIA','2022-2023','C','MAÑANA'),
                                                                          ('5°','MEDIA','2022-2023','B','MAÑANA'),
                                                                          ('5°','MEDIA','2022-2023','C','MAÑANA');


INSERT INTO siga.representantes (direccion,direccion_laboral,edad,email,empresa_donde_trabaja,activo,estado_civil,fecha_nacimiento,numero_documento,ocupacion,primer_apellido,primer_nombre,profesion,segundo_apellido,segundo_nombre,sexo,codigo_operadora_telefono,telefono,codigo_operadora_telefono_empresa,telefono_empresa,tipo_documento,lugar_de_nacimiento,nacionalidad,ingreso_mensual_aproximado) VALUES
                                                                                                                                                                                                                                                                                         ('URB TRAPICHITO, GUARENAS, MUNICIPIO PLAZA, EDO MIRANDA','URB TRAPICHITO, GUARENAS, MUNICIPIO PLAZA, EDO MIRANDA','52','leninmanrique@gmail.com','CLETECI',1,'CASADO','1970-07-21','10868349','PROGRAMADOR','MANRIQUE','LENIN','INEGENIERO','ABREU','ESTEBAN','MASCULINO','0412','1086305','0212','3615164','V','VENEZUELA','VENEZOLANA','2000'),
                                                                                                                                                                                                                                                                                         ('URB ALTOS DE COPACABANA GUARENAS','CASA','53','ana@gmail.com','OFICIOS DE CASA',1,'CASADO','1969-12-05','10346789','DOCENTE','DURAN','ANA','DOCENTE','','','FEMENINO','0414','2006789','0414','3456789','V','VENEZUELA','VENEZOLANA','1800'),
                                                                                                                                                                                                                                                                                         ('URB SAN PEDRO GUARENAS','LOS CORTIJOS','35','andreinaescalona@gmail.com','CONTADRES DE VENEZUELA',1,'CASADO','1987-12-10','15456233','ADMINISTRADOR','ESCALONA','ANDREINA','CONTADOR PUBLICO','DE PEREZ','MARIA','FEMENINO','0412','1236789','0212','1278989','V','VENEZUELA','VENEZOLANA','2500'),
                                                                                                                                                                                                                                                                                         ('URB TRAPICHITO GUARENAS','CC MIRANDA GUARENAS','36','kimberlyf@gmail.com','MR RICKIS',1,'SOLTERO','1987-04-01','15678990','DECORADOR','FUENTES','KIMBERLY','DISEÑADOR GRAFICO','','','FEMENINO','0412','1112323','0212','1278989','V','VENEZUELA','VENEZOLANA','1600'),
                                                                                                                                                                                                                                                                                         ('URB TRAPICHITO GUARENAS','LA CAMPINA','42','jose@gmail.com','PDVSA',1,'CASADO','1980-04-12','13890678','SUPERVISOR','PIAZOLA','JOSE','ingeniero electricista','PEREZ','LUIS','MASCULINO','0412','2003456','0212','2018989','V','VENEZUELA','VENEZOLANA','2000'),
                                                                                                                                                                                                                                                                                         ('URB TRAPICHITO GUARENAS','LOS DOS CAMINOS','42','juan@gmail.com','CAUCHOS DE VENEZUELA',1,'CASADO','1981-12-10','15200567','SUPERVISOR','ALBORNOZ','JUAN','ingeniero indistrial','PEREZ','JOSE','MASCULINO','0412','2008990','0212','2016565','V','VENEZUELA','VENEZOLANA','2000'),
                                                                                                                                                                                                                                                                                         ('URB LA VAQUERA GUARENAS','CHACAITO','43','carmen@gmail.com','UBIPAGOS',1,'CASADO','1980-03-14','12911354','DESARROLLADOR DE SOFTWARE','ALBORNOZ','CARMEN','INGENIERO EN COMPUTACION','GONZALEZ','ALICIA','FEMENINO','0416','7342345','0212','2678990','V','VENEZUELA','VENEZOLANA','2200'),
                                                                                                                                                                                                                                                                                         ('URB EL INGENIO GUATIRES','CASA','43','josef@gmail.com','CASA',1,'CASADO','1982-03-19','13911001','OFICIOS DEL HOGAR','PEREZ','JOANNA','ABOGADO','DE DEFREITAS','JOSEFINA','FEMENINO','0424','1590909','0212','3612345','V','VENEZUELA','VENEZOLANA','2500'),
                                                                                                                                                                                                                                                                                         ('URB NUEVA CASARAPA GUARENAS','LOS CORTIJOS','43','adrianmanuel@gmail.com','EMPRESAS POLAR',1,'CASADO','1982-07-19','12109876','COMERCIALIZADOR DE PRODUCTOS','CHACON','ADRIAN','INGENIERO INDUSTRIAL','ARIZA','MANUEL','MASCULINO','0424','2113456','0212','7621123','V','VENEZUELA','VENEZOLANA','1600');


INSERT INTO siga.alumnos (condicion,direccion,edad,email,activo,fecha_creacion,fecha_ingreso,fecha_nacimiento,numero_documento,parentesco,primer_apellido,primer_nombre,segundo_apellido,segundo_nombre,sexo,codigo_operadora_telefono,telefono,tipo_documento,lugar_de_nacimiento,nacionalidad,curso,numero_lista,representante) VALUES
                                                                                                                                                                                                                                                                                               ('REGULAR','URB TRAPICHITO, GUARENAS, MUNICIPIO PLAZA, EDO MIRANDA','16','sinamnarique@gmail.com',1,'2023-05-21','2018-10-15','2006-09-26','31644788','PADRE','MANRIQUE','SINAI','SALINAS','SOFIA','FEMENINO','0412','9985406','V','VENEZUELA','VENEZOLANA',15,null,1),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION ALTOS DE COPACABANA GUARENAS','14','luis@gmail.com',1,'2023-05-21','2010-10-15','2009-02-05','32586102','MADRE','GONZALEZ','LUIS','DURAN','JOSÉ','MASCULINO','0414','3065789','V','VENEZUELA','VENEZOLANA',1,null,2),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION SAN PEDRO GUARENAS','16','genesis@gmail.com',1,'2023-05-21','2018-10-10','2006-06-13','32456213','MADRE','PEREZ','GENESIS','ESCALONA','ALEJANDRA','FEMENINO','0414','2113456','V','VENEZUELA','VENEZOLANA',2,null,3),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION SAN PEDRO GUARENAS','12','alejandro@gmail.com',1,'2023-05-21','2020-10-10','2010-08-16','34456259','MADRE','PEREZ','ALEJANDRO','ESCALONA','ENRIQUE','MASCULINO','0414','2113456','V','VENEZUELA','VENEZOLANA',1,null,3),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION TRAPICHITO SECTOR TRES GUARENAS','16','avril@gmail.com',1,'2023-05-21','2020-10-10','2006-04-04','31456257','MADRE','FERNANDES','AVRIL','FUENTES','ANDREINA','FEMENINO','0414','2113488','V','VENEZUELA','VENEZOLANA',15,null,4),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION TRAPICHITO SECTOR TRES GUARENAS','16','anderson@gmail.com',1,'2023-05-21','2020-10-10','2006-07-15','32827345','PADRE','PIAZOLA','ANDERSON','MARTINEZ','JOSE','MASCULINO','0416','1113425','V','VENEZUELA','VENEZOLANA',15,null,5),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION TRAPICHITO SECTOR TRES GUARENAS','13','jennifer@gmail.com',1,'2023-05-21','2020-10-10','2010-01-30','34827345','PADRE','PIAZOLA','JENNIFER','MARTINEZ','EUGENIA','FEMENINO','0416','1113425','V','VENEZUELA','VENEZOLANA',1,null,5),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION TRAPICHITO SECTOR DOS GUARENAS','12','andres@gmail.com',1,'2023-05-21','2020-10-12','2010-09-30','34788679','PADRE','ALBORNOZ','ANDRES','CASILLAS','MANUEL','MASCULINO','0416','5007878','V','VENEZUELA','VENEZOLANA',1,null,6),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION LA VAQUERA GUARENAS','12','barbara@gmail.com',1,'2023-05-21','2020-10-12','2010-10-05','32727456','MADRE','HERNANDEZ','BARBARA','GONZALEZ','','FEMENINO','0414','3001154','V','VENEZUELA','VENEZOLANA',5,null,7),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION EL INGENIO GUATIRE','14','saradf@hotmail.com',1,'2023-05-21','2020-11-01','2008-07-05','33528764','MADRE','DEFREITAS','SARA','ANZOLA','DEL VALLE','FEMENINO','0424','1341820','V','VENEZUELA','VENEZOLANA',8,null,8);
INSERT INTO siga.alumnos (condicion,direccion,edad,email,activo,fecha_creacion,fecha_ingreso,fecha_nacimiento,numero_documento,parentesco,primer_apellido,primer_nombre,segundo_apellido,segundo_nombre,sexo,codigo_operadora_telefono,telefono,tipo_documento,lugar_de_nacimiento,nacionalidad,curso,numero_lista,representante) VALUES
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION NUEVA CASARAPA','15','adrian@hotmail.com',1,'2023-05-21','2020-11-01','2008-02-05','33811234','PADRE','CHACON','ADRIAN','RAMIREZ','ALEJANDRO','MASCULINO','0424','3001145','V','VENEZUELA','VENEZOLANA',11,null,9),
                                                                                                                                                                                                                                                                                               ('REGULAR','URBANIZACION NUEVA CASARAPA','13','mariale@hotmail.com',1,'2023-05-22','2021-11-01','2009-08-21','33811256','PADRE','CHACON','MARIA','RAMIREZ','ALEJANDRA','FEMENINO','0424','3001145','V','VENEZUELA','VENEZOLANA',9,null,9);



INSERT INTO siga.docentes (id, tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, fecha_nacimiento, fecha_ingreso, fecha_creacion, estado_civil, edad, pregrado1, pregrado2, postgrado1, postgrado2, curso1, curso2, curso3, curso4, graduado_pregrado1, categoria, tiempo_de_servicio, direccion,codigo_operadora_telefono, telefono, email, activo, condicion, lugar_de_nacimiento, nacionalidad) VALUES (1, 'V', '9523698', 'MIGUEL', 'ANGEL', 'PALACIOS', 'FERNADEZ', 'MASCULINO', '1969-11-26', '2012-10-14', '2023-06-04', 'SOLTERO', '53', 'INGENIERIA DE SISTEMAS', null, null, null, 'TECNICO EN TELECOMUNICACIONES', 'REDES DE COMPUTADORAS', '', '', 'SI', 'DOCENTE 1', 5, 'CALLE REAL DEL CEMENTERIO','0412', '5698877', 'mpfernadez@gmail.com', true, 'EN EJERCICIO', 'VENEZUELA', 'VENEZOLANA');
INSERT INTO siga.docentes (id, tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, fecha_nacimiento, fecha_ingreso, fecha_creacion, estado_civil, edad, pregrado1, pregrado2, postgrado1, postgrado2, curso1, curso2, curso3, curso4, graduado_pregrado1, categoria, tiempo_de_servicio, direccion,codigo_operadora_telefono,telefono, email, activo, condicion, lugar_de_nacimiento, nacionalidad) VALUES (2, 'V', '6456789', 'MIGUEL', 'ANGEL', 'ESTEVA', 'RUIZ', 'MASCULINO', '1959-04-26', '2012-10-14', '2023-06-09', 'SOLTERO', '63', 'INGENIERIA DE SISTEMAS', null, null, null, 'TECNICO EN TELECOMUNICACIONES', 'REDES DE COMPUTADORAS', '', '', 'SI', 'DOCENTE 3', 5, 'LOS FRAILES DE CATIA','0414', '9986756', 'mesteva@gmail.com', true, 'EN EJERCICIO', 'VENEZUELA', 'VENEZOLANA');

INSERT INTO siga.cursos_docentes (id, docente, curso, materia) VALUES (1, 1, 15, 5);
INSERT INTO siga.cursos_docentes (id, docente, curso, materia) VALUES (2, 2, 15, 30);


INSERT INTO profesiones (profesion) VALUES
                                                     ('ABOGADO'),
                                                     ('ADMINISTRADOR'),
                                                     ('ARQUITECTO'),
                                                     ('BIBLIOTECARIO'),
                                                     ('BIOLOGO'),
                                                     ('ECONOMISTA'),
                                                     ('FARMACEÚTICO'),
                                                     ('FILÓSOFO'),
                                                     ('FISIOTERAPEUTA'),
                                                     ('GEÓGRAFO');
INSERT INTO profesiones (profesion) VALUES
                                                     ('GEÓLOGO'),
                                                     ('HISTORIADOR'),
                                                     ('INGENIERO'),
                                                     ('LICENCIADO'),
                                                     ('MÉDICO'),
                                                     ('PROFESOR'),
                                                     ('PROFESORA'),
                                                     ('LICENCIADA');
















