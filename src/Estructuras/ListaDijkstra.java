/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Nombre: ListaDijkstra
 * Descripcion general: Clase que gestiona una lista enlazada de nodos auxiliares 
 * para el cálculo de rutas mínimas mediante el algoritmo de Dijkstra.
 * @author Daniel Saracual
 * @author Emily Rodriguez
 * @version 1.0
 */
public class ListaDijkstra {
    
    /**
     * Referencia al primer nodo de la lista de Dijkstra
     */
    public NodoDijkstra pfirst;

    /**
     * Nombre: ListaDijkstra (Constructor)
     * Descripción general: Inicializa una lista de Dijkstra vacía
     * Tipo de retorno: N/A
     */
    public ListaDijkstra() {
        this.pfirst = null;
    }
    
    /**
     * Nombre: insertar
     * Descripción general: Agrega un nuevo nodo de control a la lista a partir 
     * de una proteína para el seguimiento del algoritmo.
     * Tipo de retorno: void
     * @param p Tipo: Proteina. Descripción: El objeto proteína que se desea registrar.
     */
    public void insertar(Proteina p) {
        NodoDijkstra nuevo = new NodoDijkstra(p);
        nuevo.sig = this.pfirst;
        this.pfirst = nuevo;
    }
    
    /**
     * Nombre: buscar
     * Descripción general: Localiza el nodo de control que corresponde a una 
     * proteína específica en la lista.
     * Tipo de retorno: NodoDijkstra
     * @param p Tipo: Proteina. Descripción: La proteína de referencia para la búsqueda.
     * @return Descripción: Objeto NodoDijkstra si se encuentra, null en caso contrario.
     */
    public NodoDijkstra buscar (Proteina p){
        NodoDijkstra aux= pfirst;
        while(aux!=null){
            if(aux.proteina==p){
                return aux;
            }
            aux= aux.sig;
        }
        return null;
    }
    
/**
     * Nombre: ObtenerMinimoNoProcesado
     * Descripción general: Identifica el nodo con la distancia acumulada más baja 
     * que aún no ha sido marcado como procesado.
     * Tipo de retorno: NodoDijkstra
     * @return Descripción: El nodo con el peso mínimo encontrado o null si no hay disponibles.
     */
    
    public NodoDijkstra ObtenerMinimoNoProcesado(){
        NodoDijkstra aux= pfirst;
        NodoDijkstra minimo= null;
        int minVal= Integer.MAX_VALUE;
        
        while(aux!=null){
            if(!aux.procesado && aux.distancia < minVal){
                minVal = aux.distancia;
                minimo= aux;
            }
            aux=aux.sig;
        }
        return minimo;
    }
    
    
    
}

