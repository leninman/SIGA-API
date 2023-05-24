create table cursos
(
    id                bigint auto_increment
        primary key,
    annio             varchar(255) null,
    nivel             varchar(255) null,
    periodo_academico varchar(255) null,
    seccion           varchar(255) null,
    turno             varchar(255) null
);

create table materias
(
    id     bigint auto_increment
        primary key,
    annio  varchar(255) null,
    codigo varchar(255) null,
    nivel  varchar(255) null,
    nombre varchar(255) null
);

create table representantes
(
    id                    bigint auto_increment
        primary key,
    direccion             varchar(255) not null,
    direccion_laboral     varchar(255) not null,
    edad                  varchar(2) not null,
    email                 varchar(255) not null,
    empresa_donde_trabaja varchar(255) not null,
    activo                bit          not null,
    estado_civil          varchar(10) not null,
    fecha_nacimiento      date         not null,
    numero_documento      varchar(25) not null,
    ocupacion             varchar(255) null,
    primer_apellido       varchar(255) not null,
    primer_nombre         varchar(255) not null,
    profesion             varchar(255) null,
    segundo_apellido      varchar(255) null,
    segundo_nombre        varchar(255) null,
    sexo                  varchar(15) not null,
    telefono              varchar(255) not null,
    telefono_empresa      varchar(255) not null,
    tipo_documento        varchar(1) not null,
    lugar_de_nacimiento   varchar(255) null,
    nacionalidad          varchar(50) null,
    ingreso_mensual_aproximado varchar(50) null
);

create table alumnos
(
    id               bigint auto_increment
        primary key,
    condicion        varchar(15) not null,
    direccion        varchar(255) not null,
    edad             varchar(2) not null,
    email            varchar(255) not null,
    activo           bit          not null,
    fecha_creacion   date         not null,
    fecha_ingreso    date         not null,
    fecha_nacimiento date         not null,
    numero_documento varchar(25) not null,
    parentesco       varchar(255) not null,
    primer_apellido  varchar(255) not null,
    primer_nombre    varchar(255) not null,
    segundo_apellido varchar(255) null,
    segundo_nombre   varchar(255) null,
    sexo             varchar(15) not null,
    telefono         varchar(255) not null,
    tipo_documento   varchar(1) not null,
    lugar_de_nacimiento   varchar(255) null,
    nacionalidad          varchar(50) null,
    curso            bigint       not null,
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
    numero_documento varchar(25) not null,
    primer_nombre varchar(255) not null,
    segundo_nombre varchar(255) null,
    primer_apellido varchar(255) not null,
    segundo_apellido varchar(255) null,
    sexo varchar(15) not null,
    fecha_nacimiento date not null,
    fecha_ingreso date not null,
    fecha_creacion date not null,
    estado_civil varchar(10) not null,
    edad varchar(2) not null,
    pregrado1 varchar(255) not null,
    pregrado2 varchar(255) null,
    postgrado1 varchar(255) null,
    postgrado2 varchar(255) null,
    curso1 varchar(255) null,
    curso2 varchar(255) null,
    curso3 varchar(255) null,
    curso4 varchar(255) null,
    graduado_pregrado1 varchar(2) not null,
    categoria varchar(50) null,
    tiempo_de_servicio integer not null,
    direccion varchar(255) not null ,
    telefono varchar(15) not null,
    email varchar(30) not null,
    activo bit not null,
    condicion varchar(15) not null,
    lugar_de_nacimiento   varchar(255) null,
    nacionalidad          varchar(50) null
);


create table periodos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null,
    estado      varchar(255) null

);
create table niveles
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null

);
create table turnos
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null

);
create table annios
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null
);
create table secciones
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null
);
create table condiciones
(
    id                bigint auto_increment
        primary key,
    valor             varchar(255) null
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
    porcentaje varchar(2) not null,
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
    nombre             varchar(255) null,
    apellido           varchar(255) null,
    nombre_usuario      varchar(255) not null,
    password             varchar(255) not null,
    email             varchar(255) null,
    num_intentos_fallidos             integer null,
    activo             bit null,
    fecha_ultima_conexion             date null
);
create table roles
(
    id                bigint auto_increment
        primary key,
    rol_nombre             varchar(255) not null
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
