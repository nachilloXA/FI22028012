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

### Novedades del Avance 2
 - **Nueva Entidad**: Implementación del Pozo para gestionar las cartas descartadas.

 - **Interacción del Jugador**: Funcionalidad completa para seleccionar y descartar cartas de la mano.

 - **Sincronización de la Vista**: Mejora en la interfaz gráfica para persistir la selección visual de las cartas al actualizar el panel.

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

## Editores o IDEs utilizados

- Visual Studio Code  

---

## Instructivo

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


---

## Notas adicionales

- Se mantiene la separación de capas **MVC** para una arquitectura limpia.  
- Se excluyen los archivos compilados `.class` mediante `.gitignore`.  
- Este avance se centra en la funcionalidad lógica del proyecto.
