/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import java.util.List;

/**
 *
 * @author ACER
 */
public class PistolaPulguipium extends Arma {
    @Override
    public void disparar(CampoBatalla campo, int x, int y) {
        int radio = 1; // Precisión cercana
        List<Pulga> afectadas = campo.getPulgasEnRadio(x, y, radio);
        
        if (!afectadas.isEmpty()) {
            Pulga objetivo = afectadas.get(0); // Solo afecta a la primera que encuentre
            objetivo.impactada = true;
            objetivo.resistencia -= 1; // Menos daño
            if (objetivo.resistencia <= 0) {
                campo.eliminarPulga(objetivo);
            }
        }
    }
 
    
}
