/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class ListaDijkstra {
    
    public NodoDijkstra pfirst;

    public ListaDijkstra() {
        this.pfirst = null;
    }
    
    public void insertar(Proteina p) {
        NodoDijkstra nuevo = new NodoDijkstra(p);
        nuevo.sig = this.pfirst;
        this.pfirst = nuevo;
    }
    
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

