# Webapp JSF 3 - Gestión de Productos

Este proyecto es una aplicación web desarrollada en Java que demuestra el uso de tecnologías de Jakarta EE 11 para crear un sistema de gestión de productos (CRUD).

## Descripción

La aplicación permite a los usuarios listar, crear, editar y eliminar productos. Cada producto tiene un nombre, una categoría, un precio y un SKU. La interfaz de usuario está construida con Jakarta Server Faces (JSF) y utiliza Bootstrap 5 para el diseño.

La aplicación también cuenta con soporte para internacionalización (i18n), con textos disponibles en español e inglés.

## Tecnologías Utilizadas

*   **Java:** 21
*   **Maven:** para la gestión de dependencias y construcción del proyecto.
*   **Jakarta EE 11:**
    *   **Jakarta Server Faces (JSF) 4.0:** para la capa de vista y componentes de UI.
    *   **Jakarta Persistence (JPA) 3.1:** para el mapeo objeto-relacional y la persistencia de datos.
    *   **Jakarta Contexts and Dependency Injection (CDI) 4.0:** para la inyección de dependencias.
    *   **Jakarta Servlet 6.0:** como base de la aplicación web.
*   **Hibernate:** como implementación de JPA (proveedor de persistencia).
*   **WildFly:** como servidor de aplicaciones de destino.
*   **H2 Database:** (Implícito por la configuración de `persistence.xml`) Base de datos en memoria para desarrollo.
*   **Bootstrap 5:** para el diseño responsive de la interfaz de usuario.

## Cómo Ejecutar la Aplicación

### Prerrequisitos

1.  **JDK 21** o superior instalado.
2.  **Maven** instalado.
3.  **WildFly Application Server:** Descargar e instalar una versión compatible con Jakarta EE 11.

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL-DEL-REPOSITORIO>
    cd webapp-jsf3
    ```

2.  **Configurar el servidor WildFly:**
    *   Inicia WildFly.
    *   Accede a la consola de administración (por defecto `http://localhost:9990`).
    *   Configura el datasource de la base de datos H2 si no está ya configurado por defecto. El JNDI name esperado en `persistence.xml` es `java:/jdbc/mysqlDS`. Deberás crear este datasource para que apunte a tu base de datos.

3.  **Construir el proyecto:**
    Compila y empaqueta la aplicación en un archivo `.war` usando Maven.
    ```bash
    mvn clean package
    ```

4.  **Desplegar la aplicación:**
    Puedes desplegar el archivo `webapp-jsf3.war` (generado en el directorio `target/`) de dos maneras:
    *   **Manualmente:** Copia el archivo `.war` al directorio `standalone/deployments/` de tu instalación de WildFly.
    *   **Usando el plugin de Maven:**
        ```bash
        mvn wildfly:deploy
        ```

5.  **Acceder a la aplicación:**
    Una vez desplegada, puedes acceder a la aplicación en la siguiente URL:
    [http://localhost:8080/webapp-jsf3/](http://localhost:8080/webapp-jsf3/)

## Estructura del Proyecto

```
.
├── pom.xml                 # Archivo de configuración de Maven
└── src
    └── main
        ├── java                # Código fuente de Java
        │   └── org/aguzman/webapp/jsf3
        │       ├── controller    # Controladores de JSF (Managed Beans)
        │       ├── converters    # Conversores de JSF
        │       ├── entities      # Entidades de JPA (Modelo de datos)
        │       ├── repositories  # Clases para el acceso a datos
        │       ├── services      # Lógica de negocio
        │       └── ...
        ├── resources           # Recursos (configuración, archivos de propiedades)
        │   ├── META-INF
        │   │   └── persistence.xml  # Configuración de JPA
        │   └── messages_es.properties # Textos para i18n
        └── webapp              # Raíz de la aplicación web
            ├── resources       # Recursos web (CSS, JS, imágenes)
            ├── WEB-INF
            │   └── layouts     # Plantillas de Facelets
            ├── index.xhtml     # Página principal
            └── form.xhtml      # Formulario para crear/editar productos
```
