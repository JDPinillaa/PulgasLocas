/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import java.util.List;
import pulgaslocaspoo.utils.Reproductor;

/**
 *
 * @author ACER
 */
public class PistolaPulguipium extends Arma {

    @Override
    public void disparar(CampoBatalla campo, int x, int y, SimuladorPulgas simulador) {
        Reproductor.reproducirSonido("src/pulgaslocaspoo/resources/disparo.wav");

        int radio = 100; //area de impacto 
        List<Pulga> afectadas = campo.getPulgasEnRadio(x, y, radio);

        if (!afectadas.isEmpty()) {
            Pulga objetivo = afectadas.get(0); // Solo afecta a la primera que encuentre
            if (!objetivo.isImpactada()) { // Validar si ya fue impactada
                objetivo.setImpactada(true);
                objetivo.setResistencia(objetivo.getResistencia() - 1); // Menos daño
                if (objetivo.getResistencia() <= 0) {
                    campo.eliminarPulga(objetivo);
                    simulador.aumentarPuntuacion(1); // Incrementar puntuación
                }
            }
        }
    }
}
