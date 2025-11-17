# Tickets API – Backend CRUD en Spring Boot  
Proyecto desarrollado por **Elias Delgado** para la asignatura Fullstack II – Duoc UC - Docente Carlos Martinez

---

## 📌 Descripción general  
Este proyecto corresponde a un backend construido en **Java 17 + Spring Boot 3**, cuyo objetivo es gestionar incidencias TI mediante un CRUD completo.  
Permite registrar, listar, consultar, actualizar y eliminar tickets asociados a problemas técnicos dentro de una institución educativa.

El desarrollo sigue la estructura recomendada en clases (controlador, servicio, repositorio, modelo y DTO), utilizando JPA para persistencia y una base de datos H2 en memoria para facilitar las pruebas.

---

## 🛠️ Tecnologías utilizadas  
- **Java 17**  
- **Spring Boot 3.3.x**  
- **Spring Web**  
- **Spring Data JPA**  
- **H2 Database (en memoria)**  
- **Lombok**  
- **Gradle**  
- **Postman** (para pruebas de API)

---

## 🧩 Estructura del proyecto  

src/main/java/cl/duoc/elias/delgado/ticketsapi
│
├── ticket
│ ├── model → Entidad Ticket + enums TicketStatus y TicketPriority
│ ├── dto → Objetos de transporte de datos
│ ├── repository → Repositorios JPA
│ ├── service → Interfaces y lógica de negocio
│ └── controller → Endpoints REST
│
└── config → Configuraciones adicionales del proyecto

yaml
Copy code

Esta estructura facilita la mantención, el orden y la escalabilidad del backend.

---

## 🚀 Cómo ejecutar el proyecto

### **Opción 1: Descargar ZIP**
1. Clic en el botón verde **Code** en GitHub  
2. Seleccionar **Download ZIP**  
3. Extraer la carpeta  
4. Abrir el proyecto en IntelliJ IDEA  
5. Ejecutar la clase:

TicketsApiApplication

bash
Copy code

### **Opción 2: Clonar el repositorio**
```bash
git clone https://github.com/ChicoElias/tickets-api-elias.git
cd tickets-api-elias
Ejecutar con Gradle
bash
Copy code
./gradlew bootRun      # macOS / Linux
gradlew.bat bootRun    # Windows
🌐 Endpoints principales
Método	Endpoint	Descripción
POST	/api/tickets	Crear un ticket
GET	/api/tickets	Listar todos los tickets
GET	/api/tickets/{id}	Obtener ticket por ID
PUT	/api/tickets/{id}	Actualizar un ticket
DELETE	/api/tickets/{id}	Eliminar ticket

Ejemplo de body para creación:

json
Copy code
{
  "descripcion": "No hay internet en laboratorio 3",
  "prioridad": "HIGH",
  "estado": "OPEN"
}
🗄️ Consola H2 (Base de datos en memoria)
Este proyecto utiliza H2 para facilitar pruebas rápidas.

Acceso a la consola:

bash
Copy code
http://localhost:8081/h2-console
Credenciales:

less
Copy code
JDBC URL: jdbc:h2:mem:ticketsdb
Usuario: sa
Contraseña: (vacía)
Desde esta consola puedes visualizar la tabla TICKETS, sus columnas y los datos generados por el CRUD.

📸 Evidencias incluidas
El proyecto demuestra su funcionamiento a través de:

Ejecución del servidor en IntelliJ

Creación de tickets (POST)

Listado general (GET)

Consulta por ID (GET)

Actualización de un ticket (PUT)

Eliminación (DELETE)

Visualización de la tabla TICKETS en H2

Estas pruebas fueron realizadas mediante Postman y respaldadas con imágenes para la entrega académica.

🧭 Plus: Ideas para extender el proyecto
Aunque cumple totalmente con lo solicitado en la guía, es un proyecto con potencial de crecimiento:

Agregar autenticación (Spring Security o JWT)

Implementar borrado lógico y registro de auditoría

Incorporar paginación, filtros y ordenamientos

Migrar a una base de datos persistente (MySQL, PostgreSQL)

Crear un frontend que consuma esta API (React, Angular, etc.)

Integrar Swagger para documentación automática de la API

👤 Autor
Elias Delgado
Estudiante de Ingeniería en Informática – Duoc UC
Fullstack II – Backend Spring Boot
