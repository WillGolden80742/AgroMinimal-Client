/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectionFactory.Server;
import Model.bean.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Communication;

/**
 *
 * @author will
 */
public class Produtos extends javax.swing.JFrame {

    private List<Produto> produtos = new ArrayList<>();
    private int prodID;
    private DefaultTableModel modelo;
    private Server server = new Server();
    private boolean edited = false;

    public Produtos() {
        initComponents();
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    

    public void readProdutos(int id) {
        Communication communication = new Communication("PRODUTOS");
        prodID = id;
        communication.setParam("propriedadeId", id);
        communication = server.outPut_inPut(communication);
        List<Produto> prodDAO = (List<Produto>) communication.getParam("PRODUTOSREPLY");;
        readProdutos(prodDAO, true);
    }

    private void readProdutos(List<Produto> prods, boolean addVoidRow) {
        modelo = (DefaultTableModel) produtosTable.getModel();
        int count = 0;
        modelo.setNumRows(0);
        for (Produto p : prods) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getProducaoAnual()
            });
            count++;
        }
        if (addVoidRow) {
            Produto produto = new Produto();
            produto.setNome("");
            produto.setProducaoAnual(0.0);
            produtos = prods;
            produtos.add(produto);
            if (count == 0) {
                modelo.setNumRows(1);
            } else {
                modelo.setNumRows(modelo.getRowCount() + 1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        produtosTable = new javax.swing.JTable();
        okButton = new javax.swing.JToggleButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        produtosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "nome", "produção anual (kg)"
            }
        ));
        produtosTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                produtosTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(produtosTable);
        if (produtosTable.getColumnModel().getColumnCount() > 0) {
            produtosTable.getColumnModel().getColumn(0).setResizable(false);
            produtosTable.getColumnModel().getColumn(1).setResizable(false);
        }

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produtosTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_produtosTablePropertyChange
        int row = produtosTable.getSelectedRow();
        if (produtosTable.getSelectedColumn() == 1) {
            try {
                Produto produto = produtos.get(row);
                produto.setProducaoAnual(Double.parseDouble((String) produtosTable.getValueAt(row, 1)));
                produtos.set(row, produto);
            } catch (NumberFormatException ex) {
                produtosTable.setValueAt(produtos.get(row).getProducaoAnual(), row, 1);
            } catch (ArrayIndexOutOfBoundsException | ClassCastException | NullPointerException ex) {
            } catch (IndexOutOfBoundsException ex) {
            }
        } else {
            try {
                produtos.get(row).setNome((String) produtosTable.getValueAt(row, 0));
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
    }//GEN-LAST:event_produtosTablePropertyChange

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            if (!produtosTable.getValueAt(produtosTable.getRowCount() - 1, 0).equals("") && (Double.parseDouble((String) produtosTable.getValueAt(produtosTable.getRowCount() - 1, 1))) > 0.0) {
                modelo.addRow(new Object[]{
                    "",
                    "0.0"
                });
                Produto produto = new Produto();
                produto.setNome("");
                produto.setProducaoAnual(0.0);
                produtos.add(produto);
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        try {
            if (produtosTable.getRowCount() > 1) {
                produtos.remove(produtosTable.getSelectedRow());
                readProdutos(produtos, false);
            } else if (produtosTable.getRowCount() == 1) {
                List<Produto> p = new ArrayList<>();
                readProdutos(p, true);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Selecione produto!");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Communication communication = new Communication("PRODUTOSUPDATE");
        communication.setParam("produtos", produtos);
        communication.setParam("propriedadeId", prodID);
        communication = server.outPut_inPut(communication);
        JOptionPane.showMessageDialog(null, communication.getParam("PRODUTOSUPDATEREPLY"));
        setEdited(true);
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton okButton;
    private javax.swing.JTable produtosTable;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
