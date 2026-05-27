#Gestor de Tareas JAVA

# Gestor de Tareas - Java + MySQL

Aplicación de escritorio para gestionar tareas personales.

## Requisitos

- Java 11+
- MySQL 8.0
- MySQL Connector Java 8.0

## Instalación

1. Clonar repo
```bash
git clone https://github.com/edgarfariza/gestor-tareas.git
cd gestor-tareas
```

2. Crear BD
```sql
CREATE DATABASE gestor_tareas;
```

3. Ejecutar aplicación
```bash
javac -d bin src/com/edgar/tareas/**/*.java
java -cp bin:lib/mysql-connector-java-8.0.jar com.edgar.tareas.Main
```

## Características

CRUD completo (crear, leer, actualizar, eliminar)
Almacenamiento en MySQL
Interfaz CLI intuitivA
Arquitectura en capas (Modelo, DAO, Vista)
Conexión segura con PreparedStatements

