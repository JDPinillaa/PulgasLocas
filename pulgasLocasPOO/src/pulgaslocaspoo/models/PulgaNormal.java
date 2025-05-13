/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import javax.swing.ImageIcon;

/**
 * Clase que representa una pulga normal en el juego.
 * Las pulgas normales tienen una resistencia de 1 y mueren al primer impacto.
 * 
 * @author juand
 */
public class PulgaNormal extends Pulga {

    /**
     * Constructor por defecto de PulgaNormal.
     * La pulga se inicializa en la posición (0, 0) con una resistencia de 1.
     */
    public PulgaNormal() {
        super(0, 0, 1); 
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_normal.png").getImage();
    }

    /**
     * Constructor de PulgaNormal con posición inicial.
     * 
     * @param x La posición X de la pulga.
     * @param y La posición Y de la pulga.
     */
    public PulgaNormal(int x, int y) {
        super(x, y, 1);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_normal.png").getImage();
    }

    /**
     * Método que define el comportamiento de la pulga al ser impactada.
     * Las pulgas normales mueren al primer impacto.
     * 
     * @return {@code true} siempre, ya que mueren al primer impacto.
     */
    @Override
    public boolean impactar() {
        return true; // Muere al primer impacto
    }

    /**
     * Devuelve el tipo de la pulga.
     * 
     * @return "Normal".
     */
    @Override
    public String getTipo() {
        return "Normal";
    }
}