/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *Clase que representa una red de interaccion proteina-proteina (PPIN)
 * Esta estructura modela los contactos físicos entre proteínas de una bacteria
 * patógena mediante un grafo no dirigido para identificar dianas terapéuticas.
 * @author Daniel Saracual
 * @author Emily Rodriguez
 * @version 1.0
 */
public class Grafo {
    /**
     * Lista de vertices que representan a las proteinas
     */
    Lista_Proteinas vertices;
    /**
     * Contador de proteinas (vertices) registradas
     */
    int numero_nodos;

    /**
     * Nombre: Grafo (Constructor)
     * Descripción General: Inicializa una nueva instancia de proteinas con una lista vacia y un contador en cero
     * Tipo de retorno: N/A (Constructor)
     */
    public Grafo() {
        this.vertices = new Lista_Proteinas();
        this.numero_nodos = 0;
    }
    
    /**
     * Nombre: crearproteina
     * Descripcion general: Crea un nuevo objeto de tipo proteina y lo agrega a la lista de vertices del grafo si este no existe
     * Tipo de retorno: void
     * @param name Tipo: String. Descripcion: el unico nombre que identifica a la proteina 
     */
    public void crearproteina(String name) {
        if (vertices.buscar(name) != null) {
            return;
        }

        Proteina nueva = new Proteina(name);
        vertices.insertar(nueva);
        vertices.tamaño++;

    }
    
    /**
     * Nombre: insertararistas
     * Descripcion general: Establece la relacion del grafo no dirigido entre dos proteinas existentes
     * Tipo de retorno: void
     * @param name1 Tipo: String. Descripcion: Nombre de la primera proteina
     * @param name2 Tipo: String. Descripcion: Nombre de la segunda proteina
     * @param peso Tipo: int. Descripcion: Valor numerico que representa el costo o resistencia de la relacion
     * @see #buscar(java.lang.String) 
     */
    public void insertararistas(String name1, String name2, int peso) {
        if (vertices.buscar(name1) != null && vertices.buscar(name2) != null && vertices.buscar(name2).adyacentes.buscar(name1) == null) {

            Proteina aux = vertices.pfirst;
            Proteina p1 = null;
            Proteina p2 = null;
            while (aux != null) {
                if (aux.nombre.equalsIgnoreCase(name1)) {
                    p1 = aux;

                }
                if (aux.nombre.equalsIgnoreCase(name2)) {
                    p2 = aux;
                }

                if (p1 != null && p2 != null) {
                    break;
                }
                aux = aux.sig;
            }
            p1.adyacentes.insertar(p2, peso);
            p2.adyacentes.insertar(p1, peso);
        }
    }
    /**
     * Nombre: eliminarvertice
     * Descripcion general: elimina una proteina del sistema y remueve todas las referencias de adyacencia en las demas proteinas
     * Tipo de retorno: void
     * @param name Tipo: String. Descripcion: Nombre de la proteina que va a ser eliminada de la red
     */
    public void eliminarvertice(String name) {
        if (vertices.buscar(name) != null) {
            Proteina aux = vertices.pfirst;

            if (vertices.pfirst.nombre.equalsIgnoreCase(name)) {
                vertices.pfirst = vertices.pfirst.sig;
            } else {

                while (aux.sig != null) {
                    if (aux.sig.nombre.equalsIgnoreCase(name)) {
                        aux.sig = aux.sig.sig;
                        break;
                    }
                    aux = aux.sig;
                }
            }
            aux = vertices.pfirst;

            while (aux != null) {
                if (aux.adyacentes.buscar(name) != null) {
                    Nodo_Adyacencia aux2 = aux.adyacentes.pfirst;
                    while (aux2.sig != null) {
                        if (aux2.sig.proteina.nombre.equalsIgnoreCase(name)) {
                            aux2.sig = aux2.sig.sig;
                            break;
                        }
                        aux2 = aux2.sig;

                    }
                }
                aux = aux.sig;
            }
        }

    }

        /**
         * Nombre: buscar
         * Descripcion general: localiza una instancia de proteina dentro del grafo(red)
         * Tipo de retorno: Proteina (objeto)
         * @param name Tipo: String. Descripcion: Nombre de la proteina a buscar
         * @return Descripcion: El objeto proteina correspondiente al nombre, o null en el caso de que no se encuentre en la red
         */
    public Proteina buscar(String name) {
        return vertices.buscar(name);
    }

