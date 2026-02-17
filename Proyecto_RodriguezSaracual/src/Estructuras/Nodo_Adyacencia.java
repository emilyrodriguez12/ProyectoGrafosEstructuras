/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Daniel
 */
public class Nodo_Adyacencia {
    Nodo_Adyacencia sig;
    Proteina proteina;
    int peso;
    
    public Nodo_Adyacencia(Proteina proteina, int peso){
        this.proteina = proteina;
        this.peso = peso;
        this.sig = null;
    }
}
