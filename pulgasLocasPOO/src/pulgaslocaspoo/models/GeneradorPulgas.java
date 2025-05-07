/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

/**
 *
 * @author ACER
 */
public class GeneradorPulgas extends Thread {
    private final CampoBatalla campo;
    private boolean activo = true;

    public GeneradorPulgas(CampoBatalla campo) {
        this.campo = campo;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (isActivo()) {
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

    public synchronized void detener() {
        activo = false;
        interrupt(); // Interrumpir el hilo si está en espera
    }

    private synchronized boolean isActivo() {
        return activo;
    }
    
}
