# API Tracks

Api de consulta a la BD de spotify

Nombre : Andres González Pascual

Correo : deepdish303@gmail.com

# Demostracion de la aplicación


[![Opcion 1 Youtube](https://img.youtube.com/vi/8-i0zaTGVjw/0.jpg)](https://www.youtube.com/watch?v=8-i0zaTGVjw)

[Opcion 2 Google Drive](https://drive.google.com/file/d/10XIG4H0Sjcp3L3HS9RUtaFe7TlzZWIJc/view?usp=sharing)


# Objetivos

Continuar con el desarrollo de una aplicación de Backend empleando:
- herramientas y componentes como Spring Framework 5 y Spring Boot 2 siguiendo los lineamientos y buenas prácticas de métodos HTTP y manejo de peticiones para su uso y configuración.
- Así como un conjunto de pruebas para verificar el correcto funcionamiento de la API.

# Descripción de la aplicación

El objetivo es desarrollar un API REST que permita buscar información  de tracks de canciones en la APP de Spotify, esto con base en una palabra de búsqueda para posteriormente guardar estos registros en una base de datos Mysql, el API deberá de permitir realizar operaciones CRUD sobre la base de datos generada asi como manejar un esquema de autenticacion y permisos para el uso de los distintos endpoints de la API,
adicionalmente se debe contar con un conjunto de pruebas unitarias para verificar el correcto funcionamiento de los distintos controladores REST de la applicación , por ultimo esta aplicacion debera ser publicada para probar su funcionalidad en un entorno de pruebas.  

# Funcionalidad de la aplicación

![image](https://user-images.githubusercontent.com/15675318/215378512-fe83998e-9ea1-49c4-91b1-9cdde60d15c2.png)


# Alcance de la aplicación
## Esquema de autenticación/autorización y Endpoints generados
 |ROL| ENDPOINT                               | METODO   | FUNCIONALIDAD                                                                                                               |
|--|----------------------------------------|----------|-----------------------------------------------------------------------------------------------------------------------------|
 |ADMIN| /spotify/{palabra_busqueda}/{cantidad} | [GET]    | hace petición a la API de spotify buscando tracks que contengan la {palabra_de_busqueda} con un límite de {cantidad} tracks |
 |ADMIN| /track                                 | [POST]   | Guarda en la base de datos la información del track enviada                                                                 |
 |ADMIN| /track/{ID}                            | [DELETE] | Elimina el registro con id={ID} de la base de datos                                                                         |
 |USER| /track                                 | [GET]    | Lista todos los tracks guardados en bd                                                                                      |
 |USER| /track/{ID}                            | [PUT]    | Actualiza la descripción del track con id={ID}                                                                              |
 |USER| /track/{id}                            | [GET]    | Obtiene la información del track con id={ID}                                                                                |
 |USER| /track/{id}                            | [GET]    | Obtiene la información del track con id={ID}                                                                                |
 |ANONYMOUS| /track/public                          | [GET]    | EndPoint publico, no requiere autenticacion                                                            |

## :hammer:Testing

-`Junit`: Se desarrollo un set de pruebas en JUnit5

-`Mockito`: Se utilizaron Mocks de pruebas simulando servicios que posteriormente fueron injectados a los controladores 
para simular el uso de los servicios REST

```java
@ExtendWith(MockitoExtension.class)
class TrackControllerTest {
 @Mock
 private ITrackService service;//doble de pruebas de un servicio
 @InjectMocks
 TrackController trackController;//injeccion al controlador

 @SneakyThrows
 @Test
 @DisplayName("Prueba de guardado de registros")
 void saveTrack() {
  MockHttpServletRequest request = new MockHttpServletRequest();
  RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

  Track track = new Track();
  track.setId(1);
  when(service.save((any(Track.class)))).thenReturn(track);//definiendo comportamiento del servicio 

  Track track1 = new Track();
  track1.setId(1);
  ResponseEntity<Track> responseEntity = trackController.saveTrack(track);//ejecutando el controlador

  assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());//test
  assertEquals(HttpStatus.OK, responseEntity.getStatusCode());//test
 }
}
```

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









