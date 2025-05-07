/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.utils;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author juand
 */
public class Reproductor {
    
    /**
     * Reproduce un archivo de sonido dado.
     * 
     * @param rutaArchivo Ruta del archivo de sonido (debe ser un archivo .wav).
     */
    public static void reproducirSonido(String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            if (!archivoSonido.exists()) {
                System.err.println("Archivo de sonido no encontrado: " + rutaArchivo);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }
}
