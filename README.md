# api_tracks
Api de consulta a la BD de spotify

Nombre : Andres González Pascual

Correo : deepdish303@gmail.com

Video de funcionamiento del API : https://drive.google.com/file/d/10XIG4H0Sjcp3L3HS9RUtaFe7TlzZWIJc/view?usp=sharing


# Objetivos

Desarrollar una aplicación de Backend empleando herramientas y componentes como Spring Framework 5 y Spring Boot 2, siguiendo los lineamientos y buenas prácticas de métodos HTTP y manejo de peticiones para su uso y configuración.


# Descripción de la aplicación

El objetivo es desarrollar un API REST que permita buscar información  de canciones en la APP de Spotify con base en una palabra de búsqueda y posteriormente guardar esos registros en una base de datos Mysql local, el API generada deberá de permitir realizar operaciones CRUD sobre la base de datos generada.

![image](https://user-images.githubusercontent.com/15675318/208328595-29ab8f8b-af0e-48d1-9c5e-df80eecbdaf7.png)

# EndPoints generados :

 * /spotify/{search}/{size}[GET]: hace la consulta de canciones con la palabra {search} a la API de spotify  y obtiene una lista de tamaño máximo {size}
 
 * /track[GET]: obtiene la lista de tracks guardados en la BD
 
 * /track[POST]: Guarda la información de los tracks enviados
 
 * /track/{id}[GET]: Obtiene la información del id {id}
 
 * /track/{id}[PUT]: Actualiza la información del campo descripción en el registro con id {id}en la base de datos 
 
 * /track/{id}{DELETE}: Borra el registro con el id {id} en la base de datos

# Entity usado para guardar la informacion en Base de datos

![image](https://user-images.githubusercontent.com/15675318/208333238-99591c49-dbe4-4397-85de-300c2ed1acc4.png)



