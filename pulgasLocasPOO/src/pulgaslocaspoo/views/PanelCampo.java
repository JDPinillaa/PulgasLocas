/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.views;
import javax.swing.*;
import java.awt.*;
import pulgaslocaspoo.models.CampoBatalla;
import pulgaslocaspoo.models.Pulga;
/**
 *
 * @author ACER
 */
public class PanelCampo extends Jpanel {
    private CampoBatalla campo;

    public PanelCampo(CampoBatalla campo) {
        this.campo = campo;
        this.setPreferredSize(new Dimension(campo.getAncho(), campo.getAlto()));
        this.setBackground(Color.WHITE);
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
    
}
