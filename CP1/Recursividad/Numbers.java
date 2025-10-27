// Fuentes conceptuales:
// - https://en.wikipedia.org/wiki/Metallic_mean  (números metálicos)
// - ChatGPT (GPT-5 Thinking)

public class Numbers {

    // n global usado para la razón f(z, n) / f(z, n - 1)
    private static double N = 25;

    // Método público que ya estaba definido: deja la fórmula cerrada
    public static double formula(double z) {
        return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    // Método público que imprime la razón recursiva f(z, N) / f(z, N-1)
    public static double recursive(double z) {
        return round(recursive(z, N) / recursive(z, N - 1));
    }

    // Método público que imprime la razón iterativa equivalente
    public static double iterative(double z) {
        return round(iterative(z, N) / iterative(z, N - 1));
    }

    // =========================
    //  SECCIÓN PRIVATE
    // =========================
    // Aquí es donde sí se nos permite tocar lógica según el enunciado.

    // round(x): redondea a 10 decimales usando double
    // Requisito: no cambiar el tipo de dato flotante (double)
    private static double round(double x) {
        double factor = Math.pow(10, 10); // 10 decimales
        return Math.round(x * factor) / factor;
    }

    // Implementación recursiva de f(z, n)
    // f(z,0)=1
    // f(z,1)=1
    // f(z,n)=z*f(z,n-1)+f(z,n-2)  para n>1
    //
    // NOTA: la firma es private static double recursive(double z, double n)
    // porque en el código público ya se está invocando recursive(z, N)
    // y N es double. No se puede cambiar eso.
    private static double recursive(double z, double n) {
        // caso base n==0
        if (n == 0.0) {
            return 1.0;
        }
        // caso base n==1
        if (n == 1.0) {
            return 1.0;
        }
        // paso recursivo
        // usamos n-1 y n-2 también como double
        return z * recursive(z, n - 1.0) + recursive(z, n - 2.0);
    }

    // Implementación iterativa equivalente a f(z,n)
    // Construimos f(z,0), f(z,1), luego vamos acumulando hasta n
    private static double iterative(double z, double n) {
        // n puede venir como double (25.0), pero conceptualmente es entero.
        int steps = (int) n;

        if (steps == 0) {
            return 1.0;
        }
        if (steps == 1) {
            return 1.0;
        }

        // f0 = f(z,0) = 1
        // f1 = f(z,1) = 1
        double prevPrev = 1.0; // f(z,k-2)
        double prev = 1.0;     // f(z,k-1)
        double current = 1.0;  // f(z,k)

        for (int k = 2; k <= steps; k++) {
            current = z * prev + prevPrev;
            // avanzar la ventana
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

    // Método main (no modificar su intención ni sus impresiones):
    // Debe imprimir los metales 0..9 con las tres aproximaciones.
    public static void main(String[] args) {

        String[] metallics = {
                "Platinum",  // [0]
                "Golden",    // [1]
                "Silver",    // [2]
                "Bronze",    // [3]
                "Copper",    // [4]
                "Nickel",    // [5]
                "Aluminum",  // [6]
                "Iron",      // [7]
                "Tin",       // [8]
                "Lead",      // [9]
        };

        for (var z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}
