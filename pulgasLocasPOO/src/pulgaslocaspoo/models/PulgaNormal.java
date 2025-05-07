/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import javax.swing.ImageIcon;

/**
 *
 * @author juand
 */
public class PulgaNormal extends Pulga {
    public PulgaNormal() {
        super(0, 0, 1); 
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_normal.png").getImage();
    }

    public PulgaNormal(int x, int y) {
        super(x, y, 1);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_normal.png").getImage();
    }

    @Override
    public boolean impactar() {
        return true; // Muere al primer impacto
    }

    @Override
    public String getTipo() {
        return "Normal";
    }
}