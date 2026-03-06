/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class NodoDijkstra {
    
    public Proteina proteina;
    public int distancia;
    public NodoDijkstra previo;
    public boolean procesado;
    public NodoDijkstra sig;

    public NodoDijkstra(Proteina proteina) {
        this.proteina = proteina;
        this.distancia = Integer.MAX_VALUE;
        this.previo = null;
        this.procesado = false;
        this.sig = null;
    }
    
    
    
}

