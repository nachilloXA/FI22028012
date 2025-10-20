package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import controller.GameController;
import model.Carta;

public class MainView extends JFrame {
    private final JButton nuevaPartidaBtn, cargarPartidaBtn, obtenerCartaBtn, descartarCartaBtn, validarSandwichBtn;
    private final JPanel cajaPanel, manoPanel, mazoPanel, pozoPanel;
    private final GameController controller;

    public MainView(GameController controller) {
        this.controller = controller;
        setTitle("PK-G5");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        nuevaPartidaBtn = new JButton("Nueva Partida");
        cargarPartidaBtn = new JButton("Cargar Partida");
        topPanel.add(nuevaPartidaBtn);
        topPanel.add(cargarPartidaBtn);
        add(topPanel, BorderLayout.NORTH);

        cajaPanel = crearSeccion("Caja");
        manoPanel = crearSeccion("Mano");
        mazoPanel = crearSeccion("Mazo");
        pozoPanel = crearSeccion("Pozo");

        JPanel center = new JPanel(new GridLayout(2, 2));
        center.add(cajaPanel);
        center.add(manoPanel);
        center.add(mazoPanel);
        center.add(pozoPanel);
        add(center, BorderLayout.CENTER);

        obtenerCartaBtn = new JButton("Obtener Carta");
        descartarCartaBtn = new JButton("Descartar Carta");
        validarSandwichBtn = new JButton("Validar");

        JPanel actionPanel = new JPanel();
        actionPanel.add(obtenerCartaBtn);
        actionPanel.add(descartarCartaBtn);
        actionPanel.add(validarSandwichBtn);
        add(actionPanel, BorderLayout.SOUTH);

        nuevaPartidaBtn.addActionListener(e -> controller.crearPartida());
        cargarPartidaBtn.addActionListener(e -> controller.cargarPartida());
        obtenerCartaBtn.addActionListener(e -> controller.obtenerCarta());
        descartarCartaBtn.addActionListener(e -> controller.descartarCartaSeleccionada());
        validarSandwichBtn.addActionListener(e -> controller.validarSandwich());
    }

    private JPanel crearSeccion(String titulo) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setLayout(new FlowLayout());
        return panel;
    }

    public void mostrarMano(List<Carta> cartas) {
        manoPanel.removeAll();
        for (Carta c : cartas) {
            JButton cartaBtn = new JButton(c.toString());
            manoPanel.add(cartaBtn);
        }
        manoPanel.revalidate();
        manoPanel.repaint();
    }



    public JPanel getCajaPanel() { return cajaPanel; }
    public JPanel getManoPanel() { return manoPanel; }
    public JPanel getMazoPanel() { return mazoPanel; }
   

	
}
