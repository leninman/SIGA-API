# SIGA-API — Documentación completa

Sistema de Información de Gestión Académica. API REST para la administración de alumnos, docentes, representantes, cursos, materias y calificaciones parciales.

| Campo | Valor |
|-------|-------|
| **Organización** | Tecnodestreza |
| **Paquete base** | `com.tecnodestreza.siga` |
| **Versión** | 1.0 |
| **URL base (local)** | `http://localhost:8090/siga/api/v1` |

---

## Tabla de contenidos

1. [Descripción general](#1-descripción-general)
2. [Stack tecnológico](#2-stack-tecnológico)
3. [Arquitectura](#3-arquitectura)
4. [Instalación y ejecución](#4-instalación-y-ejecución)
5. [Configuración](#5-configuración)
6. [Modelo de datos](#6-modelo-de-datos)
7. [Catálogos del sistema](#7-catálogos-del-sistema)
8. [API REST — Referencia completa](#8-api-rest--referencia-completa)
9. [DTOs y validaciones](#9-dtos-y-validaciones)
10. [Lógica de negocio (servicios)](#10-lógica-de-negocio-servicios)
11. [Mappers y utilidades](#11-mappers-y-utilidades)
12. [Manejo de errores](#12-manejo-de-errores)
13. [Seguridad](#13-seguridad)
14. [Docker](#14-docker)
15. [Debug](#15-debug)
16. [Tests](#16-tests)
17. [Limitaciones conocidas](#17-limitaciones-conocidas)

---

## 1. Descripción general

SIGA-API expone endpoints HTTP para un colegio o institución educativa. Cubre:

- **Matrícula y gestión de alumnos** (con representante y curso asociados)
- **Registro de docentes** y asignación a cursos/materias
- **Representantes legales** (padres o tutores)
- **Cursos académicos** (año, sección, turno, nivel, periodo)
- **Materias** y **notas parciales** por lapso
- **Catálogos auxiliares** (nacionalidades, profesiones, etc.)

La API no tiene autenticación activa en la rama actual; Spring Security y JWT están preparados pero comentados.

---

## 2. Stack tecnológico

| Componente | Tecnología | Versión |
|------------|------------|---------|
| Lenguaje | Java | 17 (pom) / compilador Maven 9 |
| Framework | Spring Boot | 2.3.3 |
| Persistencia | Spring Data JPA / Hibernate | 5.4.x |
| Base de datos | MySQL | 8.x |
| Migraciones | Flyway | 6.0.3 |
| Mapeo | ModelMapper + mappers propios | 3.2.0 |
| Boilerplate | Lombok | 1.18.34 |
| Validación | Bean Validation | javax.validation |
| Build | Maven | 3.8+ |
| Contenedor | Docker + OpenJDK 17 Alpine | — |

---

## 3. Arquitectura

### 3.1 Capas

```
┌─────────────────────────────────────────┐
│           Controllers (REST)            │  ← HTTP, validación de entrada
├─────────────────────────────────────────┤
│              Services (*Impl)           │  ← Lógica de negocio
├─────────────────────────────────────────┤
│         Repositories (JpaRepository)    │  ← Acceso a datos
├─────────────────────────────────────────┤
│     Models (entidades JPA) + DTOs       │
├─────────────────────────────────────────┤
│              MySQL (Flyway)             │
└─────────────────────────────────────────┘
```

### 3.2 Estructura de directorios

```
src/main/java/com/tecnodestreza/siga/
├── SigaApplication.java          # Punto de entrada
├── controllers/                  # 8 controladores REST
├── services/                     # Interfaces + implementaciones
├── repo/                         # 17 repositorios JPA
├── models/                       # Entidades JPA
│   └── dto/                      # Objetos de transferencia
├── mappers/                      # Conversión DTO ↔ entidad
└── utils/                        # Utilidades (cálculo de notas)

src/main/resources/
├── application.properties
└── db/migration/                 # Scripts Flyway

scripts/
└── start-local.ps1               # Arranque local Windows

.vscode/
└── launch.json                   # Configuración debug Cursor/VS Code
```

### 3.3 Diagrama de relaciones (entidades principales)

```
Representante ──< Alumno >── Curso
                              │
Docente ──< CursoDocente >────┤
              │               │
           Materia            │
                              │
Alumno ──< NotaParcial >── Docente, Curso, Materia
```

---

## 4. Instalación y ejecución

### 4.1 Requisitos

- Java 17+ (probado con Java 21)
- Maven 3.8+
- MySQL 8 con base de datos `siga`

### 4.2 Arranque rápido (Windows)

```powershell
cd C:\SIGA-API
.\scripts\start-local.ps1
```

El script verifica conectividad a MySQL, define variables de entorno y ejecuta `mvn spring-boot:run`.

### 4.3 Arranque manual

```powershell
$env:SIGA_DB_SERVERNAME = "localhost"
$env:SIGA_DB_PORT = "3306"
$env:SIGA_DB_NAME = "siga"
$env:SIGA_DB_USERNAME = "root"
$env:SIGA_DB_PASSWORD = "password"

mvn spring-boot:run
```

### 4.4 Compilar JAR

```powershell
mvn -DskipTests package
java -jar target/siga.jar
```

### 4.5 Verificar que funciona

```powershell
Invoke-RestMethod http://localhost:8090/siga/api/v1/profesiones
```

### 4.6 Liberar puerto 8090

```powershell
netstat -ano | findstr :8090
taskkill /PID <PID> /F
```

---

## 5. Configuración

### 5.1 `application.properties`

| Propiedad | Descripción | Default |
|-----------|-------------|---------|
| `server.servlet.context-path` | Prefijo de la API | `/siga/api/v1` |
| `server.port` | Puerto HTTP | `8090` |
| `spring.datasource.url` | JDBC MySQL | `jdbc:mysql://localhost:3306/siga` |
| `spring.datasource.username` | Usuario BD | `root` |
| `spring.datasource.password` | Contraseña BD | `password` |
| `spring.jpa.database-platform` | Dialecto Hibernate | `MySQL57Dialect` |
| `spring.flyway.locations` | Migraciones | `classpath:/db/migration/` |
| `spring.jpa.show-sql` | Log SQL | `true` |
| `jwt.secret` | Secreto JWT (no activo) | `secret` |
| `jwt.expiration` | Expiración JWT (seg) | `3600` |

### 5.2 Variables de entorno

| Variable | Descripción | Default local |
|----------|-------------|---------------|
| `PORT` | Puerto de la API | `8090` |
| `SIGA_DB_SERVERNAME` | Host MySQL | `localhost` |
| `SIGA_DB_PORT` | Puerto MySQL | `3306` |
| `SIGA_DB_NAME` | Nombre de la BD | `siga` |
| `SIGA_DB_USERNAME` | Usuario MySQL | `root` |
| `SIGA_DB_PASSWORD` | Contraseña MySQL | `password` |

### 5.3 CORS

Todos los controladores declaran `@CrossOrigin(origins = {"*"})`, permitiendo peticiones desde cualquier origen.

---

## 6. Modelo de datos

### 6.1 Tablas principales

#### `alumnos`
Datos personales, contacto, condición académica. FK a `representantes` y `cursos`. Campo `numero_lista` para orden en el curso.

#### `representantes`
Datos del padre/madre/tutor: documento, contacto, trabajo, ingresos, profesión.

#### `docentes`
Datos personales, formación académica (pregrado, postgrado, cursos), categoría, tiempo de servicio, asignaturas especializadas.

#### `cursos`
Combinación única de: `annio`, `nivel`, `periodo_academico`, `seccion`, `turno`.

#### `materias`
Catálogo por `codigo`, `nombre`, `annio`, `nivel`.

#### `cursos_docentes`
Asignación docente ↔ curso ↔ materia (tres FK).

#### `notas_parciales`
Calificación de un alumno en una materia, lapso y docente. Incluye `nota` y `porcentaje` calculado.

### 6.2 Tablas de catálogo

| Tabla | Uso |
|-------|-----|
| `annios` | 1° a 6° |
| `secciones` | A a F |
| `turnos` | DIURNO, NOCTURNO |
| `niveles` | PRIMARIA, MEDIA |
| `periodos` | Periodos académicos (ej. 2022-2023) |
| `condiciones` | REGULAR, GRADUADO, RETIRADO, EN EJERCICIO |
| `lapsos` | 1°, 2°, 3° con porcentajes 30/30/40 |
| `sexos`, `estado_civil`, `nacionalidad`, `profesiones` | Catálogos auxiliares |

### 6.3 Tablas de autenticación (sin uso en API)

`usuarios`, `roles`, `usuario_rol` — creadas por Flyway con datos seed (director, administrativo). No hay entidades JPA ni endpoints expuestos aún.

### 6.4 Migraciones Flyway

| Archivo | Contenido |
|---------|-----------|
| `V1.0__siga._initial_setup.sql` | Creación de todas las tablas y FK |
| `V1.1__siga_initial_inserts.sql` | Datos iniciales (materias, catálogos, usuarios, nacionalidades) |

> **Nota:** Si la BD local tiene migraciones más nuevas que las del repositorio (ej. versión 1.4), Flyway mostrará un warning pero la aplicación arranca si el esquema ya está aplicado.

---

## 7. Catálogos del sistema

Valores seed en `V1.1__siga_initial_inserts.sql`:

| Catálogo | Valores |
|----------|---------|
| **Niveles** | PRIMARIA, MEDIA |
| **Años** | 1°, 2°, 3°, 4°, 5°, 6° |
| **Secciones** | A, B, C, D, E, F |
| **Turnos** | DIURNO, NOCTURNO |
| **Condiciones** | REGULAR, GRADUADO, RETIRADO, EN EJERCICIO |
| **Lapsos** | 1° (30%), 2° (30%), 3° (40%) |
| **Periodo activo** | 2022-2023 |
| **Roles** | ROLE_SISTEMA, ROLE_DIRECTOR, ROLE_ADMINISTRATIVO, ROLE_PROFESOR, ROLE_EMPLEADO, ROLE_ALUMNO, ROLE_REPRESENTANTE |

**Materias:** ~50 asignaturas para nivel MEDIA (MAT, CIE, CAS, ING, ART, GHC, EFI, etc.).

**Nacionalidades:** ~200 países con gentilicio e ISO.

**Profesiones:** ABOGADO, ADMINISTRADOR, INGENIERO DE SISTEMAS, PROFESOR, etc.

---

## 8. API REST — Referencia completa

**Base URL:** `http://localhost:8090/siga/api/v1`

**Formato:** JSON (`Content-Type: application/json`)

**Autenticación:** ninguna (actualmente)

---

### 8.1 Alumnos — `/alumno`

#### `GET /alumno/listado`

Lista todos los alumnos activos.

| | |
|---|---|
| **Respuesta 200** | `List<ListadoAlumnosdto>` |

---

#### `GET /alumno/consultarporcedula`

Consulta alumno por tipo y número de documento.

| | |
|---|---|
| **Body** | `PersonaDocumentodto` |
| **Respuesta 200** | `Optional<Alumno>` |
| **Respuesta 400** | `{ "mensaje": "El campo ..." }` |
| **Respuesta 404** | `{ "mensaje": "El alumno con el número de cédula ... no está registrado" }` |
| **Respuesta 500** | `{ "mensaje": "...", "error": "..." }` |

> ⚠️ Usa **GET con body**, no estándar HTTP. Usar Postman o cliente que lo permita.

**Ejemplo body:**
```json
{
  "tipoDocumento": "V",
  "numeroDocumento": "12345678"
}
```

---

#### `GET /alumno/consultarporid/{id}`

| | |
|---|---|
| **Path** | `id` (Long) |
| **Respuesta 200** | `Optional<Alumno>` |
| **Respuesta 404** | Sin body |

---

#### `POST /alumno/crear`

Crea alumno con representante y curso (resueltos por cédula y parámetros de curso).

| | |
|---|---|
| **Body** | `Alumnodto` (validado con `@Valid`) |
| **Respuesta 201** | `Optional<Alumno>` |
| **Respuesta 400** | Validación fallida o cédula duplicada |

---

#### `PUT /alumno/modificar/{idAlumno}`

| | |
|---|---|
| **Path** | `idAlumno` (Long) |
| **Body** | `Alumnodto` |
| **Respuesta 200** | `Optional<Alumno>` |
| **Respuesta 204** | Cédula ya usada por otro alumno |

---

#### `PUT /alumno/desactivar/{idAlumno}/{condicion}`

Desactiva alumno. Si no quedan alumnos activos del representante, también lo desactiva.

| | |
|---|---|
| **Path** | `idAlumno`, `condicion` (ej. RETIRADO) |
| **Respuesta 204** | Sin body |

---

#### `GET /alumno/consultaralumnosporcurso?idcurso={id}`

| | |
|---|---|
| **Query** | `idcurso` (Long) |
| **Respuesta 200** | `List<Alumno>` |
| **Respuesta 404** | Sin alumnos en el curso |

---

### 8.2 Docentes — `/docente`

#### `GET /docente/listado`

Lista docentes activos. Respuesta: `List<Docente>`.

#### `POST /docente/crear`

| | |
|---|---|
| **Body** | `Docentedto` |
| **Respuesta 201** | `Optional<Docente>` |
| **Respuesta 204** | Cédula duplicada |

#### `PUT /docente/modificar/{idDocente}`

| | |
|---|---|
| **Body** | `Docentedto` |
| **Respuesta 200** | Docente actualizado |
| **Respuesta 204** | Cédula duplicada en otro docente |

#### `GET /docente/consultarporcedula`

| | |
|---|---|
| **Body** | `PersonaDocumentodto` |
| **Respuesta 200** | `Optional<Docente>` (vacío si no existe) |

> ⚠️ GET con body.

#### `GET /docente/consultarporid/{id}`

Respuesta: `Optional<Docente>`.

#### `PUT /docente/desactivar/{idDocente}/{condicion}`

Respuesta: **204** sin body.

---

### 8.3 Representantes — `/representante`

#### `POST /representante/crear`

| | |
|---|---|
| **Body** | `Representantedto` |
| **Respuesta 201** | `Optional<Representante>` |
| **Respuesta 204** | Cédula duplicada |

#### `POST /representante/consultarporcedula`

| | |
|---|---|
| **Body** | `PersonaDocumentodto` |
| **Respuesta 200** | `Optional<Representante>` |
| **Respuesta 404** | No encontrado |

---

### 8.4 Cursos — `/curso`

#### `POST /curso/crear`

| | |
|---|---|
| **Body** | `Cursodto` |
| **Respuesta 201** | `Optional<Curso>` |
| **Respuesta 500** | Curso duplicado (misma combinación año/sección/turno/nivel/periodo) |

**Ejemplo body:**
```json
{
  "annio": "1°",
  "seccion": "A",
  "periodoAcademico": "2022-2023",
  "turno": "DIURNO",
  "nivel": "MEDIA"
}
```

#### `GET /curso/listado`

Respuesta: `List<Curso>`.

#### `POST /curso/asignardocente`

Asigna un docente a un curso y materia.

| | |
|---|---|
| **Body** | `CursoDocentedto` |

```json
{
  "cursoId": 1,
  "materiaId": 5,
  "docenteId": 2
}
```

#### `POST /curso/cargarcurso?idcurso={id}`

Asigna alumnos (por cédula) a un curso y les asigna número de lista ordenado por documento.

| | |
|---|---|
| **Query** | `idcurso` (Long) |
| **Body** | `CedulaAlumnodto` |

```json
{
  "cedulas": [
    { "tipoDocumento": "V", "numeroDocumento": "11111111" },
    { "tipoDocumento": "V", "numeroDocumento": "22222222" }
  ]
}
```

#### `GET /curso/cursospordocente`

Cursos asignados a un docente (por cédula).

| | |
|---|---|
| **Body** | `PersonaDocumentodto` |

> ⚠️ GET con body.

---

### 8.5 Materias — `/materia`

#### `GET /materia/listado`

Respuesta: `List<String>` — nombres distintos de materias.

---

### 8.6 Notas — `/notas`

#### `POST /notas/crear`

Registra notas parciales en lote. Solo guarda si no existe nota previa para el mismo alumno + materia + lapso. Calcula `porcentaje` automáticamente.

| | |
|---|---|
| **Body** | `NotasParcialesdto` |

```json
{
  "notasParciales": [
    {
      "alumnoId": 1,
      "docenteId": 2,
      "cursoId": 1,
      "materiaId": 5,
      "lapso": "1°",
      "nota": "18",
      "porcentaje": null
    }
  ]
}
```

Respuesta **200**: `List<NotaParcial>` (solo las insertadas).

#### `GET /notas/consultar?lapso={lapso}`

Consulta notas de un alumno por cédula.

| | |
|---|---|
| **Query** | `lapso` (opcional, ej. `1°`) |
| **Body** | `PersonaDocumentodto` |
| **Respuesta 200** | `ConsultaNotasAlumnodto` |
| **Respuesta 404** | Alumno no encontrado |

> ⚠️ GET con body.

---

### 8.7 Catálogos auxiliares

#### `GET /profesiones`

Respuesta: `List<Profesion>`.

#### `GET /nacionalidades`

Respuesta: `List<Nacionalidad>` (nombres de país en mayúsculas).

---

### 8.8 Índice rápido de endpoints (22 total)

```
GET    /alumno/listado
GET    /alumno/consultarporcedula              [body]
GET    /alumno/consultarporid/{id}
POST   /alumno/crear
PUT    /alumno/modificar/{idAlumno}
PUT    /alumno/desactivar/{idAlumno}/{condicion}
GET    /alumno/consultaralumnosporcurso?idcurso=

POST   /curso/crear
GET    /curso/listado
POST   /curso/asignardocente
POST   /curso/cargarcurso?idcurso=
GET    /curso/cursospordocente                 [body]

GET    /docente/listado
POST   /docente/crear
PUT    /docente/modificar/{idDocente}
GET    /docente/consultarporcedula             [body]
GET    /docente/consultarporid/{id}
PUT    /docente/desactivar/{idDocente}/{condicion}

GET    /materia/listado

POST   /notas/crear
GET    /notas/consultar?lapso=                 [body]

GET    /profesiones
GET    /nacionalidades

POST   /representante/crear
POST   /representante/consultarporcedula
```

---

## 9. DTOs y validaciones

### 9.1 `Alumnodto`

Usado en crear/modificar alumno. Incluye datos del alumno, representante (campos con prefijo `representante*`) y curso (`cursoAnnio`, `cursoSeccion`, etc.).

**Validación (`POST /crear`):** casi todos los campos son `@NotEmpty` o `@NotNull`. Excepciones: `fechaCreacion`, `activo`.

**Normalización:** los setters convierten la mayoría de strings a **MAYÚSCULAS**.

### 9.2 `PersonaDocumentodto`

```json
{
  "tipoDocumento": "V",
  "numeroDocumento": "12345678"
}
```

Validación: `@NotEmpty` en ambos campos.

### 9.3 `Docentedto`

Campos: documento, nombres, contacto, formación (`pregrado1/2`, `postgrado1/2`, `curso1-4`), `graduadoPregrado1`, `categoria`, `tiempoDeServicio`, `asignaturasEspecializadas`, `condicion`, `activo`.

Sin anotaciones de validación Bean Validation.

### 9.4 `Representantedto`

Campos: documento, nombres, contacto personal y laboral, profesión, ocupación, ingresos.

Sin validación Bean Validation.

### 9.5 `Cursodto`

`annio`, `seccion`, `periodoAcademico`, `turno`, `nivel`.

### 9.6 `CursoDocentedto`

`cursoId`, `materiaId`, `docenteId`.

### 9.7 `NotaParcialdto` / `NotasParcialesdto`

`NotaParcialdto`: `alumnoId`, `docenteId`, `cursoId`, `materiaId`, `lapso`, `nota`, `porcentaje`.

`NotasParcialesdto`: wrapper con `List<NotaParcialdto> notasParciales`.

### 9.8 DTOs de respuesta

| DTO | Uso |
|-----|-----|
| `ListadoAlumnosdto` | Resumen en listado de alumnos |
| `ConsultaNotasAlumnodto` | Consulta de notas con datos del alumno |
| `NotaConsultadto` | Una nota dentro de la consulta |
| `Variosdto` | Catálogos agrupados (sin endpoint expuesto) |

---

## 10. Lógica de negocio (servicios)

### `IAlumnoService`

| Método | Descripción |
|--------|-------------|
| `consultarAlumnos()` | Alumnos con `activo = true` |
| `consultarAlumnoPorCedula()` | Por tipo + número documento |
| `consultarAlumnoPorId()` | Por ID |
| `guardarAlumno()` | Crea o actualiza; resuelve representante por cédula; resuelve curso por parámetros; `activo = true` si condición es REGULAR |
| `desactivar()` | Marca inactivo; desactiva representante si no tiene más alumnos activos |
| `alumnosPorCurso()` | Lista por `cursoId` |
| `reordenarListas()` | Reordena números de lista en un curso |

### `IDocenteService`

CRUD, consulta por cédula/ID, listado activos, desactivar.

### `IRepresentanteService`

Crear, consultar por cédula, desactivar.

### `ICursoService`

| Método | Descripción |
|--------|-------------|
| `crear()` | Crea curso si no existe duplicado |
| `listarcursos()` | Todos los cursos |
| `asignarcursos()` | Crea registro en `cursos_docentes` |
| `cargarcurso()` | Asigna alumnos al curso y números de lista |
| `consultarCursosPorDocente()` | Por cédula del docente |

### `INotaParcialService`

| Método | Descripción |
|--------|-------------|
| `registrarNotasParciales()` | Inserta solo si no hay duplicado alumno+materia+lapso; calcula porcentaje |
| `consultarNotasParciales()` | Por cédula y lapso opcional |

### `IMateriaService` / `IVariosService`

Listados de materias, nacionalidades y profesiones.

---

## 11. Mappers y utilidades

### Mappers

| Clase | Función |
|-------|---------|
| `CursoDocentedtoToCursoDocenteMapper` | Resuelve entidades por ID |
| `NotaParcialdtoToNotaParcialMapper` | Resuelve alumno, docente, curso, materia por ID |
| `NotaParcialToConsultaNotasAlumnodtoMapper` | Arma respuesta de consulta de notas |

También se usa **ModelMapper** en controladores para Alumno, Docente, Representante y Curso.

### `Utils.calcularPorcentajeNota`

```
porcentaje = (nota × valor_lapso) / 100
```

Ejemplo: nota 18 en lapso 1° (30%) → porcentaje 5.4.

---

## 12. Manejo de errores

No existe `@ControllerAdvice` global. Cada controlador maneja errores de forma independiente.

| Situación | Código HTTP | Formato |
|-----------|-------------|---------|
| Validación fallida (Alumno) | 400 | `{ "mensaje": "..." }` |
| Recurso no encontrado | 404 | `{ "mensaje": "..." }` o vacío |
| Cédula duplicada (Alumno) | 400 | `{ "mensaje": "..." }` |
| Cédula duplicada (Docente/Representante) | 204 | Sin body |
| Curso duplicado | 500 | Sin body |
| Error de BD | 500 | `{ "mensaje", "error" }` |
| Docente no encontrado | 200 | `Optional.empty()` |

**Inconsistencias:** códigos y formatos de error varían según el recurso. Algunos endpoints devuelven 404, otros 200 con body vacío.

---

## 13. Seguridad

| Estado | Detalle |
|--------|---------|
| Spring Security | Dependencia comentada en `pom.xml` |
| JWT | Configurado en properties, no implementado |
| `@PreAuthorize` | Comentado en controladores |
| CORS | Abierto a `*` |
| Tablas auth | `usuarios`, `roles`, `usuario_rol` con seed en BD |

Ramas remotas con trabajo de seguridad: `springsecurity`, `Springsecurity-6`, `springsecurity-actualizacion`.

---

## 14. Docker

### `docker-compose.yml`

| Servicio | Puerto | Descripción |
|----------|--------|-------------|
| `siga-api` | 8090 | API (build desde Dockerfile) |
| `siga_db` | 3306 | MySQL 8, BD `siga` |
| `adminer` | 8080 | Administrador web de BD |

### `.env` (Docker)

```
SIGA_DB_USERNAME=root
SIGA_DB_PASSWORD=password
SIGA_DB_SERVERNAME=siga_db
SIGA_DB_PORT=3306
SIGA_DB_NAME=siga
```

### Comandos

```powershell
docker compose up --build      # Levantar todo
docker compose up siga_db -d   # Solo MySQL
```

---

## 15. Debug

### Cursor / VS Code

1. Instalar **Extension Pack for Java**
2. Breakpoints en controllers o services
3. **Run and Debug** → **Debug SIGA-API** → **F5**

Configuración en `.vscode/launch.json` con variables de BD locales.

### IntelliJ IDEA

Clic derecho en `SigaApplication.java` → **Debug**, con variables de entorno `SIGA_DB_*`.

### Attach remoto (Maven)

```powershell
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
```

Conectar debugger al puerto **5005**.

---

## 16. Tests

| Archivo | Descripción |
|---------|-------------|
| `SigaApplicationTests.java` | Smoke test: carga del contexto Spring |
| `AlumnoTest.java` | Test unitario de getter/setter `tipoDocumento` |

Ejecutar:

```powershell
mvn test
```

No hay tests de integración para controllers ni servicios.

---

## 17. Limitaciones conocidas

1. **GET con body** en varios endpoints (`consultarporcedula`, `cursospordocente`, `notas/consultar`) — incompatible con algunos clientes HTTP y proxies.
2. **Sin autenticación** — la API está completamente abierta.
3. **Errores inconsistentes** — distintos códigos HTTP y formatos según el endpoint.
4. **Validación parcial** — solo `Alumnodto` y `PersonaDocumentodto` tienen Bean Validation.
5. **ModelMapper instanciado en cada request** — no es singleton; posible impacto en rendimiento.
6. **Entidad `Periodo`** — clase Java vacía; tabla existe en BD.
7. **Endpoint `IVariosService.obtenervarios()`** — no expuesto; catálogos agrupados no disponibles vía API.
8. **Migraciones desalineadas** — BD local puede tener versión Flyway superior a la del repo.

---

## Apéndice — Repositorios JPA

| Repositorio | Métodos custom destacados |
|-------------|---------------------------|
| `IAlumnoRepo` | `consultarAlumnos()`, `findAlumnoByTipoDocumentoAndNumeroDocumento`, `findAlumnosByCursoId` |
| `IDocenteRepo` | `consultarDocentes()`, `findDocenteByTipoDocumentoAndNumeroDocumento` |
| `ICursoRepo` | `findCursoByAnnioAndSeccionAndTurnoAndNivelAndPeriodoAcademico` |
| `ICursoDocenteRepo` | `consultarCursosPorDocente` |
| `INotaParcialRepo` | Consultas por alumno, lapso, materia |
| `IMateriaRepo` | `listadoMaterias()` (nombres distintos) |
| `IRepresentanteRepo` | `findRepresentanteByTipoDocumentoAndNumeroDocumento` |
| `ILapsoRepo` | `findLapsoByValor` |

---

*Documentación generada para SIGA-API v1.0 — Tecnodestreza*
