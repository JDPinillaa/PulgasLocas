/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

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

    public SimuladorPulgas() {
        campo = new CampoBatalla(800, 600);
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.cargarMaxima();
        generador.start();
    }

    public void manejarTecla(char tecla) {
        switch (tecla) {
            case 'p': campo.agregarPulgaSafe(new PulgaNormal()); break;
            case 'm': campo.agregarPulgaSafe(new PulgaMutante()); break;
            case 's': campo.actualizarPosiciones(); break;
            case ' ': new MisilPulgoson().disparar(campo, this); break;
            case 'q': terminarSimulacion(); break;
        }
        verificarFinJuego();
    }

    public void manejarClic(int x, int y) {
        new PistolaPulguipium().disparar(campo, x, y, this);
    }

    private void verificarFinJuego() {
        if (campo.estaVacio()) {
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
        if (puntuacionActual > puntuacionMaxima) {
            archivoPuntuacion.guardarMaxima(puntuacionActual);
        }
        System.exit(0);
    }

    // Getters
    public CampoBatalla getCampoBatalla() { return campo; }
    public int getPuntuacionActual() { return puntuacionActual; }
    public int getPuntuacionMaxima() { return puntuacionMaxima; }
    
    // Para modificar puntuación
    public void aumentarPuntuacion(int puntos) { 
        puntuacionActual += puntos; 
    }
}
