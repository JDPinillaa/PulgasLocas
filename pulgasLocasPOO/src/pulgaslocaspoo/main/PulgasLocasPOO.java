/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pulgaslocaspoo.main;

import pulgaslocaspoo.views.PantallaPrincipal;

/**
 *
 * @author juand
 */
public class PulgasLocasPOO {

    /**
     * Método principal para iniciar la aplicación.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejecutar la ventana principal en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
            pantallaPrincipal.setVisible(true);
        });
    }
}
