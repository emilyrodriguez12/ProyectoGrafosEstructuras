/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Daniel
 */
public class Grafo {
    Lista_Proteinas vertices;
    
    
    public Grafo(){
        this.vertices = new Lista_Proteinas();
    }
    
    public void crearproteina(String name){
        if(vertices.buscar(name)!= null){
            return;
        }
        
        Proteina nueva = new Proteina(name);
        vertices.insertar(nueva);
        vertices.tamaño++;
        
        
    }
    
    public void insertararistas(String name1, String name2, int peso){
        if(vertices.buscar(name1)!= null  && vertices.buscar(name2) != null && vertices.buscar(name2).adyacentes.buscar(name1) == null){
            
            Proteina aux = vertices.pfirst;
            Proteina p1 = null;
            Proteina p2 = null;
            while(aux!=null){
                if(aux.nombre.equalsIgnoreCase(name1)){
                    p1= aux;
                   
                }
                if( aux.nombre.equalsIgnoreCase(name2)){
                    p2= aux;
                }
                
                if( p1!= null && p2!= null){
                    break;
                }
                aux= aux.sig;
            }
            p1.adyacentes.insertar(p2, peso);
            p2.adyacentes.insertar(p1, peso);
        }
    }
}
