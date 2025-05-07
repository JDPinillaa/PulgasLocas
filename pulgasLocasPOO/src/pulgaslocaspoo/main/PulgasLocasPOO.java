/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pulgaslocaspoo.main;

import pulgaslocaspoo.views.Mapa;

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
        // Configurar el look and feel de la interfaz gráfica
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo configurar el look and feel: " + e.getMessage());
        }

        // Ejecutar la ventana principal en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            Mapa ventanaPrincipal = new Mapa();
            ventanaPrincipal.setVisible(true);
        });
    }
}
