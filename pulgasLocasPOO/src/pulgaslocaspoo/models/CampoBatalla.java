package pulgaslocaspoo.models;
import java.util.*;


public class CampoBatalla {
    private List<Pulga> pulgas = new ArrayList<>();
    private int ancho;
    private int alto;

    public void agregarPulga(Pulga p) {
        pulgas.add(p);
    }

    public void eliminarPulga(Pulga p) {
        pulgas.remove(p);
    }

    public void actualizarPosiciones() {
        // Actualiza las posiciones de las pulgas
    }

    public List<Pulga> getPulgasEnRadio(int x, int y, int r) {
        List<Pulga> enRadio = new ArrayList<>();
        for (Pulga p : pulgas) {
            int dx = p.getX() - x;
            int dy = p.getY() - y;
            if (Math.sqrt(dx * dx + dy * dy) <= r) {
                enRadio.add(p);
            }
        }
        return enRadio;
    }

    public List<Pulga> getPulgas() {
        return pulgas;
    }
}
