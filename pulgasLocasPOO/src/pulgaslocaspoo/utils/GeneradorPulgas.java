/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.utils;

import java.util.Random;
<<<<<<< HEAD:pulgasLocasPOO/src/pulgaslocaspoo/utils/GeneradorPulgas.java
import pulgaslocaspoo.models.CampoBatalla;
import pulgaslocaspoo.models.PulgaMutante;
import pulgaslocaspoo.models.PulgaNormal;

=======
>>>>>>> 8a6defc3d3c6630a219072b609b7f02f630f7875:pulgasLocasPOO/src/pulgaslocaspoo/models/GeneradorPulgas.java
/**
 *
 * @author ACER
 */
public class GeneradorPulgas extends Thread {
    private final CampoBatalla campo;
    private volatile boolean activo = true;
    private final Random rand = new Random();

    public GeneradorPulgas(CampoBatalla campo) {
        this.campo = campo;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(5000); // Pulgas normales cada 5s
                campo.agregarPulga(new PulgaNormal());
                
                Thread.sleep(5000); // Pulgas mutantes cada 10s
                campo.agregarPulga(new PulgaMutante());
            } catch (InterruptedException e) {
                System.out.println("Generador interrumpido");
            }
        }
    }

    public void detener() {
        activo = false;
        interrupt();
    }
    
    
}
