/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Nombre: Cola.
 * Descripción general: Implementa una estructura de datos FIFO para gestionar el orden de exploración en el algoritmo BFS.
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class Cola {
    /**
     * Referencia al primer elemento de la cola
     */
    Nodo_Adyacencia primero;
    
    /**
     * Referencia al último elemento de la cola
     */
    Nodo_Adyacencia ultimo;

    /**
     * Nombre: Cola (Constructor).
     * Descripción general: Inicializa una cola vacía con sus punteros en null.
     * Tipo de retorno: N/A.
     */
    public Cola() {
        this.primero = null;
        this.ultimo = null;
    }
    
    /**
     * Nombre: Encolar
     * Descripción general: Inserta un nuevo nodo al final de la cola
     * Tipo de retorno: void
     * @param proteina Tipo: Proteina. Descripcion: La proteina que se agregará a la cola
     * @param peso Tipo: int. Descripción: El peso asociado a la interacción de dicha proteina a encolar
     */
    public void Encolar(Proteina proteina, int peso){
        Nodo_Adyacencia nuevo = new Nodo_Adyacencia(proteina,peso);
        if(this.primero==null){
            this.primero= nuevo;
            this.ultimo= nuevo;
        }else{
            Nodo_Adyacencia aux= this.ultimo;
            aux.sig=nuevo;
            this.ultimo=nuevo;
  
        }
    }
    
    /**
     * Nombre: Desencolar.
     * Descripción general: Extrae y retorna el primer elemento de la cola siguiendo el principio FIFO.
     * Tipo de retorno: Nodo_Adyacencia (Objeto).
     * @return Descripción: El nodo que se encontraba al frente de la cola, o null si la cola está vacía
     */
    public Nodo_Adyacencia Desencolar(){
        if(this.primero!=null){
            Nodo_Adyacencia nodo =this.primero;
            this.primero=this.primero.sig;
            return nodo;
        }
        return null;
    }
    

}