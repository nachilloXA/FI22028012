# Proyecto Final - Estructura de Datos - The Sandwich Guy 

## Integrantes del grupo

| Nombre completo               | Carné      | Usuario de GitHub                                  | Correo                    |
|-------------------------------|------------|----------------------------------------------------|---------------------------|
| Jesus Ignacio Alvarez Briceño | FI22028012 | [@nachilloXA](https://github.com/nachilloXA)       | jalvarez10326@ufide.ac.cr |
| Emanuel Lopez Escobar         | FI24044110 | [@ele22](https://github.com/ele22)                 | elopez10708@ufide.ac.cr   |
| Anthony Gomez Garcia          | FI24039489 | [@Paycr21](https://github.com/Paycr21)             | agomez40375@ufide.ac.cr   |
| Sebastian Vargas Oviedo       | FH20008393 | [@svargasvo2704](https://github.com/svargasvo2704) | svargas10514@ufide.ac.cr  |

---

## Descripción del proyecto

Este documento corresponde al **Segundo Avance del Proyecto Final del curso de Estructura de Datos**.  
El propósito del proyecto es desarrollar un sistema interactivo y gráfico para la gestión de una **baraja de cartas**, aplicando conceptos de Programación Orientada a Objetos (POO) y estructuras de datos en **Java**.

---

### Novedades del Avance 3

-  La **lógica principal del juego**
-  La gestión del **mazo, la mano del jugador y el pozo de descarte**
-  La correcta comunicación entre **modelo, vista y controlador**
-  El uso correcto de **estructuras de datos dinámicas**

---

## Estructura del proyecto

```
The Sandwich Guy/
├── controller/
│   ├── GameController.java
├── model/
│   ├── Caja.java
│   ├── Carta.java
│   ├── Mano.java
│   ├── Mazo.java
│   ├── Pozo.java
├── view/
│   ├── MainView.java
├── .gitignore
├── Main.java
├── README.md
```

---

## Estructuras de Datos Utilizadas

| Clase | Estructura | Implementación | Uso dentro del Proyecto |
|-------|-------------|------------------|--------------------------|
| `Caja` | `LinkedList<Carta>` | `private final LinkedList<Carta> cartas` | Almacena la baraja completa inicial antes de ser cargada al mazo. Se usa `LinkedList` por su eficiencia en inserciones secuenciales. |
| `Carta` | Objeto base | Atributos primitivos (`String`, `int`) | Representa una carta individual con palo, valor, color y número. Es la base de todas las estructuras. |
| `Mano` | `List<Carta>` con `LinkedList` | `private final List<Carta> cartas = new LinkedList<>()` | Almacena dinámicamente las cartas del jugador. Permite agregar, eliminar y ordenar cartas. |
| `Mazo` | `Stack<Carta>` | `private Stack<Carta> pila` | Controla el mazo bajo el principio **LIFO**, permitiendo sacar cartas de la parte superior. |
| `Pozo` | `Queue<Carta>` con `LinkedList` | `private final Queue<Carta> cartas = new LinkedList<>()` | Gestiona las cartas descartadas bajo el principio **FIFO**. |
| `GameController` | Lógica de Control | Coordinación entre clases | Administra el flujo del juego, comunica modelo y vista, controla robos, descartes y ordenamientos. |

---
### Justificación del Uso de Estructuras

-  `LinkedList` se utiliza cuando se requieren inserciones dinámicas rápidas.
-  `Stack` se usa correctamente en el **mazo**, ya que representa una pila real de cartas.
-  `Queue` se implementa en el **pozo**, manteniendo el orden de descarte.
-  `List` permite ordenar y modificar la **mano del jugador** con facilidad.

---
##  Herramientas Utilizadas

- Lenguaje: **Java**
- Versión: **Java JDK 21**
- IDE: **Visual Studio Code**
- Control de versiones: **Git & GitHub**

---

## Uso de Inteligencia Artificial

Durante el desarrollo del proyecto **sí se utilizó inteligencia artificial como herramienta de apoyo**, principalmente para:

- Apoyo en el diseño de clases
- Comprensión de estructuras de datos
- Organización del patrón MVC
- Solución de errores de compilación

### Prompt 1 – Diseño del Mazo con Stack
**Entrada:**  
¿Cómo puedo implementar un mazo de cartas en Java usando la estructura Stack?

**Salida:**  
Se recomendó utilizar la clase `Stack` para representar el mazo de cartas y el método `pop()` para retirar cartas de la parte superior, aplicando el principio LIFO.

---

### Prompt 2 – Manejo de la Mano del Jugador
**Entrada:**  
¿Qué estructura de datos es mejor para manejar la mano de un jugador en un juego de cartas en Java?

**Salida:**  
Se sugirió utilizar la interfaz `List` con la implementación `LinkedList` para permitir inserciones, eliminaciones y ordenamiento dinámico de las cartas.

---

### Prompt 3 – Implementación del Pozo de Descarte
**Entrada:**  
¿Cómo implementar un pozo de cartas descartadas utilizando una cola (Queue) en Java?

**Salida:**  
Se explicó cómo utilizar la interfaz `Queue` con `LinkedList` para manejar las cartas descartadas bajo el principio FIFO.

---

### Prompt 4 – Barajado del Mazo
**Entrada:**  
¿Cómo mezclar aleatoriamente una colección de objetos en Java?

**Salida:**  
Se recomendó utilizar el método `Collections.shuffle()` para mezclar las cartas del mazo de forma aleatoria.

---

### Prompt 5 – Manejo de Errores de Compilación y Ejecución
**Entrada:**  
¿Cómo puedo manejar errores de compilación y excepciones en Java al trabajar con estructuras de datos como `Stack`, `List` o `Queue`?

**Salida:**  
Se recomendó utilizar **bloques `try-catch`** para capturar excepciones durante la ejecución, mostrando mensajes claros al usuario y evitando que el programa falle.  
Por ejemplo, validar si el mazo está vacío antes de extraer cartas o si la mano está llena antes de agregar una nueva carta.

---

### Prompt 6 – Métodos de la Clase
**Entrada:**  
¿Cómo crear métodos en Java que manipulen colecciones internas de una clase?

**Salida:**  
Se recomendó definir métodos específicos para agregar, eliminar y obtener elementos de las colecciones internas (`List`, `Stack`, `Queue`) de la clase, manteniendo la lógica centralizada y segura, evitando manipulación directa desde fuera de la clase.

---

### Prompt 7 – Organización de Clases Relacionadas
**Entrada:**  
¿Cómo organizar varias clases que dependen entre sí en un proyecto Java?

**Salida:**  
Se explicó la importancia de definir relaciones claras entre clases (por ejemplo, `Mano` depende de `Carta`, `Mazo` depende de `Carta`, `GameController` coordina todas) y de utilizar paquetes (`model`, `view`, `controller`) para agrupar clases relacionadas y mantener una arquitectura limpia y modular.

---

### Instalación

1. Asegúrate de tener instalado **Java JDK 21** o superior.
2. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/nachilloXA/FI22028012.git
```

3. Accede al directorio del proyecto:

```bash
cd FI22028012
cd "The Sandwich Guy"
```

---

### Compilación

Compila todos los archivos fuente `.java` usando el siguiente comando:

```bash
javac controller/*.java model/*.java view/*.java *.java
```

Esto generará los archivos `.class` correspondientes en los mismos directorios.

---

### Ejecución

Ejecuta el programa principal desde la terminal con:

```bash
java Main
```

---

## Referencias y recursos utilizados

| Sitio o recurso | Descripción / uso |
|-----------------|-------------------|
| [https://docs.oracle.com/javase/](https://docs.oracle.com/javase/) | Documentación oficial de Java. |
| [https://stackoverflow.com/](https://stackoverflow.com/) | Solución de dudas y ejemplos de código. |
| [https://www.geeksforgeeks.org/](https://www.geeksforgeeks.org/) | Referencias de estructuras de datos y lógica de baraja. |
| [https://www.aluracursos.com/blog/ordenando-colecciones-con-comparable-y-comparator](https://www.aluracursos.com/blog/ordenando-colecciones-con-comparable-y-comparator) | Ordenando colecciones con Comparable y Comparator (steppat, 20/09/2023) |
|[ https://www.programiz.com/java-programming](https://openwebinars.net/blog/introduccion-a-java-estructuras-de-datos/) | Ejemplos de estructuras de datos y clases en Java. |
|[ https://www.geeksforgeeks.org/java/](https://iprogramo.com/2022/09/estructura-de-datos-stack-queue-arraylist/) | Implementación de estructuras de datos en Java (`Stack`, `Queue`, `List`). |

---

## Notas adicionales

- Se mantiene la separación de capas **MVC** para una arquitectura limpia.  
- Se excluyen los archivos compilados `.class` mediante `.gitignore`.  
- Este avance se centra en la funcionalidad lógica del proyecto.
