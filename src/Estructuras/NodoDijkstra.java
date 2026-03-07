/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Nombre: NodoDijkstra.
 * Descripción general: Clase que representa un nodo auxiliar para el algoritmo 
 * de Dijkstra, almacenando el estado de una proteína durante el cálculo.
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class NodoDijkstra {
    /**
     * Objeto proteína asociado a este nodo
     */
    public Proteina proteina;
    
    /**
     * Distancia acumulada desde el nodo origen hasta esta proteína
     */
    public int distancia;
    
    /**
     * Referencia al nodo anterior en la ruta más corta encontrada
     */
    public NodoDijkstra previo;
    
    /**
     * Estado que indica si el nodo ya ha sido evaluado por el algoritmo
     */
    public boolean procesado;
    
    /**
     * Referencia al siguiente nodo en la lista enlazada de Dijkstra
     */
    public NodoDijkstra sig;

    /**
     * Nombre: NodoDijkstra (Constructor)
     * Descripción general: Inicializa un nodo de control para una proteína con 
     * distancia infinita y estado no procesado.
     * Tipo de retorno: N/A
     * @param proteina Tipo: Proteina. Descripción: El objeto proteína que se va a monitorear.
     */
    public NodoDijkstra(Proteina proteina) {
        this.proteina = proteina;
        this.distancia = Integer.MAX_VALUE;
        this.previo = null;
        this.procesado = false;
        this.sig = null;
    }
    
    
    
}

