/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;
import java.awt.Image;
import java.util.Random;

/**
 * Clase abstracta que representa una pulga en el juego.
 * Las pulgas tienen una posición, resistencia y un estado de impacto.
 * Cada tipo de pulga debe implementar su comportamiento al ser impactada.
 * 
 * @author juand
 */
public abstract class Pulga {
    private int x;
    private int y;
    private int resistencia;
    private boolean impactada;
    protected Image imagen;

    // Nueva propiedad: dirección actual de la pulga
    private String direccionActual;
    private int distanciaRecorrida;

    /**
     * Constructor de la clase Pulga.
     * 
     * @param x La posición X de la pulga en el campo de batalla.
     * @param y La posición Y de la pulga en el campo de batalla.
     * @param resistencia La cantidad de impactos necesarios para eliminar la pulga.
     */
    public Pulga(int x, int y, int resistencia) {
        this.x = x;
        this.y = y;
        this.resistencia = resistencia;
        this.direccionActual = obtenerDireccionAleatoria(); // Dirección inicial aleatoria
        this.distanciaRecorrida = 0;
    }

    /**
     * Obtiene una dirección aleatoria.
     * 
     * @return Una de las direcciones: "ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA".
     */
    private String obtenerDireccionAleatoria() {
        String[] direcciones = {"ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA"};
        return direcciones[new Random().nextInt(direcciones.length)];
    }

    /**
     * Cambia la dirección de la pulga de manera aleatoria.
     */
    public void cambiarDireccion() {
        this.direccionActual = obtenerDireccionAleatoria();
        this.distanciaRecorrida = 0; // Reiniciar la distancia recorrida
    }

    /**
     * Mueve la pulga en su dirección actual.
     * 
     * @param ancho El ancho del campo de batalla.
     * @param alto El alto del campo de batalla.
     */
    public void mover(int ancho, int alto) {
        int anchoImagen = imagen != null ? imagen.getWidth(null) : 1;
        int altoImagen = imagen != null ? imagen.getHeight(null) : 1;

        switch (direccionActual) {
            case "ARRIBA":
                if (y > 0) y--;
                break;
            case "ABAJO":
                if (y < alto - altoImagen) y++;
                break;
            case "IZQUIERDA":
                if (x > 0) x--;
                break;
            case "DERECHA":
                if (x < ancho - anchoImagen) x++;
                break;
        }

        distanciaRecorrida++;
        if (distanciaRecorrida >= 500) {
            cambiarDireccion();
        }
    }

    /**
     * Método abstracto que define el comportamiento de la pulga al ser impactada.
     * 
     * @return {@code true} si la pulga es eliminada, {@code false} en caso contrario.
     */
    public abstract boolean impactar();

    /**
     * Método abstracto que devuelve el tipo de la pulga.
     * 
     * @return El tipo de la pulga como una cadena.
     */
    public abstract String getTipo();

    // Getters y Setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getResistencia() { return resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }
    public boolean isImpactada() { return impactada; }
    public void setImpactada(boolean impactada) { this.impactada = impactada; }
    public Image getImagen() { return imagen; }
    public String getDireccionActual() { return direccionActual; }
}
