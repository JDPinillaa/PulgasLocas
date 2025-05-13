/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import javax.swing.ImageIcon;

/**
 * Clase que representa una pulga mutante en el juego.
 * Las pulgas mutantes tienen una resistencia de 2 y requieren dos impactos para ser eliminadas.
 * 
 * @author Juan Diego
 * @version 1.0
 * @since 2025-05-07
 */
public class PulgaMutante extends Pulga {

    /**
     * Constructor por defecto de PulgaMutante.
     * La pulga se inicializa en la posición (0, 0) con una resistencia de 2.
     */
    public PulgaMutante() {
        super(0, 0, 2);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_mutante.png").getImage();
    }

    /**
     * Constructor de PulgaMutante con posición inicial.
     * 
     * @param x La posición X de la pulga.
     * @param y La posición Y de la pulga.
     */
    public PulgaMutante(int x, int y) {
        super(x, y, 2);
        this.imagen = new ImageIcon("src/pulgaslocaspoo/resources/pulga_mutante.png").getImage();
    }

    /**
     * Método que define el comportamiento de la pulga al ser impactada.
     * Reduce la resistencia de la pulga en 1 por cada impacto.
     * 
     * @return {@code true} si la resistencia llega a 0, {@code false} en caso contrario.
     */
    @Override
    public boolean impactar() {
        setResistencia(getResistencia() - 1);
        return getResistencia() <= 0;
    }

    /**
     * Devuelve el tipo de la pulga.
     * 
     * @return "Mutante".
     */
    @Override
    public String getTipo() {
        return "Mutante";
    }
}
