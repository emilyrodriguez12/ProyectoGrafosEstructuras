/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Nombre: Proteina
 * Descripcion general: represenra un nodo o vertice que simboliza dentro de la red biologica (grafo)
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class Proteina {
    /**
     * Nombre identificador único de la proteína
     */
    public String nombre;
    
    /**
     * apuntador al siguiente objeto Proteina en la lista global de vértices
     */
    Proteina sig;
    
    /**
     * Estado de exploración del nodo para algoritmos de búsqueda (BFS/DFS)
     */
    boolean visitado;
    
    /**
     * Lista de adyacencia que almacena las interacciones de esta proteína
     */
    ListaAdy adyacentes;
    
    /**
     * Nombre: Proteina (Constructor).
     * Descripción general: Inicializa una nueva proteína con su nombre, estado no visitado y su propia lista de adyacencia
     * Tipo de retorno: N/A.
     * @param name Tipo: String. Descripción: El nombre que identifica a la proteína.
     */
    public Proteina(String name){
        this.nombre = name;
        this.sig = null;
        visitado = false;
        adyacentes = new ListaAdy();
    }
}
