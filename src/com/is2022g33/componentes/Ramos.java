/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2022g33.componentes;

import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SYSTEM
 */
public class Ramos extends javax.swing.JPanel {
    public String[] ramos = new String[]{
        "Automóvil",
        "Vida",
        "Hogar",
        "Accidentes"
    };
    
    /**
     * Creates new form Ramos
     */
    public Ramos() {
        initComponents();
        updateTable();
    }
    
    private String[][] getTablaInfo() {
        Random rand = new Random();
        int size = ramos.length;//rand.nextInt(30);
        String[][] rows = new String[size][2];
        
        for(int i = 0; i<size; i++)
            rows[i] = new String[]{
                   ramos[i],
                   Integer.toString(rand.nextInt(100))
            };
        
        return rows;
    }

    public void updateTable(){
        DefaultTableModel tableModel = new DefaultTableModel(
                getTablaInfo(),
                new String[]{
                    "Nombre del Ramo", "Pólizas asociadas"
                }
        );
        jTable1.setModel(tableModel);
    } 
    
    public void addRamo(String name) {
        String[] newramos = new String[ramos.length + 1];
        
        System.arraycopy(ramos, 0, newramos, 0, ramos.length);
        
        newramos[ramos.length] = name;
        ramos = newramos;
        
        updateTable();
    }
    
    public void borraRamo(int sel){             
        String[] newramos = new String[ramos.length -1];
        
        System.arraycopy(ramos, 0, newramos, 0, sel);
        System.arraycopy(ramos, sel+1, newramos, sel, ramos.length-sel-1);
        
        ramos = newramos;
        
        updateTable();
    }
    
    public void borraSelectedRamo(){
        int sel = jTable1.getSelectedRow();
        this.borraRamo(sel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
