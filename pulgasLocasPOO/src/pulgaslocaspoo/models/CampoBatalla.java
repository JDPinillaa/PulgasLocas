package pulgaslocaspoo.models;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class CampoBatalla {
    private final int ancho;
    private final int alto;
    private final List<Pulga> pulgas;
    private final Random rand;

    public CampoBatalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pulgas = new CopyOnWriteArrayList<>(); // Lista segura para hilos
        this.rand = new Random();
    }


    /**
     * Agrega una pulga en una posición libre (auto-reintenta hasta encontrar espacio).
     */
    public void agregarPulgaSafe(Pulga pulga) {
        do {
            pulga.setX(rand.nextInt(ancho));
            pulga.setY(rand.nextInt(alto));
        } while (existeColision(pulga));
        
        pulgas.add(pulga);
    }

    /**
     * Elimina una pulga del campo.
     */
    public void eliminarPulga(Pulga pulga) {
        pulgas.remove(pulga);
    }

    /**
     * Obtiene todas las pulgas dentro de un radio específico.
     */
    public List<Pulga> getPulgasEnRadio(int x, int y, int radio) {
        return pulgas.stream()
            .filter(p -> Math.hypot(p.getX() - x, p.getY() - y) <= radio)
            .toList();
    }

    /**
     * Mueve todas las pulgas a posiciones aleatorias (comando 's').
     */
    public void actualizarPosiciones() {
        pulgas.forEach(p -> {
            p.setX(rand.nextInt(ancho));
            p.setY(rand.nextInt(alto));
        });
    }

    
    public boolean estaVacio() {
        return pulgas.isEmpty();
    }

    private boolean existeColision(Pulga pulga) {
        return pulgas.stream().anyMatch(p -> 
            Math.abs(p.getX() - pulga.getX()) < 20 && 
            Math.abs(p.getY() - pulga.getY()) < 20
        );
    }

    
    public List<Pulga> getPulgas() {
        return Collections.unmodifiableList(pulgas);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}