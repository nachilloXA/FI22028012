import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        // Actualizar
        int index = 0;

        while (index < _tree.length) {
            if (_tree[index] == null) {
                // Encontramos espacio libre: insertamos aquí
                _tree[index] = value;
                break;
            } else if (value < _tree[index]) {
                // Ir al hijo izquierdo: 2i + 1
                index = 2 * index + 1;
            } else if (value > _tree[index]) {
                // Ir al hijo derecho: 2i + 2
                index = 2 * index + 2;
            } else {
                // Si el valor ya existe, no insertamos duplicados
                break;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        // Actualizar
        if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }

        var stack = new Stack<Integer>();
        stack.push(0); // raíz

        while (!stack.isEmpty()) {
            int index = stack.pop();

            if (index < 0 || index >= _tree.length || _tree[index] == null) {
                continue;
            }

            // Visitar nodo actual
            System.out.print(_tree[index] + " ");

            // Primero empujamos el hijo derecho (para que el izquierdo salga primero)
            int right = 2 * index + 2;
            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }

            // Luego empujamos el hijo izquierdo
            int left = 2 * index + 1;
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        // Actualizar
        if (_tree.length == 0 || _tree[0] == null) {
            System.out.println();
            return;
        }

        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();

        stack1.push(0); // raíz

        // Recorremos con dos pilas
        while (!stack1.isEmpty()) {
            int index = stack1.pop();

            if (index < 0 || index >= _tree.length || _tree[index] == null) {
                continue;
            }

            // Pasar nodo a la segunda pila
            stack2.push(index);

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < _tree.length && _tree[left] != null) {
                stack1.push(left);
            }
            if (right < _tree.length && _tree[right] != null) {
                stack1.push(right);
            }
        }

        // La segunda pila nos da el recorrido en posorden
        while (!stack2.isEmpty()) {
            int index = stack2.pop();
            System.out.print(_tree[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
