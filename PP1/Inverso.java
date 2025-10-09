public class Inverso {

    public static void main(String[] args) {
        // Validar que se pase un argumento
        if (args.length != 1) {
            System.out.println("Uso: java Inverso <numero>");
            return;
        }

        // Convertir argumento a número
        int numero = Integer.parseInt(args[0]);

        // Calcular inverso
        int inverso = invertir(numero);

        // Imprimir resultado
        System.out.println(numero + " → " + inverso);
    }

    // Método recursivo para invertir
    public static int invertir(int n) {
        // Caso base: si es un solo dígito
        if (n < 10) {
            return n;
        }

        // Último dígito (residuo)
        int residuo = n % 10;
        // Resto del número (cociente)
        int cociente = n / 10;

        // Número de dígitos restantes en el cociente
        int numDigitos = contarDigitos(cociente);

        // Calcular inverso usando potencia de 10
        return residuo * (int)Math.pow(10, numDigitos) + invertir(cociente);
    }

    // Método auxiliar para contar dígitos
    public static int contarDigitos(int n) {
        if (n == 0) return 0;
        return 1 + contarDigitos(n / 10);
    }
}
