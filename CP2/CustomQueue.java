public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);

        // Actualizar
        // Implementación apoyada por ChatGPT (modelo GPT-5.1 Thinking).
        // Esta implementación inserta al final de la lista enlazada (cola clásica tipo FIFO)
        if (_head == null) {
            // Segun la implementacion utilizada, si la cola está vacía, el nuevo nodo se convierte en la cabeza
            _head = node;
        } else {
            // Caso contrario, se recorre hasta el último nodo y se enlaza al final
            QueueNode current = _head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    public int dequeue() {
        var index = -1;

        // Actualizar
        // Implementación apoyada por ChatGPT (modelo GPT-5.1 Thinking).
        // Esta implementación extrae la cabeza y devuelve el índice o -1 si está vacía.
        if (_head != null) {
            // Se toma el índice del nodo en la cabeza
            index = _head.getIndex();
            // Avanza la cabeza al siguiente nodo
            _head = _head.getNext();
        }

        return index;
    }

    public int getSize() {
        var size = 0;

        // Actualizar
        // Implementación apoyada por ChatGPT (modelo GPT-5.1 Thinking).
        // Esta implementación recorre la lista sin modificarla y cuenta los nodos
        QueueNode current = _head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}
