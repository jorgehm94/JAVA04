
package Vista;

import Controlador.GestionDirector;
import Controlador.Principal;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VisualizarDirector extends javax.swing.JPanel {
    
        GestionDirector con =new GestionDirector();
        
        
    public VisualizarDirector() {
        initComponents();
        try {
           
            con.consulta("select * from DIRECTOR;");
            
            con.primero();
            
            if(con.isFirst())
                botonAtras.setEnabled(false);
            
            if(con.isLast())
                botonAdelante.setEnabled(false);
            
            actualizarDatos();
             
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Ha fallado esa consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        botonProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        botonAtras = new javax.swing.JButton();
        botonAdelante = new javax.swing.JButton();
        botonCalcular = new javax.swing.JButton();

        botonProductos.setText("PRODUCTOS");
        botonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CÓDIGO DIRECTOR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("NOMBRE");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adelante.png"))); // NOI18N
        botonAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdelanteActionPerformed(evt);
            }
        });

        botonCalcular.setText("CALCULAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addGap(84, 84, 84)
                        .addComponent(botonCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(botonAdelante)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAtras)
                            .addComponent(botonAdelante))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCalcular)
                        .addGap(53, 53, 53))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductosActionPerformed
        
        Acciones objeto;
        
            try {
                objeto = new Acciones(Principal.devolverVentana(),true, Integer.parseInt(con.devolverColumna(1)));
                
                objeto.setVisible(true);
                objeto.pack();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(VisualizarDirector.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_botonProductosActionPerformed

    private void botonAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdelanteActionPerformed

        try {
            con.avanzar();
            
            if (con.isLast() == false) {
                botonAdelante.setEnabled(true);
            } else {
                botonAdelante.setEnabled(false);
            }
            
            if (con.isFirst()== false) {
                botonAtras.setEnabled(true);
            } else {
                botonAtras.setEnabled(false);
            }
            
            actualizarDatos();
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_botonAdelanteActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        try {
            con.retroceder();
            
            if (con.isLast() == false) {
                botonAdelante.setEnabled(true);
            } else {
                botonAdelante.setEnabled(false);
            }
            
            if (con.isFirst()== false) {
                botonAtras.setEnabled(true);
            } else {
                botonAtras.setEnabled(false);
            }
            
            actualizarDatos();
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_botonAtrasActionPerformed


    private void actualizarDatos()
    {
        try {
            
            jTextField1.setText("" + con.devolverColumna(1));
            jTextField2.setText("" + con.devolverColumna(2));
            
            jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+con.devolverColumna(1)+".jpg")));
            
        } catch (SQLException sQLException) {
        }
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
