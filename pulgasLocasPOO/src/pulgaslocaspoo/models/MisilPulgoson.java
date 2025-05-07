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
    public void disparar(CampoBatalla campo, int x, int y, SimuladorPulgas simulador) {
        int radio = 3; // Afecta un área más grande
        List<Pulga> afectadas = campo.getPulgasEnRadio(x, y, radio); // Usar las coordenadas del mouse

        for (Pulga p : afectadas) {
            if (!p.isImpactada()) { // Validar si ya fue impactada
                p.setImpactada(true);
                p.setResistencia(p.getResistencia() - 2); // Quita más resistencia
                if (p.getResistencia() <= 0) {
                    campo.eliminarPulga(p);
                    simulador.aumentarPuntuacion(1); // Incrementar puntuación
                }
            }
        }
    }

}
