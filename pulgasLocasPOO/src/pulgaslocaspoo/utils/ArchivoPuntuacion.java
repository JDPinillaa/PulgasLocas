/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.utils;

import java.io.*;

/**
 * Clase encargada de manejar la persistencia del puntaje máximo.
 */
public class ArchivoPuntuacion {
    private static final String ARCHIVO_PUNTAJE = "src/pulgaslocaspoo/utils/puntaje_maximo.txt";

    /**
     * Lee el puntaje máximo almacenado en el archivo.
     * 
     * @return El puntaje máximo, o 0 si no existe el archivo o está vacío.
     */
    public int leerPuntajeMaximo() {
        File archivo = new File(ARCHIVO_PUNTAJE);
        if (!archivo.exists()) {
            return 0; // Si el archivo no existe, el puntaje máximo es 0
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            return (linea != null) ? Integer.parseInt(linea) : 0;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el puntaje máximo: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Actualiza el puntaje máximo en el archivo si el puntaje actual es mayor.
     * 
     * @param puntajeActual El puntaje actual obtenido por el jugador.
     */
    public void actualizarPuntajeMaximo(int puntajeActual) {
        int puntajeMaximo = leerPuntajeMaximo();
        if (puntajeActual > puntajeMaximo) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_PUNTAJE))) {
                bw.write(String.valueOf(puntajeActual));
            } catch (IOException e) {
                System.err.println("Error al actualizar el puntaje máximo: " + e.getMessage());
            }
        }
    }
}
