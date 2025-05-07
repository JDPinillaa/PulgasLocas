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
public class PulgaMutante extends Pulga {
    public PulgaMutante() {
        super(0, 0, 2);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_mutante.png").getImage();
    }

    public PulgaMutante(int x, int y) {
        super(x, y, 2);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_mutante.png").getImage();
    }

    @Override
    public boolean impactar() {
        setResistencia(getResistencia() - 1);
        return getResistencia() <= 0;
    }

    @Override
    public String getTipo() {
        return "Mutante";
    }
}
