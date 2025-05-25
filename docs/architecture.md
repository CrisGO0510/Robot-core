# 📦 Estructura del proyecto Robot Virtual

Esta documentación explica cada uno de los componentes del proyecto, por qué existen y qué elementos deben contener internamente.

## 🌳 Estructura del proyecto

```
src/main/java/edu/utp/robot
├── application
├── configuration
├── domain
│   ├── communication
│   ├── control
│   ├── module
│   │   ├── dynamic
│   │   └── static
│   │       ├── actuation
│   │       └── perception
│   └── user
├── infrastructure
│   ├── actuators
│   ├── environment
│   ├── sensors
│   └── ui
└── launcher
```

---

## 📚 Explicación por módulos

### 🧠 Domain

**Responsabilidad**: Contiene la lógica y reglas fundamentales del negocio. Independiente de tecnologías externas.

* **Robot.java**: Entidad principal, el cual representa el robot y su lógica principal de movimiento y comportamiento.

#### communication

* **CommunicationGateway.java**: Representa el Sistema de Control. Es responsable de orquestar y redirigir los comandos que el robot debe ejecutar.
* **Message.java**: Interfaz para mensajes enviados o recibidos.

#### control

* **ControlSystem.java**: Gestiona los comandos que recibe el robot y coordina las acciones.

#### module

* **Module.java**: Clase base para los módulos físicos del robot.

##### dynamic

* **DynamicModule.java**: Módulos con movimiento (rotación, extensión, helicoidal).
* **Extension.java**: Movimiento tipo extensión.
* **Helical.java**: Movimiento helicoidal.
* **Rotation.java**: Movimiento rotacional.

##### static

* **StaticModule.java**: Módulos sin movimiento (sensores y actuadores).

###### actuation

* **Actuation.java**: Clase que define la actuación de un modulo estático, definiendo número de actuadores y la realzación de la acción
* **Actuator.java**: Clase que centraliza metadatos comunes a todos los actuadores (ID, tipo, descripción) e incluye un método general para realizar acción.
* **Speaker.java**: Actuador para emitir sonidos.

###### perception

* **Perception.java**: Clase para comportamientos sensoriales, como procesar datos y capturar información.
* **Camera.java**: Sensor para identificar objetos y obstáculos.
* **ProximitySensor.java**: Sensor para detectar obstáculos cercanos.
* **Sensor.java**: Clase que centraliza metadatos comunes a todos los sensores (ID, tipo, descripción) e incluye un método general para capturar información, independientemente del tipo de sensor (cámara o proximidad).

#### user

* **User.java**: Entidad que representa al usuario que interactúa con el robot.

---

### 🎯 Application

**Responsabilidad**: Orquesta y ejecuta casos de uso específicos utilizando elementos del dominio.

* **RobotServices.java**: Expone funcionalidades específicas del robot.
* **CommandHandler.java**: Gestiona comandos del usuario hacia el robot.

---

### 🛠 Infrastructure

**Responsabilidad**: Implementa las interfaces definidas en el dominio, simulando las interacciones físicas del robot dentro de un entorno virtual. Permite que sensores y actuadores funcionen sin hardware real, apoyándose en estructuras internas como mapas virtuales y mecanismos visuales o textuales de salida.
#### actuators

* **VirtualMovementEngine.java**: Controla la lógica de desplazamiento del robot dentro del entorno simulado. Interactúa con el VirtualWorldMap para actualizar coordenadas, detectar colisiones y permitir movimientos como rotación, extensión, retroceso o helicoidal.
* **VirtualSpeaker.java**: Representa un sistema de audio simulado. Emite sonidos en forma de texto (en consola o UI) para representar alertas, advertencias u otras acciones comunicativas.

#### environment

* **VirtualWorldMap.java**: Es el "mundo" donde opera el robot. Define una cuadrícula o espacio 2D que puede contener celdas ocupadas por obstáculos, mascotas o estar libres. Proporciona métodos para consultar qué hay en cada dirección relativa al robot y permite modificar el estado del entorno.

#### sensors

* **VirtualCamera.java**: Simula la visión del robot. Dado un entorno y una posición, permite identificar el contenido de una celda en frente, izquierda o derecha, diferenciando entre tipos de objetos (mascota, pared, libre, etc.).
* **VirtualProximitySensor.java**: Simula un sensor de cercanía. Informa si hay un objeto directamente frente al robot a una celda de distancia, sin identificar su tipo (solo presencia o ausencia).

#### ui (para desarrollo futuro)

* Elementos gráficos con Swing para visualizar el robot y su entorno.

---

### ⚙️ Configuration

**Responsabilidad**: Instancia y ensambla los componentes principales del sistema (robot, sensores, actuadores y entorno virtual).

* **RobotConfiguration.java**: Construye y configura todas las dependencias necesarias para ejecutar el robot.
* **AppBootstrapper.java**: Coordina la ejecución inicial del robot, utilizando la configuración provista por `RobotConfiguration`.

---

### 🚀 Launcher

**Responsabilidad**: Define puntos de entrada al sistema.

* **Main.java**: Punto principal de ejecución, conecta con `AppBootstrapper`.
* **MainGUI.java**: Punto de entrada futuro para iniciar con una interfaz gráfica.

---
