# api_tracks
Api de consulta a la BD de spotify

Nombre : Andres González Pascual

Correo : deepdish303@gmail.com

# Objetivos

Desarrollar una aplicación de Backend empleando herramientas y componentes como Spring Framework 5 y Spring Boot 2, siguiendo los lineamientos y buenas prácticas de métodos HTTP y manejo de peticiones para su uso y configuración.


# Descripción de la aplicación

El objetivo es desarrollar un API REST que permita buscar información  de canciones en la APP de Spotify con base en una palabra de búsqueda y posteriormente guardar esos registros en una base de datos Mysql local, el API generada deberá de permitir realizar operaciones CRUD sobre la base de datos generada.

![image](https://user-images.githubusercontent.com/15675318/208328595-29ab8f8b-af0e-48d1-9c5e-df80eecbdaf7.png)

# EndPoints generados

 * /spotify/{search}/{size}[GET]: hace la consulta de canciones con la palabra {search} a la API de spotify  y obtiene una lista de tamaño máximo {size}
 
 * /track[GET]: obtiene la lista de tracks guardados en la BD
 
 * /track[POST]: Guarda la información de los tracks enviados
 
 * /track/{id}[GET]: Obtiene la información del id {id}
 
 * /track/{id}[PUT]: Actualiza la información del campo descripción en el registro con id {id}en la base de datos 
 
 * /track/{id}{DELETE}: Borra el registro con el id {id} en la base de datos

![image](https://user-images.githubusercontent.com/15675318/208329013-a8817c5e-d8d4-4aea-83fe-d1658911d442.png)



