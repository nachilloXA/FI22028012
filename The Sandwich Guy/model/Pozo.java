package model;

import java.util.LinkedList;
import java.util.Queue;

public class Pozo {
    private final Queue<Carta> cartas;

    public Pozo() { cartas = new LinkedList<>(); }

    public void descartar(Carta c) { cartas.add(c); }
    public Queue<Carta> getCartas() { return cartas; }
}
