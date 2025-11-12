# Price Service API

Spring Boot REST API para consultar precios de productos aplicables por fecha, marca y producto.

## Tecnologías
- Java 21
- Spring Boot 3.5.6
- H2 Database (in-memory)
- OpenAPI 3.0

## Arrancar la aplicación

Es necesario posicionarse dentro de la carpeta app-boot antes de ejecutar el comando:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

O con IDE usando profile: `local`

## Endpoint

```
GET api/v1/prices?applicationDate={date}&productId={id}&brandId={id}
```

**Parámetros:**
- `applicationDate`: Fecha ISO 8601 con zona horaria (ej: 2020-06-14T10:00:00%2B02:00)
- `productId`: ID del producto (ej: 35455)
- `brandId`: ID de la marca (ej: 1)

**Respuesta:**
- `200 OK`: Precio encontrado
- `404 NOT FOUND`: Sin precio para los parámetros dados

## Tests

Ejecutar tests de integración:
```bash
mvn test
```

Incluye 5 casos de prueba específicos según los requerimientos.