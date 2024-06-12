# SpringUniversityRod
## Descripción
SpringUnversityRod es un sistema de gestión estudiantil desarrollado con Spring Boot, que permite la administración de especialidades, cursos y registros de alumnos.

## Requisitos Previos
Java 17
Maven
MySQL
SpringSecurity
Thymeleaf
JPA

## Configuración
Clonar el repositorio y abrir el proyecto como un proyecto Maven en tu IDE.
Crear la base de datos en MySQL utilizando el script de inicialización ubicado en src/main/resources/static. llamado UniversityDB.sql (Al final se encuentran las querys de la Fase 1)
Ajustar las credenciales de la base de datos y otros parámetros necesarios en el archivo application.properties.
Copia de seguridad de la base de datos: Se incluye una copia de seguridad de la base de datos en la carpeta src/main/resources/static para su referencia o uso en caso de ser necesario.
API REST
El sistema expone varias APIs REST para interactuar con los datos:

GET /api/especialidades: Devuelve un listado de todas las especialidades, ordenadas alfabéticamente.
GET /api/cursos: Devuelve un listado de todos los cursos, incluyendo detalles como el profesor asignado, también ordenados alfabéticamente.
GET /api/alumnos: Devuelve información de los alumnos filtrada por especialidad y curso seleccionados, incluyendo datos como nombre, apellido, email y promedio de notas.

## Errores Comunes
Cambio de Puerto
Problema: Conflicto de puertos en la máquina local.
Si es necesario utilizar un puerto diferente para evitar conflictos con otros servicios, puedes cambiar el puerto en el archivo application.properties modificando la siguiente propiedad:

## Properties
server.port=9091
Use code with caution.
content_copy
Documentación y Pruebas de la Fase 2
Para la Fase 2, se incluye una JavaApplication que puede ser utilizada para realizar pruebas funcionales de los requerimientos especificados. Esta aplicación se encarga de simular operaciones del sistema y verificar la correcta interacción con la base de datos.

## Uso
Para acceder al sistema, visita http://localhost:9091/ en tu navegador web y utiliza las credenciales predeterminadas:

Usuario: user
Contraseña: 1234

![Captura de pantalla 2024-06-11 000059](https://github.com/RodStack/SpringUniverstiyRod/assets/57158158/5b1fe013-8b05-44c2-a2f0-988d7e376cfe)

