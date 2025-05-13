/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

/**
 * Clase abstracta que representa un arma en el juego.
 * Las armas deben implementar el método disparar, que define su comportamiento
 * al ser utilizadas en el campo de batalla.
 * 
 * @author Santiago Uribe
 * @version 1.0
 * @since 2025-05-07
 */
public abstract class Arma {

    /**
     * Método abstracto que define el comportamiento del arma al disparar.
     * 
     * @param campo El campo de batalla donde se encuentran las pulgas.
     * @param x La coordenada X donde se realiza el disparo.
     * @param y La coordenada Y donde se realiza el disparo.
     * @param simulador El simulador que controla la lógica del juego.
     */
    public abstract void disparar(CampoBatalla campo, int x, int y, SimuladorPulgas simulador);
}
