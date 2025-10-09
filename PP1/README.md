# Práctica Supervisada 1 — Inverso de un número

**Nombre:** Jesús Ignacio Alvarez Briceño  
**Carné:** FI22028012

## Descripción
Este programa toma un número natural como argumento y muestra su inverso utilizando un algoritmo recursivo basado en cociente y residuo de divisiones.

## Ejemplo de ejecución

$ java Inverso 123
123 → 321


# Fuentes consultadas
- [https://docs.oracle.com/](https://docs.oracle.com/)
- [https://www.geeksforgeeks.org/recursion-in-java/](https://www.geeksforgeeks.org/recursion-in-java/)
- [https://www.w3schools.com/java/](https://www.w3schools.com/java/)

# Prompts usados con IA
- “Escribe un programa en Java que invierta un número usando recursividad, cociente y residuo”
- “Explícame cómo crear carpeta PP1 en GitHub”
- “Cómo excluir archivos .class con gitignore”

IA utilizada: **ChatGPT (GPT-5)**  


# Preguntas

### 1. ¿Es posible implementar una solución equivalente pero de comportamiento iterativo?
Sí. Se puede hacer con un ciclo `while`, extrayendo el residuo y multiplicando por 10 en cada iteración para construir el número inverso.

### 2. ¿Cree que hay alguna otra manera recursiva de generar el mismo resultado?
Sí. Otra forma sería usar una función recursiva con un **acumulador** que vaya formando el número invertido en cada llamada.

### 3. ¿Qué relación observa entre el algoritmo para invertir un número natural y las estrategias para pasar de una base numérica a otra?
Ambos procesos usan **divisiones sucesivas** para obtener los dígitos (o residuos).  
Invertir un número es muy parecido a convertir de base 10 a otra base: se toman residuos y se reconstruye el número en un nuevo orden.
