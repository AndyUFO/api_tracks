# API Tracks

Api de consulta a la BD de spotify

Nombre : Andres González Pascual

Correo : deepdish303@gmail.com

Video de funcionamiento del API : 

[![Opcion 1 Youtube](https://img.youtube.com/vi/8-i0zaTGVjw/0.jpg)](https://www.youtube.com/watch?v=8-i0zaTGVjw)

[Opcion 2 Google Drive](https://drive.google.com/file/d/10XIG4H0Sjcp3L3HS9RUtaFe7TlzZWIJc/view?usp=sharing)


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

# Estructura de la tabla de datos Mysql utilizada para guardar la informacion en Base de datos

![image](https://user-images.githubusercontent.com/15675318/208333238-99591c49-dbe4-4397-85de-300c2ed1acc4.png)

# Dependencias utilizadas

https://github.com/AndyUFO/api_tracks/blob/88c1d7a9c1764400a3b91e33a9b541fb27dde635/pom.xml

* mysql-connector-j
* jackson-databind
* lombok
* Spring web

# Configuracion del archivo .properties

https://github.com/AndyUFO/api_tracks/blob/78a16e1fad1b011a51dcc9e291bb41e8bd80b790/src/main/resources/application.properties

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/spotify
spring.datasource.username=root
spring.datasource.password=slacK201
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

logging.level.root=INFO
logging.pattern.console=[%blue(%d{dd/MM/YYYY hh:mm:ss})] [%yellow(%logger)] [%highlight(%-5level)] - %msg%n
```









