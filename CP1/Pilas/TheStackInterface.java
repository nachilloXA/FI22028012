// Fuente de diseño base de pila con límite de capacidad: estructura Stack<T> de Java
// ChatGPT (GPT-5 Thinking)

public interface TheStackInterface<Type> {

    Boolean push(Type item);

    Type pop();

    Type peek();

    Boolean empty();

    Integer size();

    String print();
}
