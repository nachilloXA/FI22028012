package model;

import java.util.LinkedList;
import java.util.List;

public class Caja {
    private final LinkedList<Carta> cartas;

    public Caja() {
        cartas = new LinkedList<>();
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for (String palo : palos) {
            String color = (palo.equals("♥") || palo.equals("♦")) ? "rojo" : "negro";
            for (int i = 0; i < valores.length; i++) {
                cartas.add(new Carta(palo, valores[i], color, i + 1));
            }
        }
    }

    public List<Carta> getCartas() { return cartas; }
    //public Carta sacarCarta() { return cartas.isEmpty() ? null : cartas.removeFirst(); }
}
