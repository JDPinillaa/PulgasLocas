/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import javax.swing.JOptionPane;
import pulgaslocaspoo.utils.ArchivoPuntuacion;
import pulgaslocaspoo.utils.GeneradorPulgas;
import pulgaslocaspoo.views.PanelCampo;

/**
 *
 * @author ACER
 */
public class SimuladorPulgas {
    private CampoBatalla campo;
    private GeneradorPulgas generador;
    private ArchivoPuntuacion archivoPuntuacion;
    private int puntuacionActual;
    private int puntuacionMaxima;
    private PanelCampo panelCampo; // Referencia al PanelCampo

    public SimuladorPulgas() {
        campo = new CampoBatalla(800, 600);
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo(); // Método corregido
        generador.start();
    }

    public SimuladorPulgas(CampoBatalla campo) {
        this.campo = campo;
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo(); // Método corregido
        generador.start();
    }

    public SimuladorPulgas(CampoBatalla campo, PanelCampo panelCampo) {
        this.campo = campo;
        this.panelCampo = panelCampo;
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo();
        generador.start();
    }

    public void manejarTecla(char tecla) {
        switch (tecla) {
            case 'p': 
                campo.agregarPulga(new PulgaNormal());
                JOptionPane.showMessageDialog(null, "Pulga Normal creada");
                break;
            case 'm': 
                campo.agregarPulga(new PulgaMutante());
                JOptionPane.showMessageDialog(null, "Pulga Mutante creada");
                break;
            case 's': 
                campo.actualizarPosiciones();
                break;
            case ' ': 
                // Obtener las coordenadas del mouse (ejemplo: desde la interfaz gráfica)
                int mouseX = obtenerCoordenadaMouseX();
                int mouseY = obtenerCoordenadaMouseY();
                new MisilPulgoson().disparar(campo, mouseX, mouseY, this); 
                break;
            case 'q': 
                terminarSimulacion(); 
                break;
        }
        verificarFinJuego();
    }

    // Métodos para obtener las coordenadas del mouse (implementación dependerá de la interfaz gráfica)
    private int obtenerCoordenadaMouseX() {
        return panelCampo.getMouseX();
    }

    private int obtenerCoordenadaMouseY() {
        return panelCampo.getMouseY();
    }

    public void manejarClic(int x, int y) {
        new PistolaPulguipium().disparar(campo, x, y, this);
    }

    private void verificarFinJuego() {
        if (campo.estaVacio()) {
            // Actualizar puntaje máximo antes de preguntar al usuario
            actualizarPuntajeMaximo();

            int opcion = JOptionPane.showConfirmDialog(null, 
                "¡Has ganado! ¿Reiniciar?", "Fin del juego", 
                JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                reiniciar();
            } else {
                terminarSimulacion();
            }
        }
    }

    public void reiniciar() {
        generador.detener();
        campo = new CampoBatalla(800, 600);
        generador = new GeneradorPulgas(campo);
        puntuacionActual = 0;
        generador.start();
    }

    public void terminarSimulacion() {
        generador.detener();
        actualizarPuntajeMaximo(); // Asegurarse de guardar el puntaje máximo
        System.exit(0);
    }

    private void actualizarPuntajeMaximo() {
        if (puntuacionActual > puntuacionMaxima) {
            puntuacionMaxima = puntuacionActual;
            archivoPuntuacion.actualizarPuntajeMaximo(puntuacionMaxima); // Método corregido
        }
    }

    // Getters
    public CampoBatalla getCampoBatalla() { 
        return campo; 
    }

    public int getPuntuacionActual() { 
        return puntuacionActual; 
    }

    public int getPuntuacionMaxima() { 
        return puntuacionMaxima; 
    }
    
    // Para modificar puntuación
    public void aumentarPuntuacion(int puntos) { 
        puntuacionActual += puntos; 
    }

    public PanelCampo getPanelCampo() {
        return panelCampo;
    }
}
