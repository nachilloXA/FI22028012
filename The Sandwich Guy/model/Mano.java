package model;

import java.util.LinkedList;
import java.util.List;

public class Mano {
    private final List<Carta> cartas;

    public Mano() { cartas = new LinkedList<>(); }
    public boolean estaLlena() { return cartas.size() >= 8; }
    public void agregarCarta(Carta c) { if (cartas.size() < 8) cartas.add(c); }
    public List<Carta> getCartas() { return cartas; }
    public void removerCarta(Carta c) { cartas.remove(c); }
}
