/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import java.util.Random;

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
