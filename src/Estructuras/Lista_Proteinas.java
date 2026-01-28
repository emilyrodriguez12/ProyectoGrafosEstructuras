/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author MARYCRIS
 */
public class Lista_Proteinas {
    Proteina pfirst;
    int tamaño;

    public Lista_Proteinas() {
        this.pfirst = null;
        this.tamaño = 0;
    }

    public Proteina buscar(String proteina){
         if (this.pfirst!=  null){
           Proteina aux= this.pfirst;
           while(aux!=null && !aux.nombre.equals(proteina)){
               aux= aux.sig;

           }
           return aux;
                 
             }else{
             System.out.println("la lista esta vacia");
         }
         return null;
         }
    
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
    
    
    
    
    
        
        
   
   

