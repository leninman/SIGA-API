create table cursos
(
    id                bigint auto_increment
        primary key,
    annio             varchar(2) null,
    nivel             varchar(15) null,
    periodo_academico varchar(20) null,
    seccion           varchar(2) null,
    turno             varchar(15) null
);

create table materias
(
    id     bigint auto_increment
        primary key,
    annio  varchar(2) null,
    codigo varchar(10) null,
    nivel  varchar(15) null,
    nombre varchar(100) null
);

create table representantes
(
    id                    bigint auto_increment
        primary key,
    direccion             varchar(255) not null,
    direccion_laboral     varchar(255) not null,
    edad                  varchar(2) not null,
    email                 varchar(50) not null,
    empresa_donde_trabaja varchar(255) not null,
    activo                bit          not null,
    estado_civil          varchar(10) not null,
    fecha_nacimiento      date         not null,
    numero_documento      varchar(10) not null,
    ocupacion             varchar(50) null,
    primer_apellido       varchar(20) not null,
    primer_nombre         varchar(20) not null,
    profesion             varchar(50) null,
    segundo_apellido      varchar(20) null,
    segundo_nombre        varchar(20) null,
    sexo                  varchar(15) not null,
    codigo_operadora_telefono varchar(5) not null,
    telefono              varchar(20) not null,
    codigo_operadora_telefono_empresa  varchar(5) not null,
    telefono_empresa      varchar(20) not null,
    tipo_documento        varchar(1) not null,
    lugar_de_nacimiento   varchar(20) null,
    nacionalidad          varchar(20) null,
    ingreso_mensual_aproximado varchar(20) null
);

create table alumnos
(
    id               bigint auto_increment
        primary key,
    condicion        varchar(15) not null,
    direccion        varchar(255) not null,
    edad             varchar(2) not null,
    email            varchar(50) not null,
    activo           bit          not null,
    fecha_creacion   date         not null,
    fecha_ingreso    date         not null,
    fecha_nacimiento date         not null,
    numero_documento varchar(10) not null,
    parentesco       varchar(15) not null,
    primer_apellido  varchar(20) not null,
    primer_nombre    varchar(20) not null,
    segundo_apellido varchar(20) null,
    segundo_nombre   varchar(20) null,
    sexo             varchar(15) not null,
    codigo_operadora_telefono varchar(5) not null,
    telefono         varchar(20) not null,
    tipo_documento   varchar(1) not null,
    lugar_de_nacimiento   varchar(20) null,
    nacionalidad          varchar(20) null,
    curso            bigint       not null,
    numero_lista     bigint       null,
    representante    bigint       not null,
    constraint fk_curso
        foreign key (curso) references cursos (id),
    constraint fk_representante
        foreign key (representante) references representantes (id)
);
create table docentes (
    id          bigint auto_increment
        primary key,
    tipo_documento varchar(1) not null,
    numero_documento varchar(10) not null,
    primer_nombre varchar(20) not null,
    segundo_nombre varchar(20) null,
    primer_apellido varchar(20) not null,
    segundo_apellido varchar(20) null,
    sexo varchar(15) not null,
    fecha_nacimiento date not null,
    fecha_ingreso date not null,
    fecha_creacion date not null,
    estado_civil varchar(10) not null,
    edad varchar(2) not null,
    pregrado1 varchar(100) not null,
    pregrado2 varchar(100) null,
    postgrado1 varchar(100) null,
    postgrado2 varchar(100) null,
    curso1 varchar(100) null,
    curso2 varchar(100) null,
    curso3 varchar(100) null,
    curso4 varchar(100) null,
    graduado_pregrado1 varchar(2) not null,
    categoria varchar(50) null,
    tiempo_de_servicio integer not null,
    direccion varchar(255) not null,
    codigo_operadora_telefono varchar(5) not null,
    telefono varchar(20) not null,
    email varchar(50) not null,
    activo bit not null,
    condicion varchar(15) not null,
    lugar_de_nacimiento   varchar(20) null,
    nacionalidad          varchar(20) null,
    asignaturas_especializadas      varchar(500) null
);


create table periodos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(20) null,
    estado      varchar(10) null

);
create table niveles
(
    id                bigint auto_increment
        primary key,
    valor             varchar(20) null

);
create table turnos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(15) null

);
create table annios
(
    id                bigint auto_increment
        primary key,
    valor             varchar(2) null
);
create table secciones
(
    id                bigint auto_increment
        primary key,
    valor             varchar(2) null
);
create table sexos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(15) null
);
create table estado_civil
(
    id                bigint auto_increment
        primary key,
    valor             varchar(20) null
);
create table nacionalidad
(
    id                bigint auto_increment
        primary key,
    pais_nac             varchar(100) null,
    gentilicio_nac             varchar(100) null,
    iso_nac             varchar(20) null
);
create table condiciones
(
    id                bigint auto_increment
        primary key,
    valor             varchar(15) null
);
create table lapsos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(2) null,
    descripcion       varchar(20) null,
    porcentaje        varchar(2) null
);
create table cursos_docentes
(
    id                bigint auto_increment
        primary key,
    docente    bigint not null,
    curso       bigint not null,
    materia     bigint not null,
    constraint curso_docente_fk_profesor
        foreign key (docente) references docentes (id),
    constraint curso_docente_fk_curso
        foreign key (curso) references cursos (id),
    constraint curso_docente_fk_materia
        foreign key (materia) references materias (id)
);
create table notas_parciales
(
    id                bigint auto_increment
    primary key,
    alumno     bigint not null,
    docente    bigint not null,
    curso      bigint not null,
    materia    bigint not null,
    lapso      varchar(15) not null,
    nota       varchar(2) not null,
    porcentaje varchar(8) not null,
    constraint nota_fk_alumno
        foreign key (alumno) references alumnos (id),
    constraint nota_fk_docente
        foreign key (docente) references docentes (id),
    constraint nota_fk_curso
        foreign key (curso) references cursos (id),
    constraint nota_fk_materia
        foreign key (materia) references materias (id)
);
create table usuarios
(
    id                bigint auto_increment
        primary key,
    nombres             varchar(20) null,
    apellidos           varchar(20) null,
    nombre_usuario      varchar(20) not null,
    clave             varchar(255) not null,
    correo             varchar(20) null,
    fecha_creacion      Date null,
    fecha_modificacion  Date null,
    locked              boolean null,
    enabled             boolean null,
    num_intentos_fallidos             integer null,
    activo             bit null,
    fecha_ultima_conexion             date null
);
create table roles
(
    id                bigint auto_increment
        primary key,
    nombre_rol             varchar(20) not null
);
create table usuario_rol
(
    id                bigint auto_increment
        primary key,
    usuario_id             bigint not null,
    rol_id                 bigint not null,
    constraint fk_usuario
        foreign key (usuario_id) references usuarios (id),
    constraint fk_rol
        foreign key (rol_id) references roles (id)
);

create table profesiones
(
    id                bigint auto_increment
        primary key,
    profesion             varchar(256) null

);
