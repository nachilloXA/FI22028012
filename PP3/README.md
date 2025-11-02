# Práctica Programada 3 – Listas Doblemente Circulares

## Estudiante
**Nombre:** Jesús Ignacio Álvarez Briceño  
**Carné:** FI22028012  
**IDE utilizado:** Visual Studio Code  

---

---

## Estructura del repositorio
```
PP3/
 ├── .gitignore
 ├── ListDoublyCircular.java
 ├── ListInterface.java
 ├── NodeDoubly.java
 └── README.md
```

---

## Fuentes consultadas

- [Documentación oficial de Oracle Java SE 21](https://docs.oracle.com/en/java/javase/21/)
- [GeeksforGeeks – Doubly Circular Linked List](https://www.geeksforgeeks.org/doubly-circular-linked-list/)
- [W3Schools – Java LinkedList Tutorial](https://www.w3schools.com/java/java_linkedlist.asp)
- Consultas realizadas mediante ChatGPT (GPT-5)

---

## Prompts y respuestas de IA utilizadas

**Prompt 1:**  
> “¿Podrías ayudarme a implementar los métodos addFirst, addLast, removeFirst y removeLast en una lista circular doblemente enlazada en Java, asegurando la correcta actualización de punteros?”

**Respuesta resumida:**  
La IA explicó cómo mantener la circularidad de los nodos mediante los punteros `prev` y `next`, cuidando los casos especiales (lista vacía y lista con un solo nodo).  
Se proporcionó el código completo para los cuatro métodos, garantizando que las referencias `head` y `tail` siempre apunten a los nodos correctos y que los punteros internos mantengan la estructura circular.

**Prompt 2:**  
> “Explícame la diferencia entre usar una lista creada manualmente y las estructuras nativas de Java como List o LinkedList.”

**Respuesta resumida:**  
La IA indicó que las listas creadas manualmente son útiles para el aprendizaje, el control del comportamiento interno y la comprensión de punteros, mientras que las listas nativas son más eficientes, seguras y optimizadas para producción.

---

## Respuestas

### 1. Si tuviera que implementar una estructura tipo Cola (Queue), ¿qué tipo de lista (simple, circular, doblemente enlazada o circular doblemente enlazada) utilizaría y por qué? ¿Y para una estructura tipo Pila (Stack)?
Utilizaría una **lista circular doblemente enlazada**, ya que permite insertar elementos por un extremo (`addLast`) y eliminarlos por el otro (`removeFirst`) sin necesidad de recorrer la lista.  
Esta estructura garantiza que las operaciones de encolado y desencolado sean eficientes (O(1)) y mantiene la conexión continua entre el primer y el último nodo.

### ¿Cuál cree que podría ser una ventaja y una desventaja de utilizar una estructura de tipo lista creada por usted mismo, en vez de las opciones proveídas directamente por los módulos estándar de Java (como por ejemplo List)?
Para una pila, emplearía una **lista simplemente enlazada**, ya que solo se requieren operaciones en un extremo (tipo LIFO: Last In, First Out).  
Con una lista simple, la inserción y eliminación se realizan al inicio (`push` y `pop`) sin necesidad de mantener referencias dobles, optimizando memoria y simplicidad.

### 3. Ventajas de usar una lista creada manualmente
- Permite comprender el funcionamiento interno de las estructuras dinámicas.  
- Brinda control total sobre cómo se enlazan y actualizan los nodos.  
- Es ideal para fines académicos y de aprendizaje de algoritmos.

### 4. Desventajas frente a las listas estándar de Java
- Mayor riesgo de errores de implementación (referencias nulas o ciclos mal cerrados).  
- No están optimizadas ni probadas para grandes volúmenes de datos.  
- Requieren más tiempo de desarrollo y mantenimiento.  

---
