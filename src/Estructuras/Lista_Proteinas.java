/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Nombre: Lista_Proteinas
 * Descripción general: TDA que gestiona una lista enlazada simple de objetos Proteina para representar los vértices del grafo
 * @author Emily Rodriguez
 * @author Daniel Saracual
 * @version 1.0
 */
public class Lista_Proteinas {
    /**
     * Referencia al primer elemento (proteína) de la lista
     */
    Proteina pfirst;
    
    /**
     * Contador total de proteínas almacenadas en la lista
     */
    int tamaño;

    
    /**
     * Nombre: Lista_Proteinas (Constructor)
     * Descripción general: Inicializa la lista de proteínas vacía
     * Tipo de retorno: N/A
     */
    public Lista_Proteinas() {
        this.pfirst = null;
        this.tamaño = 0;
    }

    
    /**
     * Nombre: buscar
     * Descripción general: Localiza una proteína en la lista mediante su nombre
     * Tipo de retorno: Proteina
     * @param proteina Tipo: String. Descripción: Nombre de la proteína a buscar
     * @return Descripción: Objeto Proteina si existe, o null si no se encuentra
     */
    public Proteina buscar(String proteina){
         if (this.pfirst!=  null){
           Proteina aux= this.pfirst;
           while(aux!=null && !aux.nombre.equals(proteina)){
               aux= aux.sig;

           }
           return aux;
                 
             }else{
             //System.out.println("la lista esta vacia");
         }
         return null;
         }
    
    /**
     * Nombre: imprimir
     * Descripción general: Genera una cadena con los nombres de todas las proteínas en la lista global
     * Tipo de retorno: String
     * @return Descripción: Cadena de texto con los nombres de las proteínas separados por comas
     */
    public String imprimir(){
        if(this.pfirst!=null){
            Proteina aux= this.pfirst;
            String cadena = "";
            while(aux!=null){
                cadena+= aux.nombre + ",";
                aux= aux.sig;
            }
            return cadena;
        }else{
            System.out.println("la lista esta vacia");
        }
        return "";
    }
    
    /**
     * Nombre: insertar
     * Descripción general: Agrega un objeto Proteina al final de la lista de vértices
     * Tipo de retorno: void
     * @param proteina Tipo: Proteina. Descripción: El objeto proteína que se desea insertar
     */
    public void insertar(Proteina proteina){
        if (this.pfirst==null){
            this.pfirst= proteina;
        }else{
            Proteina aux= this.pfirst;
            while(aux.sig!=null ){
                aux=aux.sig;
            }
            aux.sig= proteina;
            
        }
        tamaño ++;
    }
    
    /**
     * Nombre: eliminar
     * Descripción general: Remueve una proteína de la lista global según su nombre
     * Tipo de retorno: void
     * @param proteina Tipo: String. Descripción: Nombre de la proteína a eliminar
     */
    public void eliminar(String proteina){
        if (this.pfirst==null){
            System.out.println("La lista esta vacia");
        }else{
            if(this.pfirst.nombre.equals(proteina)){
                this.pfirst= this.pfirst.sig;  
            }else{
                Proteina aux= this.pfirst;
                while(aux.sig!=null && !aux.sig.nombre.equals(proteina)){
                    aux= aux.sig;
                }
                if (aux.sig !=null){
                 aux.sig= aux.sig.sig;   
                }
            }
            tamaño --;
            }
        }
    }
    
    
    
    
    
        
        
   
   

