package controller;
import model.*;
import view.MainView;
import javax.swing.*;

public class GameController {
    private final MainView view;
    private Caja caja;
    private Mazo mazo;
    private Mano mano;
    private Pozo pozo;

    public GameController() {
        view = new MainView(this);
        caja = new Caja();
        mostrarCaja(); 
        view.setVisible(true);
    }

    public void crearPartida() {
        mano = new Mano();
        mazo = new Mazo(caja.getCartas());
        pozo = new Pozo();

        mostrarMano();
        limpiarCaja();
        mostrarMazo();
        view.limpiarSeleccion();
        mostrarPozo();
        
    }

    private void mostrarCaja() {
        JPanel panel = view.getCajaPanel();
        panel.removeAll();
        for (Carta c : caja.getCartas()) panel.add(new JLabel(c.toString()));
        panel.revalidate();
        panel.repaint();
    }

    private void limpiarCaja() {
        JPanel panel = view.getCajaPanel();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarMano() { view.mostrarMano(mano.getCartas()); }

    private void mostrarMazo() {
        
        JPanel panel = view.getMazoPanel();
        panel.removeAll();
        for (Carta c : mazo.getCartas()) panel.add(new JLabel(c.toString()));
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarPozo() {
        JPanel panel = view.getPozoPanel();
        panel.removeAll();
        for (Carta c: pozo.getCartas()) panel.add(new JLabel(c.toString()));
        panel.revalidate();
        panel.repaint();
    }
    

    public void obtenerCarta() {
        if (mazo == null || mazo.estaVacio()) {
            JOptionPane.showMessageDialog(null, "El mazo está vacío.");
            return;
        }
        
        if( mano.estaLlena()) {
            JOptionPane.showMessageDialog(null, "La mano está llena. No puedes hagarrar más cartas.");
            return;
        }
        Carta robada = mazo.sacarCarta();
        if (robada != null && !mano.estaLlena()) {
            mostrarMazo();
            mano.agregarCarta(robada);
            mostrarMano();
            return;
        }
        
    }

    public void descartarCartaSeleccionada(Carta c){
        if(c ==null){
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna carta para descartar.");
            return;
        }
        mano.removerCarta(c);
        pozo.descartar(c);
        view.limpiarSeleccion(c);
        mostrarMano();
        mostrarPozo();
}

    public void validarSandwich(){JOptionPane.showMessageDialog(null, "Funcionalidad de validación no implementada aún.");}
   
    public void cargarPartida() { JOptionPane.showMessageDialog(null, "Funcionalidad de carga no implementada aún."); }
    public void guardarPartida() { JOptionPane.showMessageDialog(null, "Funcionalidad de guardado no implementada aún."); }
    public void ordenarMano() { JOptionPane.showMessageDialog(null, "Funcionalidad de ordenación no implementada aún.");}
}
