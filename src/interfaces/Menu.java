/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import Estructuras.Grafo;
import javax.swing.JOptionPane;

/**
 * Nombre: Menu 
 * Descripcion general: Interfaz grafica principal (JFrame) que sirve como punto 
 * de acceso a las distintas funciones del sistema, tales como 
 * visualizar el grafo, detectar rutas, manejar complejos y gestionar archivos CSV
 * Tipo de retorno: void (Clase)
 * @author Daniel Saracual
 * @author Emily Rodriguez
 */

public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());
    static Grafo g;
    /**
     * Nombre: Menu (Constructor)
     * Descripcion general: Crea e inicializa los componentes de la ventana del 
     * Menu principal, configurando su 
     * visibilidad y almacenando la referencia al grafo 
     * Tipo de retorno: Menu (Objeto)
     * @param g Tipo: Grafo. Descripcion: el grafo actual que gestiona las redes
     * de proteinas
     */
    public Menu(Grafo g) {
        initComponents();
        this.setVisible(true);
        this.g = g;
    }
    
    /**
     * Nombre: dibujarGrafo
     * Descripcion general: Genera y muestra una representacion visual interactiva 
     * del grafo utilizando la libreria GraphStream, recorriendo
     * los vertices y aristas, y asignando colores distintos a cada componente  
     * conexo encontrado mediante BFS
     * Tipo de retorno: void
     */
    private void dibujarGrafo() {
    if (g == null || g.vertices == null || g.vertices.pfirst == null) {
        return;
    }

    System.setProperty("org.graphstream.ui", "swing");
    org.graphstream.graph.Graph graph = new org.graphstream.graph.implementations.SingleGraph("PPIN");
    String stylesheet = "graph { fill-color:#222222; } node { text-size: 15px; text-color:white; }";
    graph.setAttribute("ui.stylesheet", stylesheet);

    Estructuras.Proteina aux = g.vertices.pfirst;
    while (aux != null) {
        graph.addNode(aux.nombre).setAttribute("ui.label", aux.nombre);
        aux = aux.sig;
    }

    aux = g.vertices.pfirst;
    while (aux != null) {
        Estructuras.Nodo_Adyacencia ady = aux.adyacentes.pfirst;
        while (ady != null) {
            String origen = aux.nombre;
            String destino = ady.proteina.nombre;
            String edgeId1 = origen + "-" + destino;
            String edgeId2 = destino + "-" + origen;

            if (graph.getNode(destino) != null && graph.getEdge(edgeId1) == null && graph.getEdge(edgeId2) == null) {
                graph.addEdge(edgeId1, origen, destino, false);
            }
            ady = ady.sig;
        }
        aux = aux.sig;
    }

    Estructuras.ListaAdy[] componentes = g.BFS();
    String[] colores = {"red", "blue", "green", "gold", "purple", "orange", "cyan", "pink"};
    int colorIndex = 0;

    for (Estructuras.ListaAdy componente : componentes) {
        if (componente == null || componente.pfirst == null) {
            continue;
        }
        
        String color = colores[colorIndex % colores.length];
        colorIndex++;
        
        Estructuras.Nodo_Adyacencia nodoComp = componente.pfirst;
        while (nodoComp != null) {
            if (graph.getNode(nodoComp.proteina.nombre) != null) {
                graph.getNode(nodoComp.proteina.nombre).setAttribute("ui.style", "fill-color: " + color + ";");
            }
            nodoComp = nodoComp.sig;
        }
    }

    org.graphstream.ui.view.Viewer viewer = new org.graphstream.ui.swing_viewer.SwingViewer(graph, org.graphstream.ui.view.Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    viewer.enableAutoLayout();
    org.graphstream.ui.swing_viewer.ViewPanel viewPanel = (org.graphstream.ui.swing_viewer.ViewPanel) viewer.addDefaultView(false);

    javax.swing.JFrame ventanaGrafo = new javax.swing.JFrame("Red de Interacción Proteína-Proteína");
    ventanaGrafo.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    ventanaGrafo.setSize(800, 600);
    ventanaGrafo.setLayout(new java.awt.BorderLayout());
    ventanaGrafo.add(viewPanel, java.awt.BorderLayout.CENTER);
    ventanaGrafo.setLocationRelativeTo(null);
    ventanaGrafo.setVisible(true);
}
    /**
     * Nombre: abrirSelectorArchivo 
     * Descripcion general: Despliega una ventana de explorador de archivos para 
     * que el usuario seleccione un archivo CSV  el cual sera leido para cargar sus
     * datos al grafo
     * Tipo de retorno: void
     */
    public void abrirSelectorArchivo() {
    javax.swing.JFileChooser selector = new javax.swing.JFileChooser();
    
    javax.swing.filechooser.FileNameExtensionFilter filtro = 
        new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
    selector.setFileFilter(filtro);

    int resultado = selector.showOpenDialog(this);

    if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoSeleccionado = selector.getSelectedFile();
        g.leerArchivo(archivoSeleccionado);
    }
    
}   /**
     * Nombre: abrirSelectorGuardar
     * Descripcion general: Despliega una ventana de explorador de archivos para 
     * elegir la ruta y nombre con el cual se exportaran o guardaran los datos 
     * actuales del grafo en formato CSV
     * Tipo de retorno: void
     */
    public void abrirSelectorGuardar() {
    javax.swing.JFileChooser selector = new javax.swing.JFileChooser();
    
    javax.swing.filechooser.FileNameExtensionFilter filtro = 
        new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
    selector.setFileFilter(filtro);

    int resultado = selector.showSaveDialog(this);

    if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoSeleccionado = selector.getSelectedFile();
        
        String ruta = archivoSeleccionado.getAbsolutePath();
        if (!ruta.toLowerCase().endsWith(".csv")) {
            archivoSeleccionado = new java.io.File(ruta + ".csv");
        }
        
        g.guardarArchivo(archivoSeleccionado);
    }

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setText("Menú");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Modificar grafo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 220, 60));

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Mostrar grafo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 200, 60));

        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Deteccion de complejos proteicos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, -1, -1));

        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setText("Encontrar ruta corta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        jButton5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton5.setText("Hubs");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        jButton6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton6.setText("Leer CSV");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        jButton7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton7.setText("Guardar cambios");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nombre: jButton1ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Modificar grafo", cierra el menu 
     * correspondiente para realizar modificaciones en el grafo
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de
     * accion generado por el boton
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ModificarGrafos m = new ModificarGrafos(g);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Nombre: jButton2ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Mostrar grafo", invoca 
     * el metodo dibujarGrafo para lanzar la visualizacion con GraphStream 
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de
     * accion generado por el boton
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dibujarGrafo();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Nombre: jButton5ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Hubs", cierra el Menu
     * actual y abre la ventana encargada de identificar nodos centrales en el grafo 
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Hubs s = new Hubs(g);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Nombre: jButton4ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Encontrar ruta corta", 
     * cierra el Menu y abre la ventana para  calcular el camino mas corto entre dos proteinas 
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        RutaCorta r = new RutaCorta(g);
        this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Nombre: jButton3ActionPerformed
     * Descripcion general: Evento al presionar el boton "Deteccion de complejos proteicos",
     * cierra el Menu y abre la ventana de recorridos BFS y DFS 
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DetecciónDeComplejosProteicos d = new DetecciónDeComplejosProteicos(g);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Nombre: jButton6ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Leer CSV", lanza el 
     * selector de archivos para cargar datos  y muestra un mensaje de exito al 
     * terminar
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.abrirSelectorArchivo();
        JOptionPane.showMessageDialog(rootPane, "cargado con éxito");
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Nombre: jButton7ActionPerformed 
     * Descripcion general: Evento al presionar el boton "Guardar", lanza el 
     * selector de archivos para guardar el estado de la red
     * Tipo de retorno: void
     * @param evt Tipo java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.abrirSelectorGuardar();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * Nombre: main 
     * Descripcion general: Metodo principal que lanza la aplicacion e 
     * inicializa el aspecto visual (Look and feel) de la ventana del Menu
     * Tipo de retorno: void
     * @param args Tipo: String. Descripcion: argumentos de linea de comandos 
     * enviados al ejecutar
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new Menu(g).setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
