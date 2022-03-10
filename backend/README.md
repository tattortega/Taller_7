# Agenda telefonica - API
Proyecto desarrollado en IntelliJ IDEA Ultimate, utilizando:
* JAVA - Spring boot
* MySQL
## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
```
git clone https://github.com/tattortega/Taller_7.git
```
2. Ejecute el método principal directamente en el IDE para iniciar la aplicación Spring Boot.
```
Run 'BackendApplication'
```

## Rutas
```
@index
localhost:8080/

@GET
/contacts
/contact/{id}

@POST
/contact

@DELETE
/contact/{id}

@PUT
/contact/{id}

@PATCH
/contact/name/{id}
/contact/lastname/{id}
/contact/phone/{id}
/contact/email/{id}
/contact/datebirth/{id}
```