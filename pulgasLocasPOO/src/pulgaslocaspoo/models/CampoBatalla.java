package pulgaslocaspoo.models;
import java.util.*;

/**
 * Clase que representa el campo de batalla donde se desarrollan las interacciones
 * entre las pulgas y las armas. Controla la posición de las pulgas y las operaciones
 * relacionadas con ellas.
 * 
 * @author ACER
 */
public class CampoBatalla {
    private final int ancho;
    private final int alto;
    private final List<Pulga> pulgas;
    private final Random rand;

    /**
     * Constructor de la clase CampoBatalla.
     * 
     * @param ancho El ancho del campo de batalla.
     * @param alto El alto del campo de batalla.
     */
    public CampoBatalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pulgas = new ArrayList<>();
        this.rand = new Random();
    }

    /**
     * Agrega una pulga en una posición libre dentro del campo de batalla.
     * Si la posición generada está ocupada, reintenta hasta encontrar un espacio libre.
     * 
     * @param pulga La pulga que se desea agregar.
     */
    public void agregarPulga(Pulga pulga) {
        do {
            pulga.setX(rand.nextInt(ancho));
            pulga.setY(rand.nextInt(alto));
        } while (existeColision(pulga));
        pulgas.add(pulga);
    }

    /**
     * Elimina una pulga del campo de batalla.
     * 
     * @param pulga La pulga que se desea eliminar.
     */
    public void eliminarPulga(Pulga pulga) {
        pulgas.remove(pulga);
    }

    /**
     * Obtiene todas las pulgas dentro de un radio específico desde un punto dado.
     * 
     * @param x La coordenada X del centro del radio.
     * @param y La coordenada Y del centro del radio.
     * @param radio El radio dentro del cual buscar pulgas.
     * @return Una lista de pulgas dentro del radio especificado.
     */
    public List<Pulga> getPulgasEnRadio(int x, int y, int radio) {
        List<Pulga> pulgasEnRadio = new ArrayList<>();
        for (Pulga p : pulgas) {
            double distancia = Math.hypot(p.getX() - x, p.getY() - y);
            if (distancia <= radio) {
                pulgasEnRadio.add(p);
            }
        }
        return pulgasEnRadio;
    }

    /**
     * Mueve todas las pulgas a posiciones aleatorias dentro del campo de batalla.
     */
    public void actualizarPosiciones() {
        pulgas.forEach(p -> {
            p.setX(rand.nextInt(ancho));
            p.setY(rand.nextInt(alto));
        });
    }

    /**
     * Mueve todas las pulgas gradualmente en sus direcciones actuales.
     * Las pulgas cambian de dirección aleatoriamente después de recorrer un radio de 500.
     */
    public void moverPulgasGradualmente() {
        pulgas.forEach(p -> p.mover(ancho, alto));
    }

    /**
     * Verifica si el campo de batalla está vacío (sin pulgas).
     * 
     * @return {@code true} si no hay pulgas en el campo, {@code false} en caso contrario.
     */
    public boolean estaVacio() {
        return pulgas.isEmpty();
    }

    /**
     * Verifica si una pulga colisiona con otra en el campo de batalla.
     * 
     * @param pulga La pulga que se desea verificar.
     * @return {@code true} si existe una colisión, {@code false} en caso contrario.
     */
    private boolean existeColision(Pulga pulga) {
        return pulgas.stream().anyMatch(p -> 
            Math.abs(p.getX() - pulga.getX()) < 20 && 
            Math.abs(p.getY() - pulga.getY()) < 20
        );
    }

    /**
     * Obtiene una lista inmutable de todas las pulgas en el campo de batalla.
     * 
     * @return Una lista inmutable de las pulgas.
     */
    public List<Pulga> getPulgas() {
        return Collections.unmodifiableList(pulgas);
    }

    /**
     * Obtiene el ancho del campo de batalla.
     * 
     * @return El ancho del campo.
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Obtiene el alto del campo de batalla.
     * 
     * @return El alto del campo.
     */
    public int getAlto() {
        return alto;
    }
}