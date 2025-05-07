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
 *
 * @author ACER
 */
public class PanelCampo extends JPanel {
    private CampoBatalla campo;
    private SimuladorPulgas simulador;
    private int mouseX;
    private int mouseY;

    public PanelCampo(CampoBatalla campo, SimuladorPulgas simulador) {
        this.campo = campo;
        this.simulador = simulador;
        this.setPreferredSize(new Dimension(campo.getAncho(), campo.getAlto()));
        this.setBackground(Color.WHITE);

        // Agregar MouseListener para manejar clics
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Disparar la pistola Pulguipium
                    simulador.manejarClic(e.getX(), e.getY());
                    actualizar();
                }
            }
        });

        // Agregar MouseMotionListener para rastrear el movimiento del mouse
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
    }

    public void setSimulador(SimuladorPulgas simulador) {
        this.simulador = simulador;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pulga p : campo.getPulgas()) {
            g.drawImage(p.getImagen(), p.getX(), p.getY(), this);
        }
    }

    public void actualizar() {
        repaint();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
