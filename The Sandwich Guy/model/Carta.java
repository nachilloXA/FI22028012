package model;

public class Carta {
    private final String palo;
    private final String valor;
    private final String color;
    private final int numero;

    public Carta(String palo, String valor, String color, int numero) {
        this.palo = palo;
        this.valor = valor;
        this.color = color;
        this.numero = numero;
    }

    public String getPalo() { return palo; }
    public String getValor() { return valor; }
    public String getColor() { return color; }
    public int getNumero() { return numero; }

    @Override
    public String toString() {
        return "[" + valor + "|" + palo + "]";
    }
}
