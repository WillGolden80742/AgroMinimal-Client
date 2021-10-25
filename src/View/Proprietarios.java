/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectionFactory.Server;
import Model.bean.Propriedade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import util.Communication;

/**
 *
 * @author will
 */
public class Proprietarios extends javax.swing.JFrame {

    private Server server = new Server();
    private Adress adress;
    private List<Propriedade> propriedades;
    private Propriedade currentPropriedade = new Propriedade();

    public Proprietarios() {
        initComponents();
        setTable();
        setLocation(400, 100);
        new Thread(readTableProprietarios).start();
    }

    private void setTable() {
        DefaultTableModel modelo = (DefaultTableModel) propriedadeTable.getModel();
        modelo.setNumRows(1);
    }

    private final Runnable readTableProprietarios = new Runnable() {
        @Override
        public void run() {
            DefaultTableModel modelo = (DefaultTableModel) propriedadesTable.getModel();
            modelo.setNumRows(0);
            Communication communication = new Communication("PROPRIEDADES");
            communication = server.outPut_inPut(communication);
            List<Propriedade> propDAO = (ArrayList<Propriedade>) communication.getParam("PROPRIEDADESREPLY");
            for (Propriedade p : propDAO) {
                modelo.addRow(new Object[]{
                    p.getCpnj(),
                    p.getNome()
                });
            }
            propriedades = new ArrayList<>();
            for (Propriedade p : propDAO) {
                propriedades.add(p);
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        propriedadesTable = new javax.swing.JTable();
        nivel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscarCidade = new javax.swing.JButton();
        produtos = new javax.swing.JLabel();
        prodButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nomePropriedade = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        propriedadeTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        produtos1 = new javax.swing.JLabel();
        prodAnualLabel = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        apagar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        propriedadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CNPJ", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        propriedadesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                propriedadesTableMouseReleased(evt);
            }
        });
        propriedadesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                propriedadesTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(propriedadesTable);
        if (propriedadesTable.getColumnModel().getColumnCount() > 0) {
            propriedadesTable.getColumnModel().getColumn(0).setResizable(false);
            propriedadesTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jPanel1ComponentRemoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText("Nome :");

        buscarCidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buscarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cityAdd.png"))); // NOI18N
        buscarCidade.setText("Selecione Endereço");
        buscarCidade.setToolTipText("");
        buscarCidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buscarCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCidadeActionPerformed(evt);
            }
        });

        produtos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        produtos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produtos.setText("Produtos : ");

        prodButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eye.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText("Local : ");

        nomePropriedade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nomePropriedade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nomePropriedade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePropriedadeActionPerformed(evt);
            }
        });

        propriedadeTable.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        propriedadeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mercado", "Empregados", "Máquinas ", "Nível Automação"
            }
        ));
        jScrollPane2.setViewportView(propriedadeTable);

        produtos1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        produtos1.setText("Prod. anual : ");

        prodAnualLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        prodAnualLabel.setText("29 kg");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomePropriedade))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(produtos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prodButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(prodAnualLabel))))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtos1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomePropriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prodAnualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        nivel.addTab("Nível 1", jPanel1);
        nivel.addTab("Nível 2", jTabbedPane2);
        nivel.addTab("Nível 3", jTabbedPane3);

        apagar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        apagar.setText("APAGAR");
        apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        apagar.setName(""); // NOI18N
        apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarActionPerformed(evt);
            }
        });

        salvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        salvar.setText("SALVAR");
        salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salvar.setName(""); // NOI18N
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setText("");
        jFormattedTextField1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("CNPJ :");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Nome : ");

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edite.png"))); // NOI18N
        editar.setText(" EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        novo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tratoIconSmall.png"))); // NOI18N
        novo.setText("NOVO");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apagar)
                .addContainerGap())
            .addComponent(nivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editar)))
                .addGap(5, 5, 5))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salvar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(apagar)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jFormattedTextField1, jLabel2, jLabel4, jTextField1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCidadeActionPerformed
        adress = new Adress();
        try {
            adress.endereco(currentPropriedade.getEndereco().getEndereco());
        } catch (NullPointerException ex) {
        }
        adress.setVisible(true);
    }//GEN-LAST:event_buscarCidadeActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
//        delete();
    }//GEN-LAST:event_apagarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
//        if (getValidation () == true ) {
//            if (salvarStatus == 1) {
//                create ();
//            } else if (salvarStatus == 2) {
//                update();
//            }
//            this.salvarStatus = 0;
//        }
    }//GEN-LAST:event_salvarActionPerformed

    private void jPanel1ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel1ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentRemoved

    private void nomePropriedadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePropriedadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePropriedadeActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
//        setValue();
//        elementsEnabled(true);
//        updateState = true;
//        statusExame.setText("");
//        this.salvarStatus = 2;
    }//GEN-LAST:event_editarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
//        clear();
//        elementsEnabled(true);
//        toggleElements(novo,false);
//        pacienteTable.clearSelection();
//        statusExame.setText("");
//        this.salvarStatus = 1;
    }//GEN-LAST:event_novoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(readTableProprietarios).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void propriedadesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propriedadesTableMouseReleased
        proprietarioSelected();
    }//GEN-LAST:event_propriedadesTableMouseReleased

    private void propriedadesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_propriedadesTableKeyReleased
        proprietarioSelected();
    }//GEN-LAST:event_propriedadesTableKeyReleased

    private void proprietarioSelected() {
        Communication communication = new Communication("PROPRIEDADESELECTED");
        communication.setParam("propriedadeId", propriedades.get(propriedadesTable.getSelectedRow()).getPropriedadeId());
        communication = server.outPut_inPut(communication);
        currentPropriedade = (Propriedade) communication.getParam("PROPRIEDADESELECTEDREPLY");

        DefaultTableModel modelo = (DefaultTableModel) propriedadeTable.getModel();
        modelo.setNumRows(0);
        nomePropriedade.setText(currentPropriedade.getNome());
        try {
            buscarCidade.setText(currentPropriedade.getEndereco().getEndereco());
            buscarCidade.setToolTipText(currentPropriedade.getEndereco().getEndereco());
        } catch (NullPointerException ex) {
            buscarCidade.setText("Selecione Endereço");
            buscarCidade.setToolTipText("Selecione Endereço");
        }
        int destino = currentPropriedade.getDestino();
        String mercado = "";
        switch (destino) {
            case 1:
                mercado = "interno";
                break;
            case 0:
                mercado = "externo";
                break;
        }

        modelo.addRow(new Object[]{
            mercado,
            currentPropriedade.getNumeroEmpregados(),
            currentPropriedade.getMaquinas(),
            currentPropriedade.getNivelAutomacao()
        });

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apagar;
    private javax.swing.JButton buscarCidade;
    private javax.swing.JButton editar;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTabbedPane nivel;
    private javax.swing.JTextField nomePropriedade;
    private javax.swing.JButton novo;
    private javax.swing.JTextField prodAnualLabel;
    private javax.swing.JButton prodButton;
    private javax.swing.JLabel produtos;
    private javax.swing.JLabel produtos1;
    private javax.swing.JTable propriedadeTable;
    private javax.swing.JTable propriedadesTable;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
