package View;

import ConnectionFactory.Server;
import Model.bean.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import util.Communication;


public class TipoSelect extends javax.swing.JFrame {

    private Server server = new Server();
    private List<Tipo> tipDAO;
    private Tipo currentTipo;

    public TipoSelect() {
        initComponents();
        readTipos();
    }

    public Tipo getCurrentTipo() {
        return currentTipo;
    }

    public void setCurrentTipo(Tipo currentTipo) {
        this.currentTipo = currentTipo;
    }

    private void readTipos() {
        Communication communication = new Communication("TIPOREAD");
        communication = server.outPut_inPut(communication);
        DefaultTableModel modelo = (DefaultTableModel) tipoTable.getModel();
        modelo.setNumRows(0);
        tipDAO = (ArrayList) communication.getParam("TIPOREADREPLY");
        try {    
        for (Tipo i : tipDAO) {
            modelo.addRow(new Object[]{
                i.getNome(),
                i.getTipo()
            });
        }
        } catch (NullPointerException ex) {}
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
        tipoTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();

        tipoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "nome", "esfera"
            }
        ));
        tipoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tipoTableMouseReleased(evt);
            }
        });
        tipoTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipoTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tipoTable);

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(okButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoTableKeyReleased
        tipoSelect();
    }//GEN-LAST:event_tipoTableKeyReleased

    private void tipoTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoTableMouseReleased
        tipoSelect();
    }//GEN-LAST:event_tipoTableMouseReleased

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        tipoSelect();  
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void tipoSelect() {
        okButton.setEnabled(true);
        setCurrentTipo(tipDAO.get(tipoTable.getSelectedRow()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JTable tipoTable;
    // End of variables declaration//GEN-END:variables
}
