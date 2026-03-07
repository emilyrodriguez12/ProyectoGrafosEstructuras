/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import Estructuras.Grafo;
import javax.swing.JOptionPane;

/**
 * Nombre: Hubs
 * Descripcion general: Interfaz grafica (JFrame) encargada  de visualizar cual 
 * es la proteina con la mayor cantidad de conexiones directas (Hub) dentro del grafo 
 * Tipo de retorno: void (Clase)
 * @author Daniel Saracual
 * @author Emily Rodriguez
 * @version 1.0
 */
public class Hubs extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Hubs.class.getName());
    static Grafo g;
    /**
     * Nombre: Hubs (Constructor) 
     * Descripcion general: Crea e inicializa los componentes de la ventana d
     * e Hubs, recibiendo el grafo con la red de proteinas
     * Tipo de retorno: Hubs (Objeto)
     * @param g Tipo: Grafo. Descripcion: el grafo actual que contiene las proteinas 
     * a evaluar
     */
    public Hubs(Grafo g) {
        initComponents();
        this.setVisible(true);
        this.g = g;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel2.setText("Hubs");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Nodo con mayor conexiones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 280, 120));

        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1060, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nombre: jButton2ActionPerformed 
     * Descripcion general: Evento ejecutado al presionar el boton "Nodo con 
     * mayor conexiones", calcula la proteina central (hub) y muestra
     * su nombre y cantidad de enlaces en el area de texto 
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        this.jTextArea1.setText(g.hubs().nombre + " con "+ g.hubs().adyacentes.tamaño + " enlaces");
        }catch(Exception e){
                        JOptionPane.showMessageDialog(rootPane, "error");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Nombre: jButton3ActionPerformed 
     * Descripcion general: Evento ejecutado al presionar el boton "Regresar", 
     * cierra la ventana actual de Hubs y muestra el Menu principal
     * Tipo de retorno: void
     * @param evt Tipo: java.awt.event.ActionEvent. Descripcion: el evento de 
     * accion generado por el boton
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu(g);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Nombre: main 
     * Descripcion general: Metodo principal que lanza la aplicacion
     * e inicializa el aspecto visual (Look and feel) de la ventana de Hubs
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
        java.awt.EventQueue.invokeLater(() -> new Hubs(g).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
