/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pulgaslocaspoo.models;

/**
 *
 * @author ACER
 */
public class MisilPulgoson extends Arma{
    @Override
    public void disparar(CampoBatalla campo, int x, int y) {
        var pulgas = campo.getPulgas();
        int totalEliminar = pulgas.size() / 2;
        Collections.shuffle(pulgas);
        for (int i = 0; i < totalEliminar; i++) {
            campo.eliminarPulga(pulgas.get(i));
        }
    }
    
}
