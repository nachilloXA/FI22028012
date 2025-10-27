// Uso de java.util.ArrayDeque y Arrays
// ChatGPT (GPT-5 Thinking)

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class TheQueue<Type> implements TheQueueInterface<Type> {

    // ======================
    // Atributo privado (NO modificar según enunciado)
    // ======================
    private Deque<Type> _queue;

    // Constructor (NO modificar según enunciado)
    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    // Encola al "final" de la cola (lado derecho)
    @Override
    public void enqueue(Type item) {
        _queue.addLast(item);
    }

    // Improvement:
    // dequeue obtiene el primer elemento y lo elimina.
    // Si está vacía debe retornar null.
    // Sin if / else: usamos pollFirst()
    @Override
    public Type dequeue() {
        return _queue.pollFirst(); // pollFirst() da null si está vacía
    }

    // Improvement:
    // getFront obtiene el primer elemento sin quitarlo.
    // Si está vacía debe retornar null.
    // Sin if / else: usamos peekFirst()
    @Override
    public Type getFront() {
        return _queue.peekFirst(); // peekFirst() da null si está vacía
    }

    @Override
    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    @Override
    public int getSize() {
        return _queue.size();
    }

    @Override
    public String print() {
        return _queue.toString();
    }

    // Update:
    // getCodons:
    // 1. Determina cuántos elementos hay al inicio (nOriginal).
    // 2. Crea un arreglo de Strings de tamaño nOriginal / 3.
    // 3. Va desencolando de 3 en 3 y concatenando esas 3 letras.
    // 4. La cola queda vacía al final.
    @Override
    public String[] getCodons() {

        int nOriginal = _queue.size();
        int codonCount = nOriginal / 3;
        String[] codons = new String[codonCount];

        for (int i = 0; i < codonCount; i++) {
            // Cada codón = concatenación de 3 elementos consecutivos
            StringBuilder sb = new StringBuilder();

            // Vamos sacando (desencolando) 3 veces
            for (int k = 0; k < 3; k++) {
                Type nucleotide = _queue.pollFirst(); // va dejando la cola vacía
                sb.append(nucleotide); // nucleotide es, por ejemplo, "A"
            }

            codons[i] = sb.toString();
        }

        return codons;
    }

    // main:
    // - Lee n desde args[0]
    // - Genera n nucleótidos aleatorios de {A, C, G, T}
    // - Encola cada uno
    // - Imprime bloque "Filled {full}"
    // - Imprime getCodons()
    // - Luego imprime bloque final con cola ya vacía
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        TheQueue<String> queue = new TheQueue<>();

        // Generar n nucleótidos al azar
        // Usaremos Random y el arreglo ["A","C","G","T"]
        String[] bases = { "A", "C", "G", "T" };
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            String base = bases[rnd.nextInt(bases.length)];
            queue.enqueue(base);
        }

        // Estado lleno
        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());

        // Codones (esto vacía la cola)
        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));

        // Cola ya vacía
        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}
