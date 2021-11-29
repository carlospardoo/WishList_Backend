# Prueba_Carvajal_Backend

## Base de Datos

1. Instalar PostgreSQL

2. al instalar, crear usuario postgres con contraseña carlos

3. Crear base de datos carvajal

```
create database carvajal;
\c carvajal;
```

## Despliegue

1. Instalar Gradle

2. Abrir consola en carpeta principal

3. con comando cd dirigirse dentro de carpeta ebusiness

4. ejecutar el siguiente comando (Windows):

```
.\gradlew bootRun
```

### Acceso a a Base de Datos con Spring

Tener en cuenta la siguiente ruta de acceso:

```
jdbc:postgresql://localhost:5432/carvajal
```

Acceder en local con localhost y el puerto. Puerto puede variar (5432 en este caso), mirar en postgresql el puerto y cambiar al puerto adecuado. Base de datos **carvajal**

### Endpoints

Endpoints creados para acceder a las diferentes funciones 

1. Enlistar todos los clientes:

```
localhost:8080/client/load-clients
```

2. Enlistar todos los productos:

```
localhost:8080/product/load-products
```

3. Enlistar todos los productos agregados a la lista de deseos para un cliente:

```
localhost:8080/wishlist/load
```

4. Agregar un producto a la lista de deseos para un cliente, con su respectiva cantidad:

```
localhost:8080/wishlist/add
```

5. Actualizar un registro de la lista de deseos para un cliente:

```
localhost:8080/wishlist/update
```

6. Borrar un registro de la lista de deseos para un cliente:

```
localhost:8080/wishlist/delete
```

7. Enlistar todos los productos cuya cantidad supera el stock disponible para un cliente:

```
localhost:8080/wishlist/without-stock
```

#### Comentarios

1. En Bean initApp se definió un cliente y dos productos para agregar por defecto a la base de datos, por lo que se prueba con la data suministrada.

2. Frontend no se implementó, pero se crearon todos los endpoints requeridos para las funcionalidades solicitadas.

3. Servicio se levantará por defecto en el puerto 8080.

4. Se recomienda utilizar postman para testear los endpoints. 
