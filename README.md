# Proyecto RMI: Gestion de Inventario de Libros

Este proyecto implementa un sistema basico de gestion de inventario de libros utilizando **RMI (Remote Method Invocation)** en Java. Incluye dos componentes principales: un servidor que maneja el inventario y un cliente que interactua con los servicios ofrecidos por el servidor.

## Descripcion

El servidor ofrece servicios remotos para:
- Listar los libros en el inventario.
- Agregar un nuevo libro al inventario.
- Actualizar la cantidad disponible de un libro.
- Eliminar un libro del inventario.

El cliente consume estos servicios a traves de RMI, proporcionando un menu interactivo para realizar operaciones.

## Como Ejecutar

### Paso 1: Ejecutar el Servidor
1. Abre el proyecto `ServidorRMI` en tu IDE.
2. Ejecuta la clase `Servidor`.
3. El servidor registrara el servicio remoto `InventarioService` en el puerto `1099`.

### Paso 2: Ejecutar el Cliente
1. Abre el proyecto `ClienteRMI` en tu IDE.
2. Ejecuta la clase `Cliente`.
3. Usa el menu interactivo para realizar operaciones sobre el inventario.

## Funciones del Cliente

El cliente utiliza las siguientes lineas clave para conectarse al servidor:

```java
// Busca el registro RMI en el host "localhost" y puerto 1099 (por defecto de RMI).
Registry registro = LocateRegistry.getRegistry("localhost", 1099);

// Busca el objeto remoto "InventarioService" registrado en el servidor y lo obtiene como referencia.
Inventario inventario = (Inventario) registro.lookup("InventarioService");
```

## Notas
- Asegurate de que el servidor este ejecutandose antes de iniciar el cliente.
- La clase `Libro` debe estar disponible en ambos proyectos (servidor y cliente) y debe implementar `Serializable`.

## Ejemplo de Uso

1. **Listar libros:** Muestra todos los libros disponibles en el inventario.
2. **Agregar libro:** Solicita los detalles del libro y lo agrega al inventario.
3. **Actualizar cantidad:** Permite cambiar la cantidad disponible de un libro.
4. **Eliminar libro:** Elimina un libro del inventario utilizando su ID.

## Requisitos
- **Java SE 8** o superior.
- **NetBeans** (opcional, pero recomendado).

---

## Contexto
Este programa ha sido realizado como Primer Trabajo de Curso para la asignatura Programacion de Redes, Sistemas y Servicios (43719) de la Universidad de las Palmas de Gran Canaria en la titulacion Ingenieria en Telecomunicaciones.

---

## Licencia
La aplicacion ha sido totalmente realizada por mi, Roberto Morales Fumero, y dejo a total disposicion el uso de esta para cualquier usuario que la requiera.

---

## Autor
**Roberto Morales Fumero**
[LinkedIn](https://www.linkedin.com/in/roberto-morales-fumero-5186891a8/)
