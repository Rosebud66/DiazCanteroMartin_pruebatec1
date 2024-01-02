# Gestión de empleados, operaciones CRUD

Este proyecto de gestión de empleados proporciona una interfaz interactiva a través de la consola para administrar registros de empleados almacenados en una base de datos.
Incluye todas las operaciones CRUD básicas.

## Estructura del Proyecto

### Clases Principales

#### Clase `Empresa`

- **Función**: Punto de entrada de la aplicación. Clase Main.
- **Responsabilidades**:
  - Mostrar un menú de opciones al usuario.
  - Permitir la creación, edición, eliminación, búsqueda de empleados, y búsqueda en base a valores dados para un campo
  - Interactuar con la clase `Controladora` para realizar operaciones en la base de datos.

#### Clase `Empleado`

- **Función**: Representación de un empleado.
- **Responsabilidades**:
  - Definir la estructura de los datos de un empleado.
  - Proporcionar métodos para acceder y modificar los datos del empleado.
  - Proporcionar métodos para mostrar los datos de un empleado en forma de String

#### Clase `Controladora`

- **Función**: Lógica de negocio y control de operaciones de base de datos.
- **Responsabilidades**:
  - Comunicarse con `ControladoraPersistencia` para ejecutar operaciones CRUD.
  - Gestionar la creación, edición, eliminación y búsqueda de empleados.
  - Proporcionar métodos para acceder a diferentes datos de empleados, como buscar por cargo o listar empleados.

#### Clase `ControladoraPersistencia`

- **Función**: Controlador JPA para realizar operaciones CRUD en la base de datos.
- **Responsabilidades**:
  - Ejecutar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos utilizando JPA.
  - Interactuar con la base de datos para almacenar y recuperar datos de empleados.

## Características Principales

- Crear un nuevo empleado con campos id, nombre, apellido, cargo, salario y fecha de inicio.
- Listar todos los empleados almacenados.
- Editar la información de un empleado existente en base al ID
- Eliminar un registro de empleado en base al ID
- Buscar empleados por cargo.

## Requisitos

- JDK (Java Development Kit)
- MySQL u otros motores compatibles con JPA

## Uso

1. Ejecuta la clase `Empresa` para iniciar la aplicación.
2. Sigue las instrucciones presentadas en la consola para realizar las operaciones deseadas.

## Notas

1. El archivo .sql con la base de datos viene dentro de la estructura del proyecto, dentro de la carpeta sql_database
2. La base de datos incluye 10 registros ficticios para poder hacer pruebas 

## Autores

- Martín Díaz Cantero
  
