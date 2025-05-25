# 🛠️ Cómo compilar y ejecutar el proyecto con Maven

A continuación se describe paso a paso cómo compilar y ejecutar tu proyecto utilizando Maven.

---

## 📌 Prerrequisitos

* Para este proyecto se está utilizando openjdk version "21.0.7" 2025-04-15, por lo tanto es requisito tener:
* Java 21
* Maven instalado y agregado a la variable de entorno.

Verifica las instalaciones con:

```bash
java -version
mvn -version
```

---

## 🚀 Ejecución directa con Maven

Para ejecutar el proyecto directamente desde Maven, utiliza:

```bash
mvn exec:java
```

Asegúrate de que el plugin `exec-maven-plugin` esté configurado correctamente en tu archivo `pom.xml`, con tu clase principal definida en la propiedad `mainClass`.

---

## 📦 Crear archivo JAR ejecutable

Para empaquetar tu proyecto en un archivo `.jar` ejecutable:

```bash
mvn clean package
```

El archivo ejecutable será generado en:

```
target/robot-core-1.0-SNAPSHOT.jar
```

---

## ▶️ Ejecutar archivo JAR

Para ejecutar el archivo `.jar` generado, utiliza el siguiente comando:

```bash
java -jar target/robot-core-1.0-SNAPSHOT.jar
```

---

## 🧹 Limpieza del proyecto

Para eliminar todos los archivos compilados y empaquetados:

```bash
mvn clean
```

---