    /**
     * Nombre: Imprimir
     * Descripcion general: genera una representacion virtual en formato de texto de toda la red de interaccion proteina-proteina.
     * Recorre cada proteina del grafo y concatena sus conexiones (adyacencias) en una cadena esructurada.
     * Tipo de retorno: String
     * @return Descripcion: una cadena de caracteres que contiene la lista de adyacencia completa, 
     * donde cada línea muestra una proteína seguida de sus interacciones mediante el símbolo "-->"
     */
    public String Imprimir() {
        Proteina aux = vertices.pfirst;
        String cadena = "";
        while (aux != null) {
            cadena += "[" + aux.nombre + "]";
            Nodo_Adyacencia aux2 = aux.adyacentes.pfirst;

            while (aux2 != null) {
                cadena += " --> " + aux2.proteina.nombre;
                aux2 = aux2.sig;
            }
            aux = aux.sig;
            cadena += "\n";
        }
        return cadena;
    }
    /**
     * Nombre: hubs
     * Descripcion general: Calcula que proteina posee el mayor numero de conexiones directas
     * Tipo de retorno: Proteina (Objeto)
     * @return Descripcion: la proteina considerada como la diana terapeutica primaria por su alta centralidad
     */
    public Proteina hubs() {
        Proteina aux = vertices.pfirst;
        Proteina mayor = aux;
        int maximo = 0;

        while (aux != null) {
            int contador = 0;
            Nodo_Adyacencia aux2 = aux.adyacentes.pfirst;
            while (aux2 != null) {
                aux2 = aux2.sig;
                contador++;

            }
            if (contador >= maximo) {
                maximo = contador;
                mayor = aux;
            }
            aux = aux.sig;

        }
        return mayor;
    }

    /**
     * Nombre: DFS_rec.
     * Descripción general: Método recursivo que realiza el recorrido en profundidad a partir de una proteína específica. 
     * Marca cada proteína como visitada y la añade al complejo proteico actual para identificar grupos de proteínas que trabajan juntas.
     * Tipo de retorno: ListaAdy (Objeto)
     * @param proteina Tipo: Proteina. Descripcion: la proteina actual desde el cual se continua la exploracion
     * @param recorrido Tipo: ListaAdy. Descripcion: La lista acumuladora que almacena las proteinas pertenecientes al mismo componente conexo
     * @return Descripcion: La lista de adyacencia que contiene a todas las proteinas descubiertas durante la rema de la recursion
     */
    private ListaAdy DFS_rec(Proteina proteina, ListaAdy recorrido) {
        proteina.visitado = true;
        recorrido.insertar(proteina, 0);
        Nodo_Adyacencia aux = proteina.adyacentes.pfirst;

        while (aux != null) {
            if (!aux.proteina.visitado) {
                DFS_rec(aux.proteina, recorrido);
            }
            aux = aux.sig;

        }
        return recorrido;
    }

    /**
     * Nombre: DFS
     * Descripcion general: realiza una busqueda de profundidad para identificar complejos proteicos (componentes conexos)
     * Tipo de retorno: ListaAdy[]
     * @return Descripción: Arreglo de listas donde cada posición contiene un grupo de proteínas interactuantes.
     * @see #DFS_rec(Estructuras.Proteina, Estructuras.ListaAdy) 
     */
    public ListaAdy[] DFS() {
        Proteina aux = this.vertices.pfirst;
        ListaAdy[] recorridos = new ListaAdy[this.numero_nodos];
        int i = 0;
        while (aux != null) {
            if (!aux.visitado) {
                recorridos[i] = this.DFS_rec(aux, new ListaAdy());
                i++;
            }
            aux = aux.sig;

        }

        while (aux != null) {
            aux.visitado = false;
            aux = aux.sig;
        }
        return recorridos;
    }

    /**
     * Nombre: BFS
     * Descripcion general: realiza un recorrido en anchura para identificar todos los componentes conexos del grafo
     * Tipo de retorno: ListaAdy[] (arreglo de listas)
     * @return Descripcion: un arreglo donde cada posicion contiene una lista de proteinas que forman un complejo proteico
     */
    public ListaAdy[] BFS() {
        Cola cola = new Cola();

        ListaAdy[] recorridos = new ListaAdy[this.numero_nodos];
        int i = 0;

        Proteina vertice = this.vertices.pfirst;

        while (vertice != null) {
            if (!vertice.visitado) {
                Proteina aux = vertice;
                aux.visitado = true;

                while (aux != null) {

                    recorridos[i].insertar(aux, 0);
                    Nodo_Adyacencia aux2 = aux.adyacentes.pfirst;
                    while (aux2 != null) {
                        if (!aux2.proteina.visitado) {
                            cola.Encolar(aux2.proteina, 0);
                            aux2.proteina.visitado = true;

                        }
                        aux2 = aux2.sig;

                    }
                    aux = cola.Desencolar().proteina;

                }
                i++;

            }
            vertice = vertice.sig;

        }
        return recorridos;
    }
    
    /**
     * Nombre : Dijkstra
     * Descripcion general: aplica el algoritmo e ruta mas corta para encontrar el camino de menor resistencia o costo entre dos proteinas
     * Tipo de retorno:
     * @param origen Tipo: Proteina. Descripcion: punto de partida de la señal biologica
     * @param destino Tipo: Proteina. Descripcion: proteina objetivo final
     * @return Descripcion: Lista enlazada con la secuencia optima de proteinas para la ruta mas corta.
     */
    public ListaAdy Dijkstra (Proteina origen, Proteina destino){
        
    }

}
