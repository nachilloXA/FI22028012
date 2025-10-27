# Práctica Programada 2 - Estructuras de Datos

**Nombre:** Jesús Ignacio Álvarez Briceño  
**Carné:** FI22028012  
**Curso:** SC-304 Estructuras de Datos


## Descripción

Este programa (`Revert.java`) permite leer el contenido de un archivo de texto (`input.txt`), almacenarlo en una pila de caracteres (`Stack<Character>`) y luego generar un nuevo archivo (`output.txt`) con el contenido invertido.
El objetivo de esta práctica es familiarizarse con la estructura de datos **pila (Stack)** en Java y el uso de los métodos `push` y `pop`.

## Tecnologías utilizadas

- **Lenguaje:** Java  
- **JDK:** 21 LTS  
- **IDE utilizado:** Visual Studio Code  
- **Bibliotecas estándar:**  
  - `java.io` para manejo de archivos  
  - `java.util.Stack` para la estructura de pila



# Fuentes consultadas
- [Documentación oficial de Stack (Java](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html)


# Preguntas teóricas
### 1. ¿Existe otra forma de invertir el contenido de un archivo sin usar una pila?
Sí. Se podría leer todo el contenido en un String o en un StringBuilder, y luego utilizar el método reverse() para invertirlo.
Esto sería más directo, pero en esta práctica se utiliza Stack para reforzar el concepto de la estructura LIFO (Last In, First Out).

### 2. Ejemplo de la vida real de una pila
Un ejemplo cotidiano puede ser una una pila de platos:
El último plato que se pone encima es el primero que se retira.
Esto representa perfectamente el comportamiento LIFO de una pila.
