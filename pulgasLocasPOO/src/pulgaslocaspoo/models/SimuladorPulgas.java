/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

import javax.swing.JOptionPane;
import pulgaslocaspoo.utils.ArchivoPuntuacion;
import pulgaslocaspoo.utils.GeneradorPulgas;
import pulgaslocaspoo.utils.HiloMovimientoPulgas;
import pulgaslocaspoo.views.Mapa;
import pulgaslocaspoo.views.PanelCampo;

/**
 * Clase que representa el simulador principal del juego.
 * Controla la lógica del juego, incluyendo la interacción con el campo de batalla,
 * la generación de pulgas, el manejo de eventos del usuario y la actualización
 * de la interfaz gráfica.
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
    private HiloMovimientoPulgas hiloMovimiento;
    private Mapa mapa;

    /**
     * Constructor por defecto del simulador.
     * Inicializa un campo de batalla de 800x600, un generador de pulgas,
     * y carga el puntaje máximo desde el archivo.
     */
    public SimuladorPulgas() {
        campo = new CampoBatalla(800, 600);
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo();
        generador.start();
        // panelCampo debe ser seteado después con setPanelCampo()
    }

    /**
     * Constructor que recibe un campo de batalla.
     * 
     * @param campo El campo de batalla donde se desarrollará la simulación.
     */
    public SimuladorPulgas(CampoBatalla campo) {
        this.campo = campo;
        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo();
        generador.start();
        // panelCampo debe ser seteado después con setPanelCampo()
    }

    /**
     * Constructor que recibe un campo de batalla y un panel de interfaz gráfica.
     * 
     * @param campo El campo de batalla donde se desarrollará la simulación.
     * @param panelCampo El panel gráfico que representa el campo de batalla.
     */
    public SimuladorPulgas(CampoBatalla campo, PanelCampo panelCampo) {
        this.campo = campo;
        this.panelCampo = panelCampo;

        if (panelCampo == null) {
            System.out.println("Error: PanelCampo es null en el constructor de SimuladorPulgas");
        }

        generador = new GeneradorPulgas(campo);
        archivoPuntuacion = new ArchivoPuntuacion();
        puntuacionMaxima = archivoPuntuacion.leerPuntajeMaximo();

        // Iniciar el generador de pulgas
        generador.start();

        // Iniciar el hilo de movimiento de pulgas
        hiloMovimiento = new HiloMovimientoPulgas(campo, panelCampo);
        hiloMovimiento.start();
    }

    /**
     * Maneja las teclas presionadas por el usuario para realizar acciones en el juego.
     * 
     * @param tecla La tecla presionada por el usuario.
     */
    public void manejarTecla(char tecla) {
        switch (tecla) {
            case 'p': 
                campo.agregarPulga(new PulgaNormal());
                if (panelCampo != null) panelCampo.actualizar(); // Fuerza repintado inmediato
                JOptionPane.showMessageDialog(null, "Pulga Normal creada");
                break;
            case 'm': 
                campo.agregarPulga(new PulgaMutante());
                if (panelCampo != null) panelCampo.actualizar();
                JOptionPane.showMessageDialog(null, "Pulga Mutante creada");
                break;
            case 's': 
                campo.actualizarPosiciones();
                if (panelCampo != null) panelCampo.actualizar();
                break;
            case ' ': 
                System.out.println("Tecla de disparo del misil detectada.");
                int mouseX = obtenerCoordenadaMouseX();
                int mouseY = obtenerCoordenadaMouseY();
                new MisilPulgoson().disparar(campo, mouseX, mouseY, this); 
                if (panelCampo != null) panelCampo.actualizar();
                break;
            case 'q': 
                terminarSimulacion(); 
                break;
        }
        verificarFinJuego();
    }

    private int obtenerCoordenadaMouseX() {
        return panelCampo != null ? panelCampo.getMouseX() : 0;
    }

    private int obtenerCoordenadaMouseY() {
        return panelCampo != null ? panelCampo.getMouseY() : 0;
    }

    /**
     * Maneja un clic del usuario en el campo de batalla.
     * 
     * @param x La coordenada X del clic.
     * @param y La coordenada Y del clic.
     */
    public void manejarClic(int x, int y) {
        new PistolaPulguipium().disparar(campo, x, y, this);
    }

    /**
     * Verifica si el juego ha terminado y maneja el reinicio o la finalización.
     */
    private void verificarFinJuego() {
        if (campo.estaVacio()) {
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

    /**
     * Reinicia la simulación, creando un nuevo campo de batalla y reiniciando el generador.
     */
    public void reiniciar() {
        detenerHilos();
        campo = new CampoBatalla(800, 600);
        generador = new GeneradorPulgas(campo);
        puntuacionActual = 0;
        generador.start();
        if (panelCampo != null) {
            hiloMovimiento = new HiloMovimientoPulgas(campo, panelCampo);
            hiloMovimiento.start();
        }
    }

    /**
     * Termina la simulación, deteniendo el generador y guardando el puntaje máximo.
     */
    public void terminarSimulacion() {
        detenerHilos();
        actualizarPuntajeMaximo();
        if (panelCampo != null) {
            java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(panelCampo);
            if (window != null) {
                window.dispose();
            }
        }
        System.exit(0);
    }

    /**
     * Detiene todos los hilos asociados al simulador.
     */
    public void detenerHilos() {
        if (generador != null) generador.detener();
        if (hiloMovimiento != null) hiloMovimiento.detener();
    }

    /**
     * Actualiza el puntaje máximo si el puntaje actual es mayor.
     */
    public void actualizarPuntajeMaximo() {
        if (puntuacionActual > puntuacionMaxima) {
            puntuacionMaxima = puntuacionActual;
            archivoPuntuacion.actualizarPuntajeMaximo(puntuacionMaxima);
            JOptionPane.showMessageDialog(null, "¡Nuevo récord! Has superado el puntaje máximo anterior.");
        }
    }

    /**
     * Incrementa la puntuación actual del jugador.
     * 
     * @param puntos La cantidad de puntos a incrementar.
     */
    public void aumentarPuntuacion(int puntos) { 
        puntuacionActual += puntos; 
        notificarActualizacion(); 
    }

    /**
     * Notifica a la interfaz gráfica que debe actualizarse.
     */
    public void notificarActualizacion() {
        if (panelCampo != null) {
            panelCampo.actualizar();
        }
        if (mapa != null) {
            mapa.actualizarPuntaje();
        }
    }

    // Getters y Setters
    public CampoBatalla getCampoBatalla() { 
        return campo; 
    }

    public int getPuntuacionActual() { 
        return puntuacionActual; 
    }

    public int getPuntuacionMaxima() { 
        return puntuacionMaxima; 
    }

    public PanelCampo getPanelCampo() {
        return panelCampo;
    }

    public void setPanelCampo(PanelCampo panelCampo) {
        this.panelCampo = panelCampo;
        if (hiloMovimiento == null && campo != null && panelCampo != null) {
            hiloMovimiento = new HiloMovimientoPulgas(campo, panelCampo);
            hiloMovimiento.start();
        }
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
