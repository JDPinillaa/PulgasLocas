/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

/**
 *
 * @author ACER
 */
public class PistolaPulguipium extends Arma {
    @Override
    public void disparar(CampoBatalla campo, int x, int y) {
        for (Pulga pulga : campo.getPulgasEnRadio(x, y, 20)) {
            if (pulga.impactar()) {
                campo.eliminarPulga(pulga);
                // Actualizar puntuación
            }
        }
    }
    
    
}
