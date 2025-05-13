/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import pulgaslocaspoo.models.CampoBatalla;
import pulgaslocaspoo.models.Pulga;
import pulgaslocaspoo.models.SimuladorPulgas;

/**
 * Clase que representa el panel gráfico donde se dibuja el campo de batalla.
 * Maneja la interacción del usuario mediante clics y movimientos del mouse.
 * 
 * También se encarga de redibujar las pulgas en el campo de batalla.
 * 
 * @author ACER
 */
public class PanelCampo extends JPanel {
    private CampoBatalla campo;
    private SimuladorPulgas simulador;
    private int mouseX;
    private int mouseY;

    /**
     * Constructor de la clase PanelCampo.
     * 
     * @param campo El campo de batalla que se dibujará en el panel.
     * @param simulador El simulador que controla la lógica del juego.
     */
    public PanelCampo(CampoBatalla campo, SimuladorPulgas simulador) {
        this.campo = campo;
        this.simulador = simulador;
        this.setPreferredSize(new Dimension(campo.getAncho(), campo.getAlto()));
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        this.requestFocusInWindow();

        // Manejar clics del mouse
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    simulador.manejarClic(e.getX(), e.getY());
                    actualizar();
                }
            }
        });

        // Manejar movimiento del mouse
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
    }

    /**
     * Establece el simulador asociado al panel.
     * 
     * @param simulador El simulador que controla la lógica del juego.
     */
    public void setSimulador(SimuladorPulgas simulador) {
        this.simulador = simulador;
    }

    /**
     * Dibuja las pulgas en el campo de batalla.
     * 
     * @param g El objeto Graphics utilizado para dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pulga p : campo.getPulgas()) {
            g.drawImage(p.getImagen(), p.getX(), p.getY(), this);
        }
    }

    /**
     * Actualiza el panel redibujando el contenido.
     */
    public void actualizar() {
        repaint();
    }

    /**
     * Obtiene la coordenada X del mouse.
     * 
     * @return La coordenada X del mouse.
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * Obtiene la coordenada Y del mouse.
     * 
     * @return La coordenada Y del mouse.
     */
    public int getMouseY() {
        return mouseY;
    }
}



