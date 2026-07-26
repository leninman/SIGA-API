$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot
Set-Location $projectRoot

$dbHost = if ($env:SIGA_DB_SERVERNAME) { $env:SIGA_DB_SERVERNAME } else { "localhost" }
$dbPort = if ($env:SIGA_DB_PORT) { $env:SIGA_DB_PORT } else { "3306" }
$dbName = if ($env:SIGA_DB_NAME) { $env:SIGA_DB_NAME } else { "siga" }
$dbUser = if ($env:SIGA_DB_USERNAME) { $env:SIGA_DB_USERNAME } else { "root" }
$dbPass = if ($env:SIGA_DB_PASSWORD) { $env:SIGA_DB_PASSWORD } else { "" }

Write-Host "SIGA-API - arranque local" -ForegroundColor Cyan
Write-Host "Proyecto: $projectRoot"
Write-Host "MySQL: ${dbHost}:${dbPort}/${dbName}" -ForegroundColor Yellow

$portTest = Test-NetConnection -ComputerName $dbHost -Port $dbPort -WarningAction SilentlyContinue
if (-not $portTest.TcpTestSucceeded) {
    Write-Host "No se puede conectar a MySQL en ${dbHost}:${dbPort}." -ForegroundColor Red
    Write-Host "Verifica que MySQL este activo o ajusta SIGA_DB_SERVERNAME / SIGA_DB_PORT."
    exit 1
}

$env:SIGA_DB_SERVERNAME = $dbHost
$env:SIGA_DB_PORT = $dbPort
$env:SIGA_DB_NAME = $dbName
$env:SIGA_DB_USERNAME = $dbUser
$env:SIGA_DB_PASSWORD = $dbPass

Write-Host "API disponible en: http://localhost:8090/siga/api/v1" -ForegroundColor Green
Write-Host "Detener con Ctrl+C`n"

.\mvnw.cmd spring-boot:run
