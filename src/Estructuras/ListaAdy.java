/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Nombre: ListaAdy.
 * Descripción general: TDA que gestiona una lista enlazada de nodos de adyacencia para representar las conexiones de una proteína.
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class ListaAdy {
    /**
     * Primer nodo de la lista de adyacencia
     */
    Nodo_Adyacencia pfirst;
    
    /**
     * Cantidad de elementos en la lista
     */
    int tamaño;

    /**
     * Nombre: ListaAdy (Constructor)
     * Descripción general: Inicializa una lista de adyacencia vacía
     * Tipo de retorno: N/A
     */
    public ListaAdy() {
        this.pfirst = null;
        this.tamaño = 0;
    }
    
    
    /**
     * Nombre: insertar
     * Descripción general: Agrega una nueva interacción (proteína y peso) al final de la lista
     * Tipo de retorno: void
     * @param proteina Tipo: Proteina. Descripción: La proteína a insertar
     * @param peso Tipo: int. Descripcion: El valor de la interacción
     */
     public void insertar(Proteina proteina, int peso){
        Nodo_Adyacencia nuevo = new Nodo_Adyacencia(proteina, peso );
        if (this.pfirst==null){
            this.pfirst= nuevo;
        }else{
            Nodo_Adyacencia aux= this.pfirst;
            while(aux.sig!=null){
                aux=aux.sig;
            }
            aux.sig= nuevo;
        }
        tamaño ++;
    }
     
     /**
      * Nombre: eliminar.
     * Descripción general: Remueve una proteína de la lista de adyacencia según su nombre.
     * Tipo de retorno: void.
      * @param proteina Tipo: String. Descripción: Nombre de la proteína a eliminar
      */
     public void eliminar(String proteina){
        if (this.pfirst==null){
            System.out.println("La lista esta vacia");
        }else{
            if(this.pfirst.proteina.nombre.equals(proteina)){
                this.pfirst= this.pfirst.sig;  
            }else{
                Nodo_Adyacencia aux= this.pfirst;
                while(aux.sig!=null && !aux.sig.proteina.nombre.equals(proteina)){
                    aux= aux.sig;
                }
                if (aux.sig !=null){
                 aux.sig= aux.sig.sig;   
                }
            }
            tamaño --;
            }
        }
     
     /**
      * Nombre: buscar
     * Descripción general: Localiza una proteína dentro de la lista de adyacencia
     * Tipo de retorno: Proteina
      * @param proteina Tipo: String. Descripción: Nombre de la proteína buscada
      * @return Descripción: Objeto Proteina si se encuentra, null en caso contrario
      */
     public Proteina buscar(String proteina){
         if (this.pfirst!=  null){
           Nodo_Adyacencia aux= this.pfirst;
           while(aux!=null && !aux.proteina.nombre.equals(proteina)){
               aux= aux.sig;

           }
           if(aux == null){
               return null;
           }
           return aux.proteina;
                 
             }else{
             //System.out.println("la lista esta vacia");
         }
         return null;
         }
     
     /**
      * Nombre: imprimir
     * Descripción general: Genera una cadena con los nombres de todas las proteínas en la lista
     * Tipo de retorno: String
      * @return Descripción: Cadena de texto separada por comas con los nombres de los vecinos
      */
      public String imprimir(){
        if(this.pfirst!=null){
            Nodo_Adyacencia aux= this.pfirst;
            String cadena = "";
            while(aux!=null){
                cadena+= aux.proteina.nombre + ",";
                aux= aux.sig;
            }
            return cadena;
        }else{
            System.out.println("la lista esta vacia");
        }
        return "";
    }
}
