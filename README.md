# Gestor de Tareas - Java + MySQL

Un gestor de tareas sencillo en consola programado en **Java** conectado a una base de datos **MySQL**. El proyecto sigue la estructura **MVC** (Modelo-Vista-Controlador) y utiliza el patrón **DAO** para separar la lógica de la base de datos de la interfaz de usuario.

## Requisitos

- Java 11+
- MySQL 8.0

## Tecnologias utilizadas

-Intellij Idea
- JDBC MySQL Connector
- Java 21
- MySQL 8.0



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
---

## Características

* **CRUD Completo:** Crear, ver (todas o por ID), actualizar y eliminar tareas.
* **Seguridad:** Uso de `PreparedStatement` para evitar inyección SQL.
* **Gestión de memoria:** Uso de `try-with-resources` para cerrar las conexiones automáticamente.
* **Fechas:** Uso de la API moderna `java.time.LocalDate`.

---

## Estructura del Proyecto

```text
gestor-tareas/
├── database/        # Archivo script.sql para crear la base de datos
├── lib/             # Contiene el mysql-connector-j-9.7.0.jar
└── src/
    └── com.edgar.tareas/
        ├── Main.java      # Arranca la aplicación
        ├── dao/           # Conexión (ConexionBD) y consultas (TareaDAO)
        ├── modelo/        # Clase Tarea (Objeto del sistema)
        └── vista/         # Pantalla y teclado (MenuConsola)
