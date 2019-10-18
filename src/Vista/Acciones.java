/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestionSupermercado;
import Controlador.Principal;
import Modelo.Reposicion;
import Modelo.Supermercado;
import Modelo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumno
 */
public class Acciones extends javax.swing.JDialog {

    GestionSupermercado con = new GestionSupermercado();
    
    ArrayList<Venta> lisVenta = new ArrayList();
    
    ArrayList<Reposicion> lisRepo = new ArrayList();
    
    DefaultTableModel modelo, modelo1;
    
    private int directorActual;
    
    public Acciones(java.awt.Frame parent, boolean modal, int codDir) throws SQLException {
        super(parent, modal);
        
        initComponents();
        
        modelo = (DefaultTableModel) jTable1.getModel();
        
        modelo1 = (DefaultTableModel) jTable2.getModel();
        
        rellenarTablaVenta(codDir);
        
        rellenarTablaRepo(codDir);
        
        directorActual = codDir;
        
        jLabel1.setText("Actvidades del Director de codigo "+codDir);
    }
    
    
    private void rellenarTablaVenta(int codigo) throws SQLException
    {
        lisVenta = con.crearListaVenta(codigo);
        
        Object vector[];
        
        int i=0; 
        while (i<lisVenta.size())
        {
            vector = obtenerDatos(lisVenta.get(i));
            modelo.addRow(vector);
            i++;
        }
        
        jTable1.setModel(modelo);
        
    }
    
    
    private void rellenarTablaRepo(int codigo) throws SQLException
    {
        lisRepo = con.crearListaRepo(codigo);
        
        Object vector[];
        
        int i=0; 
        while (i<lisRepo.size())
        {
            vector = obtenerDatos(lisRepo.get(i));
            modelo1.addRow(vector);
            i++;
        }
        
        jTable2.setModel(modelo1);
        
    }
            
    private Object[] obtenerDatos(Supermercado objeto)
    {
        Object vector[] = new Object[2];
     
        vector[0] = objeto.getCod_sup();
        
        if (objeto instanceof Venta)
            vector[1] = ( (Venta) objeto).getGanancias();
        else
            vector[1] = ( (Reposicion) objeto).getInversion();
        return vector;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonAtras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        añadirActividad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Venta", "Ganancias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        botonAtras.setText("ATRAS");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Reposicion", "Inversion"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        añadirActividad.setText("Añadir");
        añadirActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActividadActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(añadirActividad)
                        .addGap(130, 130, 130))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 227, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(añadirActividad)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(botonAtras)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void añadirActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActividadActionPerformed
        NuevaActividad p1 = new NuevaActividad(Principal.devolverVentana(), true, directorActual);
        p1.setTitle("Inserción de actividad");
        p1.setVisible(true);

        modelo.setRowCount(0);
        modelo1.setRowCount(0);
        
        try {
            rellenarTablaVenta(directorActual);
        } catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rellenarTablaRepo(directorActual);
        } catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_añadirActividadActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirActividad;
    private javax.swing.JButton botonAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
