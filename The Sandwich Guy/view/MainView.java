package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;
import model.Carta;

public class MainView extends JFrame {
    private final JButton nuevaPartidaBtn, cargarPartidaBtn, obtenerCartaBtn, descartarCartaBtn, validarSandwichBtn, ordenarBtn, guardarBtn ;
    private final JPanel cajaPanel, manoPanel, mazoPanel, pozoPanel;
    private final JPanel manoAccionPanel, manoCartasPanel; 
    private final GameController controller;
    private final List<Carta> cartasSeleccionadas = new ArrayList<>();

    public MainView(GameController controller) {
        this.controller = controller;
        setTitle("♥ ♦ ♠ ♣ - The Sandwich Guy - ♥ ♦ ♠ ♣");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel Superior
        JPanel topPanel = new JPanel();
        nuevaPartidaBtn = new JButton("Nueva Partida");
        cargarPartidaBtn = new JButton("Cargar Partida");
        topPanel.add(nuevaPartidaBtn);
        topPanel.add(cargarPartidaBtn);
        add(topPanel, BorderLayout.NORTH);

        // --- Creación de Secciones centrales con FlowLayout ---
        cajaPanel = crearSeccion("Caja", new FlowLayout());
        mazoPanel = crearSeccion("Mazo", new FlowLayout()); 
        pozoPanel = crearSeccion("Pozo", new FlowLayout()); 
        
        // El manoPanel
        manoPanel = crearSeccion("Mano", new BorderLayout()); 

        // --- Creación de botones de acción para panelMano ---
        obtenerCartaBtn = new JButton("Obtener Carta");
        descartarCartaBtn = new JButton("Descartar Carta");
        ordenarBtn = new JButton("Ordenar");

        // 1. Panel de Acciones en panelMano
        manoAccionPanel = new JPanel();
        manoAccionPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        manoAccionPanel.add(obtenerCartaBtn);
        manoAccionPanel.add(descartarCartaBtn);
        manoAccionPanel.add(ordenarBtn);
        
        // 2. Panel de Datos en panelMano
        manoCartasPanel = new JPanel();
        manoCartasPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        
        // Añadir los subpaneles al manoPanel
        manoPanel.add(manoAccionPanel, BorderLayout.NORTH); 
        manoPanel.add(manoCartasPanel, BorderLayout.CENTER); 
        
        
        // Añadir los subpaneles al manoPanel
        manoPanel.add(manoAccionPanel, BorderLayout.NORTH);
        manoPanel.add(manoCartasPanel, BorderLayout.CENTER); 

        // --- Panel Central ---
        JPanel center = new JPanel(new GridLayout(2, 2));
        center.add(cajaPanel);
        center.add(manoPanel);
        center.add(mazoPanel);
        center.add(pozoPanel);
        add(center, BorderLayout.CENTER);

        // --- Panel Inferior ---
        validarSandwichBtn = new JButton("Validar");
        guardarBtn = new JButton("Guardar");
        JPanel actionPanel = new JPanel();
        actionPanel.add(validarSandwichBtn);
        actionPanel.add(guardarBtn);
        add(actionPanel, BorderLayout.SOUTH);

        // --- Listeners (Se mantienen igual) ---
        nuevaPartidaBtn.addActionListener(e -> controller.crearPartida());
        cargarPartidaBtn.addActionListener(e -> controller.cargarPartida());
        obtenerCartaBtn.addActionListener(e -> controller.obtenerCarta());
        descartarCartaBtn.addActionListener(e -> controller.descartarCartaSeleccionada(getPrimeraSeleccionada()));
        validarSandwichBtn.addActionListener(e -> controller.validarSandwich());
        ordenarBtn.addActionListener(e -> controller.ordenarMano());
        guardarBtn.addActionListener(e -> controller.guardarPartida());
    }

    // --- Método crearSeccion modificado para aceptar un LayoutManager ---
    private JPanel crearSeccion(String titulo, LayoutManager layout) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setLayout(layout);
        return panel;
    }

    public void mostrarMano(List<Carta> cartas) {
        manoCartasPanel.removeAll();
        for (Carta c : cartas) {
            JButton cartaBtn = new JButton(c.toString());
            if (cartasSeleccionadas.contains(c)) {
                cartaBtn.setBackground(Color.decode("#0a0a5c")); 
                cartaBtn.setForeground(Color.WHITE);             
            } else {
                cartaBtn.setBackground(null);
                cartaBtn.setForeground(Color.BLACK);
            }
            cartaBtn.addActionListener(e -> toogleCartaSeleccionada(c, cartaBtn) );
            manoCartasPanel.add(cartaBtn);
        }
        manoCartasPanel.revalidate();
        manoCartasPanel.repaint();
    }

    public void toogleCartaSeleccionada(Carta carta, JButton boton) {
        if (cartasSeleccionadas.contains(carta)) {
            cartasSeleccionadas.remove(carta);
            boton.setBackground(null); // Deseleccionar
            boton.setForeground(Color.BLACK);
            boton.repaint();
        } else if (cartasSeleccionadas.size() < 3) { // podremos graduar el maximo de cartas seleccionadas
            cartasSeleccionadas.add(carta);
            boton.setBackground(Color.decode("#0a0a5c")); // Seleccionar
            boton.setForeground(Color.WHITE);
        }
    }
    

    private Carta getPrimeraSeleccionada() {
        return cartasSeleccionadas.isEmpty() ? null : cartasSeleccionadas.get(0);
    }

    public void limpiarSeleccion(Carta c) {
        cartasSeleccionadas.remove(c);
        
    }

    public void limpiarSeleccion() {
        cartasSeleccionadas.clear();
        for (Component comp : manoPanel.getComponents()) {
            if (comp instanceof JButton) comp.setBackground(null);
        }
    }

    // --- Getters ---
    public JPanel getCajaPanel() { return cajaPanel; }
    public JPanel getManoPanel() { return manoPanel; } 
    public JPanel getMazoPanel() { return mazoPanel; }
    public JPanel getPozoPanel() { return pozoPanel; }

}