// Uso de java.util.Stack y java.util.Random
// ChatGPT (GPT-5 Thinking)

import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    // ======================
    // Atributos PRIVATE (NO se modifica según enunciado)
    // ======================
    private Stack<Type> _stack;
    private Integer _capacity;

    // Constructor (NO se modifica según enunciado)
    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    // Improvement:
    // push debe devolver true/false según si pudo insertar
    @Override
    public Boolean push(Type item) {
        // ¿hay espacio aún?
        boolean available = _stack.size() < _capacity;
        if (available) {
            _stack.push(item);
            return true;
        }
        // overflow → no inserta
        return false;
    }

    // Update:
    // pop retorna el tope y lo elimina.
    // Si está vacía, debe retornar null sin usar try/catch
    @Override
    public Type pop() {
        if (_stack.empty()) {
            return null;
        }
        return _stack.pop();
    }

    // Update:
    // peek retorna el tope sin eliminar.
    // Si está vacía, debe retornar null.
    @Override
    public Type peek() {
        if (_stack.empty()) {
            return null;
        }
        return _stack.peek();
    }

    @Override
    public Boolean empty() {
        return _stack.empty();
    }

    @Override
    public Integer size() {
        return _stack.size();
    }

    @Override
    public String print() {
        return _stack.toString();
    }

    // main:
    // - Lee n desde args[0] como capacidad
    // - Inserta (capacidad + 1) doubles aleatorios con push
    // - Imprime bloque "Pushed {full}"
    // - Hace pop (capacidad + 1) veces
    // - Imprime bloque "Popped {empty}"
    //
    // No agregamos println extra que no esté en el formato descrito.
    public static void main(String[] args) {

        int capacity = Integer.parseInt(args[0]);
        TheStack<Double> stack = new TheStack<>(capacity);

        Random random = new Random();

        System.out.println("Pushing {capacity + 1}");
        for (int n = 0; n <= capacity; n++) {
            double value = random.nextDouble();
            Boolean pushed = stack.push(value);
            System.out.println(" ↳ push(" + value + ") → " + pushed);
        }

        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());

        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (int n = 0; n <= capacity; n++) {
            Double popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }

        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}
