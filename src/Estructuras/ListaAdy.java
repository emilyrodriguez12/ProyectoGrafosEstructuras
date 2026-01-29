/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class ListaAdy {
    Nodo_Adyacencia pfirst;
    int tamaño;

    public ListaAdy() {
        this.pfirst = null;
        this.tamaño = 0;
    }
    
    
    
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
     
     public Proteina buscar(String proteina){
         if (this.pfirst!=  null){
           Nodo_Adyacencia aux= this.pfirst;
           while(aux!=null && !aux.proteina.nombre.equals(proteina)){
               aux= aux.sig;

           }
           return aux.proteina;
                 
             }else{
             System.out.println("la lista esta vacia");
         }
         return null;
         }
     
     
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
