/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import java.util.List;
import pulgaslocaspoo.utils.Reproductor;

/**
 * Clase que representa el arma "PistolaPulguipium".
 * Este arma dispara en un área específica del campo de batalla, afectando
 * a la primera pulga que se encuentre dentro del radio de impacto.
 * Reproduce un sonido de disparo al ser utilizada.
 * 
 * @author Santiago Uribe
 * @version 1.0
 * @since 2025-05-07
 */
public class PistolaPulguipium extends Arma {

    /**
     * Dispara la pistola, afectando a la primera pulga dentro del radio de impacto.
     * Si la pulga es eliminada, se incrementa la puntuación y se notifica a la interfaz.
     * 
     * @param campo El campo de batalla donde se encuentran las pulgas.
     * @param x La coordenada X donde se realiza el disparo.
     * @param y La coordenada Y donde se realiza el disparo.
     * @param simulador El simulador que controla la lógica del juego.
     */
    @Override
    public void disparar(CampoBatalla campo, int x, int y, SimuladorPulgas simulador) {
        Reproductor.reproducirSonido("src/pulgaslocaspoo/resources/disparo.wav");

        int radio = 100; // Área de impacto
        List<Pulga> afectadas = campo.getPulgasEnRadio(x, y, radio);

        if (!afectadas.isEmpty()) {
            Pulga objetivo = afectadas.get(0); // Solo afecta a la primera que encuentre
            if (objetivo.impactar()) { // Llama al método impactar de la pulga
                campo.eliminarPulga(objetivo);
                simulador.aumentarPuntuacion(1); // Incrementar puntuación
                simulador.notificarActualizacion(); // Notificar a la interfaz
            }
        }
    }
}
