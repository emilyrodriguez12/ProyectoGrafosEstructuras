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
    int numero_nodos;

    public Grafo() {
        this.vertices = new Lista_Proteinas();
        this.numero_nodos = 0;
    }

    public void crearproteina(String name) {
        if (vertices.buscar(name) != null) {
            return;
        }

        Proteina nueva = new Proteina(name);
        vertices.insertar(nueva);
        vertices.tamaño++;

    }

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

    public Proteina buscar(String name) {
        return vertices.buscar(name);
    }

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

}
