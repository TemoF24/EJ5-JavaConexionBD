# Ejemplo de Conexión a Base de Datos en Java

Este proyecto muestra un ejemplo básico de cómo conectar una aplicación Java a una base de datos MySQL y ejecutar una consulta SELECT.

## Requisitos

- JDK 8 o superior.
- MySQL 5.7 o superior.
- Driver JDBC para MySQL (mysql-connector-java).

## Descripción

El programa establece una conexión a una base de datos MySQL, ejecuta una consulta `SELECT` sobre la tabla `productos` y muestra los resultados. A continuación, te explicamos los pasos que sigue el programa:

1. **Establecer conexión con la base de datos**: Utiliza el método `DriverManager.getConnection` para conectar a la base de datos MySQL.
2. **Crear un objeto Statement**: Se utiliza el objeto `Statement` para ejecutar consultas SQL.
3. **Ejecutar una consulta**: Se ejecuta una consulta `SELECT` para obtener todos los registros de la tabla `productos`.
4. **Recorrer los resultados**: Con el `ResultSet`, se recorren las filas y se muestran las columnas `CODIGOARTICULO`, `NOMBREARTICULO` y `PAISDEORIGEN`.
5. **Cerrar conexiones**: Se cierran las conexiones de manera ordenada con `close()` para evitar posibles fugas de memoria.

## Cómo usar

1. Asegúrate de tener MySQL instalado y en ejecución en tu máquina local.
2. Crea una base de datos llamada `despliegue` y asegúrate de que contiene la tabla `productos` con las columnas mencionadas en el código.
3. Compila y ejecuta el programa desde tu IDE o terminal.
