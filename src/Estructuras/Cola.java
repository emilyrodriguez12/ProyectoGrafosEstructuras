/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class Cola {
    Nodo_Adyacencia primero;
    Nodo_Adyacencia ultimo;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
    }
    
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
    
    
    public Nodo_Adyacencia Desencolar(){
        if(this.primero!=null){
            Nodo_Adyacencia nodo =this.primero;
            this.primero=this.primero.sig;
            return nodo;
        }
        return null;
    }
    

}