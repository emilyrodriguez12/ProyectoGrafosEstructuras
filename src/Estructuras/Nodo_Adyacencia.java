/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Nombre: Nodo_Adyacencia
 * Descripcion general: representa un enlace o arista en la lista de adyacencia del grafo. 
 * Almacena la proteina vecina y el peso de la interaccion entre ellas
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class Nodo_Adyacencia {
    /**
     * Apuntador al siguiente nodo de la lista de adyacencia
     */
    Nodo_Adyacencia sig;
    /**
     * referencia a la proteina con la que se tiene la interaccion
     */
    Proteina proteina;
    /**
     * valor numerico que representa el peso o costo de la arista
     */
    int peso;
    
    /**
     * Nombre: Nodo_Adyacencia (Constructor)
     * Descripcion general: crea un nuevo nodo de adyacencia vinculando una proteina y un peso
     * Tipo de retorno: N/A 
     * @param proteina Tipo: Proteina. Descripcion. Objeto proteina que será el destino de la arista
     * @param peso Tipo: int. Descripción: El costo o valor de la interacción entre proteínas.
     */
    public Nodo_Adyacencia(Proteina proteina, int peso){
        this.proteina = proteina;
        this.peso = peso;
        this.sig = null;
    }
}
