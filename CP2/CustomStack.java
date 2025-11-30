public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        // Implementación apoyada por ChatGPT (GPT-5.1).
        // El nuevo nodo apunta al tope actual y luego se convierte en el nuevo tope. Apila al inicio (LIFO)
        node.setNext(_head);

        _head = node;
    }

    public String pop() {
        String word = null;

        // Actualizar
        // Implementación apoyada por ChatGPT (GPT-5.1).
        // Esta implementación devuelve la palabra del tope y lo quita, si esta vacia devuelve null.
        if (_head != null) {
            // Recuperamos la palabra del nodo en el tope
            word = _head.getWord();
            // Movemos el tope al siguiente nodo
            _head = _head.getNext();
        }

        return word;
    }

    public int size() {
        var length = 0;

        // Actualizar
        // Implementación apoyada por ChatGPT (GPT-5.1).
        // Esta implentación cuenta cuántos elementos hay en la pila.
        StackNode current = _head;
        while (current != null) {
            length++;
            current = current.getNext();
        }

        return length;
    }

    public String getWords() {
        var builder = new StringBuilder("(" + size() + ") [");
        for (var word = pop(); word != null; word = pop()) {
            builder.append(" " + word);
        }
        builder.append(" ]");
        return builder.toString();
    }
}
