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
public class MisilPulgoson extends Arma{
    @Override
    public void disparar(CampoBatalla campo, int x, int y) {
        int radio = 3; // Afecta un área más grande
        List<Pulga> afectadas = campo.getPulgasEnRadio(x, y, radio);
        
        for (Pulga p : afectadas) {
            p.setImpactada(true);
            p.setResistencia(p.getResistencia() - 2); // Quita más resistencia
            if (p.getResistencia() <= 0) {
                campo.eliminarPulga(p);
            }
        }
    }

}
