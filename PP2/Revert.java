import java.io.*;
import java.util.Stack;

public class Revert {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Pila de caracteres
        Stack<Character> stack = new Stack<>();

        // 1- Leer el archivo y meter caracteres en la pila
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int data;
            while ((data = reader.read()) != -1) {
                stack.push((char) data);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada: " + e.getMessage());
            return;
        }

        // 2️- Vaciar la pila y escribir en el archivo de salida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!stack.isEmpty()) {
                writer.write(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de salida: " + e.getMessage());
            return;
        }

        System.out.println("Contenido invertido correctamente en " + outputFile);
    }
}
