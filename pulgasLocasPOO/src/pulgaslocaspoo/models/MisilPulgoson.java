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
 *
 * @author ACER
 */
public class MisilPulgoson extends Arma{
    
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
