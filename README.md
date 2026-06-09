# SIGA-API

API REST del Sistema de Información de Gestión Académica (SIGA) para instituciones educativas.

**Stack:** Java, Spring Boot 2.3, JPA, MySQL, Flyway.

**URL base (local):** `http://localhost:8090/siga/api/v1`

📄 **[Documentación completa → docs/DOCUMENTACION.md](docs/DOCUMENTACION.md)** (API, modelo de datos, DTOs, servicios, Docker, debug)

---

## Requisitos

- Java 17+ (probado con Java 21)
- Maven 3.8+
- MySQL 8 con la base de datos `siga`

Opcional para Docker:

- Docker Desktop
- Docker Compose

---

## Arranque rápido (local)

### 1. Base de datos

Necesitas MySQL en ejecución con:

| Variable | Valor por defecto local |
|----------|------------------------|
| Host | `localhost` |
| Puerto | `3306` |
| Base | `siga` |
| Usuario | `root` |
| Contraseña | `password` |

Flyway aplica las migraciones al iniciar la API (`src/main/resources/db/migration/`).

> **Nota:** `application.properties` usa el puerto `3308` por defecto. En entornos locales con MySQL en `3306`, define las variables de entorno o usa el script incluido.

### 2. Script de arranque (Windows)

```powershell
.\scripts\start-local.ps1
```

### 3. Arranque manual

```powershell
cd C:\SIGA-API

$env:SIGA_DB_SERVERNAME = "localhost"
$env:SIGA_DB_PORT = "3306"
$env:SIGA_DB_NAME = "siga"
$env:SIGA_DB_USERNAME = "root"
$env:SIGA_DB_PASSWORD = "password"

mvn spring-boot:run
```

Compilar JAR:

```powershell
mvn -DskipTests package
java -jar target/siga.jar
```

---

## Arranque con Docker

1. Inicia Docker Desktop.
2. Copia o revisa el archivo `.env` en la raíz del proyecto.
3. Ejecuta:

```powershell
docker compose up --build
```

Servicios:

| Servicio | URL / Puerto |
|----------|----------------|
| API | `http://localhost:8090/siga/api/v1` |
| MySQL | `localhost:3306` |
| Adminer | `http://localhost:8080` |

Con Docker, la API usa `SIGA_DB_SERVERNAME=siga_db` (nombre del servicio en la red interna).

---

## Variables de entorno

| Variable | Descripción | Default en `application.properties` |
|----------|-------------|--------------------------------------|
| `PORT` | Puerto HTTP de la API | `8090` |
| `SIGA_DB_SERVERNAME` | Host de MySQL | `localhost` |
| `SIGA_DB_PORT` | Puerto de MySQL | `3308` |
| `SIGA_DB_NAME` | Nombre de la base | `siga` |
| `SIGA_DB_USERNAME` | Usuario MySQL | `root` |
| `SIGA_DB_PASSWORD` | Contraseña MySQL | `password` |

---

## Endpoints de ejemplo

| Método | Ruta |
|--------|------|
| GET | `/profesiones` |
| GET | `/nacionalidades` |
| GET | `/alumno/listado` |
| GET | `/docente/listado` |
| GET | `/curso/listado` |
| GET | `/materia/listado` |
| POST | `/notas/crear` |

Ejemplo:

```powershell
Invoke-RestMethod http://localhost:8090/siga/api/v1/profesiones
```

---

## Estructura del proyecto

```
src/main/java/com/tecnodestreza/siga/
├── controllers/   # REST endpoints
├── services/      # Lógica de negocio
├── repo/          # Repositorios JPA
├── models/        # Entidades y DTOs
└── mappers/       # Conversiones entre entidades y DTOs
```

---

## Tests

```powershell
mvn test
```

---

## Notas

- **Spring Security / JWT:** preparado en configuración pero desactivado en el código actual.
- **Java 21:** requiere Lombok `1.18.34+` (ya configurado en `pom.xml`).
- **Flyway:** si la BD local tiene migraciones más nuevas que las del repo, verás un warning al arrancar; no impide el inicio si el esquema ya está aplicado.
