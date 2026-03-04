/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class Proteina {
    public String nombre;
    Proteina sig;
    boolean visitado;
    ListaAdy adyacentes;
    
    public Proteina(String name){
        this.nombre = name;
        this.sig = null;
        visitado = false;
        adyacentes = new ListaAdy();
    }
}
