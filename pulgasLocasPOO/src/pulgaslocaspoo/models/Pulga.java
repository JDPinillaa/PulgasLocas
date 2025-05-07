/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author juand
 */
public abstract class Pulga {
    private int x;
    private int y;
    private int resistencia;
    private boolean impactada;
    protected Image imagen;

    public Pulga(int x, int y, int resistencia) {
        this.x = x;
        this.y = y;
        this.resistencia = resistencia;
    }

    public abstract boolean impactar();
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
    public Image getImagen() {
    return imagen;
}
}
