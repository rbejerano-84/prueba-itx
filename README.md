# Prueba ITX - Backend

Proyecto base Spring Boot (Java 17, Maven) con arquitectura hexagonal.

## Cómo compilar y levantar la aplicación

1. Abre una terminal en la raíz del proyecto.
2. Ejecuta:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. La aplicación arrancará en `http://localhost:8080` y la base de datos H2 se inicializará automáticamente con los datos de ejemplo.

## Ver los tests y cobertura

- Para ejecutar todos los tests:
  ```sh
  mvn test
  ```

## Acceso a Swagger (OpenAPI UI)

- Documentación interactiva de la API:
  - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
  - o [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Ejemplo de petición al endpoint principal

**Endpoint:**
```
POST /api/v1/findByIdRange
Content-Type: application/json
```

**JSON de entrada de ejemplo:**
```json
{
  "productId": 35455,
  "brandId": 1,
  "applicationDate": "2020-06-14-10.00.00"
}
```

**Curl de ejemplo:**
```sh
curl -X POST "http://localhost:8080/api/v1/findByIdRange" \
  -H "Content-Type: application/json" \
  -d '{"productId":35455,"brandId":1,"applicationDate":"2020-06-14-10.00.00"}'
```
