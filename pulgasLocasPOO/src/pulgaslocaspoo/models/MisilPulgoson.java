/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pulgaslocaspoo.utils.Reproductor;

/**
 * Clase que representa el arma "MisilPulgoson".
 * Este arma elimina la mitad de las pulgas presentes en el campo de batalla
 * de manera aleatoria y reproduce un sonido de explosión.
 * 
 * @author Santiago Uribe
 * @version 1.0
 * @since 2025-05-07
 */
public class MisilPulgoson extends Arma {

    /**
     * Dispara el misil, eliminando la mitad de las pulgas en el campo de batalla
     * de manera aleatoria. Por cada pulga eliminada, se incrementa la puntuación.
     * 
     * @param campo El campo de batalla donde se encuentran las pulgas.
     * @param x No utilizado en esta implementación.
     * @param y No utilizado en esta implementación.
     * @param simulador El simulador que controla la lógica del juego.
     */
    @Override
    public void disparar(CampoBatalla campo, int x, int y, SimuladorPulgas simulador) {
        Reproductor.reproducirSonido("src/pulgaslocaspoo/resources/explosion.wav");

        // Obtener todas las pulgas en el campo
        List<Pulga> todasLasPulgas = new ArrayList<>(campo.getPulgas());

        // Calcular cuántas pulgas eliminar (la mitad redondeada hacia abajo)
        int cantidadAEliminar = todasLasPulgas.size() / 2;

        // Mezclar la lista para seleccionar pulgas aleatorias
        Collections.shuffle(todasLasPulgas);

        // Eliminar la mitad de las pulgas
        for (int i = 0; i < cantidadAEliminar; i++) {
            Pulga pulga = todasLasPulgas.get(i);
            campo.eliminarPulga(pulga);
            simulador.aumentarPuntuacion(1); // Incrementar puntuación por cada pulga eliminada
        }

        // Redibujar el panel
        simulador.getPanelCampo().actualizar();
    }
}
