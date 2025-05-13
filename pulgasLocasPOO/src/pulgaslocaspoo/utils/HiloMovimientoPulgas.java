/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.utils;

import pulgaslocaspoo.models.CampoBatalla;
import pulgaslocaspoo.views.PanelCampo;

public class HiloMovimientoPulgas extends Thread {
    private final CampoBatalla campo;
    private final PanelCampo panelCampo; // Nueva referencia
    private boolean activo = true;

    /**
     * Constructor del hilo de movimiento de pulgas.
     * 
     * @param campo El campo de batalla donde se encuentran las pulgas.
     * @param panelCampo El panel del campo de batalla para actualizar la interfaz.
     */
    public HiloMovimientoPulgas(CampoBatalla campo, PanelCampo panelCampo) {
        this.campo = campo;
        this.panelCampo = panelCampo;
    }

    /**
     * Método principal del hilo.
     * Llama al método moverPulgasGradualmente del campo de batalla periódicamente.
     */
    @Override
    public void run() {
        while (activo) {
            try {
                // Mover las pulgas gradualmente
                campo.moverPulgasGradualmente();
                if (panelCampo != null) panelCampo.actualizar(); // Repinta tras mover

                // Pausa para controlar la frecuencia de movimiento (por ejemplo, 50 ms)
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Hilo de movimiento interrumpido.");
            }
        }
    }

    /**
     * Detiene el hilo de movimiento de forma segura.
     */
    public void detener() {
        activo = false;
    }
}
