/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ConnectionFactory.Server;
import Model.bean.Agrotoxico;
import Model.bean.Authenticated;
import Model.bean.Imposto;
import Model.bean.Propriedade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Communication;

/**
 *
 * @author will
 */
public class Propriedades extends javax.swing.JFrame {

    private Server server = new Server();
    private CNPJ cnpj;
    private Adress adress;
    private DefaultTableModel agroModelo;
    private List<Propriedade> propriedades;
    private List<Imposto> impostos;
    private List<Agrotoxico> agrotoxicos;
    private List<Agrotoxico> agrotoxicosTotais;
    private Propriedade currentPropriedade = new Propriedade();
    private String CPNJDefault = "   .   .   /    -  ";
    private int actionCrud = 0;
    private TipoSelect tipoSelect = new TipoSelect();

    public Propriedades() {
        initComponents();
        setLocation(400, 100);
        new Thread(readTables).start();
        toggleFields(false);
    }

    private final Runnable readAgroList = new Runnable() {
        @Override
        public void run() {
            Communication communication = new Communication("AGROLIST");
            communication = server.outPut_inPut(communication);
            List<Agrotoxico> impDAO = (ArrayList) communication.getParam("AGROLISTREPLY");
            for (Agrotoxico i : impDAO) {
                agroComboBox.addItem(i.getNome() + " Ingrediente : " + i.getIngrediente());
            }
            agrotoxicosTotais = impDAO;
        }
    };

    private void toggleFields(boolean b) {
        buscarCidade.setEnabled(b);
        nomePropriedade.setEditable(b);
        prodAnualLabel.setEditable(b);
        destinoComboBox.setEnabled(b);
        empregadoSpinner.setEnabled(b);
        nivelSpinner.setEnabled(b);
        maquinasSpinner.setEnabled(b);
        salvar.setEnabled(b);
        agroComboBox.setEnabled(b);
        addButton.setEnabled(b);
        removeButton.setEnabled(b);
        impostoTable.setEnabled(b);
        apagar.setEnabled(b);
        pagoRadioButton.setEnabled(b);
    }

    private final Runnable readTables = new Runnable() {
        @Override
        public void run() {
            DefaultTableModel modelo = null;
            Communication communication = new Communication("PROPRIEDADES");
            if (!nomeTextField.getText().equals("")) {
                communication.setParam("nome", nomeTextField.getText());
            } else {
                communication.setParam("nome", "");
            }
            if (!CPNJFormattedTextField.getText().equals(CPNJDefault)) {
                communication.setParam("cnpj", CPNJFormattedTextField.getText());
            } else {
                communication.setParam("cnpj", "");
            }
            communication = server.outPut_inPut(communication);
            readPropriedades(communication, modelo);
            toggleFields(false);
            new Thread(readAgroList).start();
        }
    };

    private void readPropriedades(Communication communication, DefaultTableModel modelo) {
        modelo = (DefaultTableModel) propriedadesTable.getModel();
        modelo.setNumRows(0);
        List<Propriedade> propDAO = (ArrayList) communication.getParam("PROPRIEDADESREPLY");
        for (Propriedade p : propDAO) {
            modelo.addRow(new Object[]{
                p.getCpnj(),
                p.getNome()
            });
        }
        propriedades = propDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        propriedadesTable = new javax.swing.JTable();
        nivel = new javax.swing.JTabbedPane();
        detalhesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscarCidade = new javax.swing.JButton();
        produtos = new javax.swing.JLabel();
        prodButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nomePropriedade = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        produtos1 = new javax.swing.JLabel();
        prodAnualLabel = new javax.swing.JTextField();
        nivelSpinner = new javax.swing.JSpinner();
        empregadoSpinner = new javax.swing.JSpinner();
        maquinasSpinner = new javax.swing.JSpinner();
        destinoComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        impostoPanel = new javax.swing.JPanel();
        impostoTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        impostoTable = new javax.swing.JTable();
        pagoRadioButton = new javax.swing.JRadioButton();
        editNomeButton = new javax.swing.JButton();
        agrotoxicosPanel = new javax.swing.JPanel();
        removeButton = new javax.swing.JToggleButton();
        addButton = new javax.swing.JButton();
        agroComboBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        agroTable = new javax.swing.JTable();
        apagar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        CPNJFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        searchPropriedades = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        clearSearch = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        editMenuItem = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        detalhesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                detalhesPanelMousePressed(evt);
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

        produtos1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        produtos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        produtos1.setText("Prod. anual : ");

        prodAnualLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        prodAnualLabel.setText("29 kg");

        destinoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "interno", "externo" }));

        jLabel5.setText("Mercado : ");

        jLabel6.setText("Empregados : ");

        jLabel7.setText("Maquinas :");

        jLabel8.setText("Nivel automação : ");

        javax.swing.GroupLayout detalhesPanelLayout = new javax.swing.GroupLayout(detalhesPanel);
        detalhesPanel.setLayout(detalhesPanelLayout);
        detalhesPanelLayout.setHorizontalGroup(
            detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detalhesPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomePropriedade))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
            .addGroup(detalhesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detalhesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prodAnualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detalhesPanelLayout.createSequentialGroup()
                        .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destinoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(empregadoSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maquinasSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nivelSpinner))))
                .addGap(5, 5, 5))
        );
        detalhesPanelLayout.setVerticalGroup(
            detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalhesPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(produtos1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prodAnualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomePropriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detalhesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empregadoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maquinasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        detalhesPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8, maquinasSpinner});

        nivel.addTab("Nível 1", detalhesPanel);

        impostoTotalLabel.setText("Total : ");

        impostoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Valor R$", "Valor líquido R$", "Subsídio %", "Nome", "Esfera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        impostoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                impostoTableMouseReleased(evt);
            }
        });
        impostoTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                impostoTablePropertyChange(evt);
            }
        });
        impostoTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                impostoTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(impostoTable);

        pagoRadioButton.setText("Pago");
        pagoRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagoRadioButtonMouseClicked(evt);
            }
        });

        editNomeButton.setText("Editar nome");
        editNomeButton.setEnabled(false);
        editNomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout impostoPanelLayout = new javax.swing.GroupLayout(impostoPanel);
        impostoPanel.setLayout(impostoPanelLayout);
        impostoPanelLayout.setHorizontalGroup(
            impostoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            .addGroup(impostoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(impostoTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editNomeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagoRadioButton)
                .addContainerGap())
        );
        impostoPanelLayout.setVerticalGroup(
            impostoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, impostoPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(impostoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(impostoTotalLabel)
                    .addGroup(impostoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editNomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pagoRadioButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        nivel.addTab("Nível 2", impostoPanel);

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        agroComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Agrotoxico" }));

        agroTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "nome", "ativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        agroTable.setEnabled(false);
        jScrollPane3.setViewportView(agroTable);

        javax.swing.GroupLayout agrotoxicosPanelLayout = new javax.swing.GroupLayout(agrotoxicosPanel);
        agrotoxicosPanel.setLayout(agrotoxicosPanelLayout);
        agrotoxicosPanelLayout.setHorizontalGroup(
            agrotoxicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agrotoxicosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(agrotoxicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(agrotoxicosPanelLayout.createSequentialGroup()
                        .addComponent(agroComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addContainerGap())
        );
        agrotoxicosPanelLayout.setVerticalGroup(
            agrotoxicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agrotoxicosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(agrotoxicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(addButton)
                    .addComponent(agroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        nivel.addTab("Nível 3", agrotoxicosPanel);

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
            CPNJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPNJFormattedTextField.setText("");
        CPNJFormattedTextField.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("CNPJ :");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Nome : ");

        nomeTextField.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        searchPropriedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        searchPropriedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPropriedadesActionPerformed(evt);
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

        clearSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backspace.png"))); // NOI18N
        clearSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearSearchMouseClicked(evt);
            }
        });

        jMenu1.setText("...");

        editMenuItem.setText("Editar Perfil");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(editMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
            .addComponent(nivel, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(nomeTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPNJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchPropriedades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap()
                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CPNJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchPropriedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salvar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(apagar)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CPNJFormattedTextField, jLabel2, jLabel4, nomeTextField});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCidadeActionPerformed
        adress = new Adress();
        adress.endereco(currentPropriedade.getPropriedadeId(), currentPropriedade.getEndereco());
        adress.setVisible(true);
    }//GEN-LAST:event_buscarCidadeActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
        delete();
    }//GEN-LAST:event_apagarActionPerformed

    private void delete() {
        Communication communication = new Communication("PROPRIEDADEDELETE");
        communication.setParam("propriedadeId", propriedades.get(propriedadesTable.getSelectedRow()).getPropriedadeId());
        communication = server.outPut_inPut(communication);
        JOptionPane.showMessageDialog(null, communication.getParam("PROPRIEDADEDELETEREPLY"));
        clear();
        new Thread(readTables).start();
    }

    private void clear() {
        nomePropriedade.setText("");
        buscarCidade.setText("Selecione Endereço");
        empregadoSpinner.setValue(0);
        maquinasSpinner.setValue(0);
        nivelSpinner.setValue(0);
        DefaultTableModel modelo = (DefaultTableModel) impostoTable.getModel();
        modelo.setNumRows(0);
        agroModelo = (DefaultTableModel) agroTable.getModel();
        agroModelo.setNumRows(0);
    }

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (actionCrud == 1) {
            update();
            actionCrud = 0;
        } else if (actionCrud == 2) {
            create();
            actionCrud = 0;
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void create() {
        Propriedade propriedade = getPropriedade(currentPropriedade);
        Communication communication = new Communication("PROPRIEDADECREATE");
        communication.setParam("propriedade", propriedade);
        communication = server.outPut_inPut(communication);
        JOptionPane.showMessageDialog(null, communication.getParam("PROPRIEDADECREATEREPLY"));
        toggleFields(false);
        apagar.setEnabled(true);
        new Thread(readTables).start();
    }

    private void update() {
        Propriedade propriedade = getPropriedade(currentPropriedade);
        switch (nivel.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, updatePropriedade(propriedade));
                break;
            case 1:
                JOptionPane.showMessageDialog(null, updateImposto(propriedade));
                break;
            case 2:
                JOptionPane.showMessageDialog(null, updateAgrotoxico(propriedade));
                break;
        }
        toggleFields(false);
        editNomeButton.setEnabled(false);
        apagar.setEnabled(true);
    }

    private String updatePropriedade(Propriedade propriedade) {
        Communication communication = new Communication("PROPRIEDADEUPDATE");
        communication.setParam("propriedade", propriedade);
        communication = server.outPut_inPut(communication);
        return (String) communication.getParam("PROPRIEDADEUPDATEREPLY");
    }

    private String updateAgrotoxico(Propriedade p) {
        Communication communication = new Communication("AGROUPDATE");
        communication.setParam("propriedadeId", p.getPropriedadeId());
        communication.setParam("agrotoxicos", agrotoxicos);
        communication = server.outPut_inPut(communication);
        return (String) communication.getParam("AGROUPDATEREPLY");
    }

    private String updateImposto(Propriedade p) {
        List<Imposto> impostoEdit = impostos;
        Communication communication = new Communication("IMPOSTOUPDATE");
        try {
            if (impostoTable.getValueAt(impostoTable.getRowCount() - 1, 3).equals(null));
        } catch (NullPointerException ex) {
            if (impostoEdit.get(impostoTable.getRowCount() - 1).getValorBruto() > 0) {
                JOptionPane.showMessageDialog(null, "Escolha o tipo do imposto!");
            }
            impostoEdit.get(impostoTable.getRowCount() - 1).setValorBruto(0.0);
        }
        communication.setParam("propriedadeId", p.getPropriedadeId());
        communication.setParam("imposto", impostoEdit);
        communication = server.outPut_inPut(communication);
        return (String) communication.getParam("IMPOSTOUPDATEREPLY");
    }

    private Propriedade getPropriedade(Propriedade propriedade) {
        String mercado = (String) destinoComboBox.getSelectedItem();
        int destino = 0;
        switch (mercado) {
            case "interno":
                destino = 1;
                break;
            case "externo":
                destino = 0;
                break;
        }
        propriedade.setDestino(destino);
        propriedade.setNumeroEmpregados((int) empregadoSpinner.getValue());
        propriedade.setMaquinas((int) maquinasSpinner.getValue());
        propriedade.setNivelAutomacao((int) nivelSpinner.getValue());
        propriedade.setNome(nomePropriedade.getText());
        return propriedade;
    }

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        actionCrud = 1;
        toggleFields(true);
        apagar.setEnabled(false);
    }//GEN-LAST:event_editarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        nivel.setSelectedIndex(0);
        cnpj = new CNPJ(getLocation());
        cnpj.setVisible(true);
        actionCrud = 2;
        clear();
        toggleFields(true);
        buscarCidade.setEnabled(false);
        apagar.setEnabled(false);
    }//GEN-LAST:event_novoActionPerformed

    private void searchPropriedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPropriedadesActionPerformed
        propriedadesTable.clearSelection();
        new Thread(readTables).start();
    }//GEN-LAST:event_searchPropriedadesActionPerformed

    private void propriedadesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propriedadesTableMouseReleased
        proprietarioSelected();
    }//GEN-LAST:event_propriedadesTableMouseReleased

    private void propriedadesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_propriedadesTableKeyReleased
        proprietarioSelected();
    }//GEN-LAST:event_propriedadesTableKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (cnpj.cnpjChek == false && actionCrud != 1) {
            toggleFields(false);
        } else if (actionCrud == 2) {
            currentPropriedade.setCpnj(cnpj.cnpj);
        }
        try {
            if (!adress.isVisible() && propriedadesTable.getSelectedRow() >= 0) {
                proprietarioSelected();
            }
        } catch (NullPointerException ex) {

        }
        try {
            impostoTable.setValueAt(tipoSelect.getCurrentTipo().getNome(), impostoTable.getSelectedRow(), 3);
            impostoTable.setValueAt(tipoSelect.getCurrentTipo().getTipo(), impostoTable.getSelectedRow(), 4);
            impostos.get(impostoTable.getSelectedRow()).setTipo(tipoSelect.getCurrentTipo());
            tipoSelect.setCurrentTipo(null);
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void clearSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearSearchMouseClicked
        CPNJFormattedTextField.setText("");
        nomeTextField.setText("");
        new Thread(readTables).start();
    }//GEN-LAST:event_clearSearchMouseClicked

    private void impostoTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impostoTableMouseReleased
        pago();
    }//GEN-LAST:event_impostoTableMouseReleased

    private void impostoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_impostoTableKeyReleased
        pago();
    }//GEN-LAST:event_impostoTableKeyReleased

    private void impostoTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_impostoTablePropertyChange
        try {
            Imposto imposto = impostos.get(impostoTable.getSelectedRow());
            double percent = Double.parseDouble(String.valueOf(impostoTable.getValueAt(impostoTable.getSelectedRow(), 2)));
            double valor = Double.parseDouble(String.valueOf(impostoTable.getValueAt(impostoTable.getSelectedRow(), 0)));
            imposto.setSubsidio(((percent > 100) ? 100 : percent));
            if (impostoTable.getSelectedColumn() == 2) {
                impostoTable.setValueAt(imposto.getSubsidio(), impostoTable.getSelectedRow(), impostoTable.getSelectedColumn());
            }
            imposto.setValorBruto(valor);
            impostos.set(impostoTable.getSelectedRow(), imposto);
        } catch (NumberFormatException ex) {
            double perc = impostos.get(impostoTable.getSelectedRow()).getSubsidio();
            double val = impostos.get(impostoTable.getSelectedRow()).getValorBruto();
            impostoTable.setValueAt(val, impostoTable.getSelectedRow(), 0);
            impostoTable.setValueAt(perc, impostoTable.getSelectedRow(), 2);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
        }
    }//GEN-LAST:event_impostoTablePropertyChange

    private void pagoRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoRadioButtonMouseClicked
        try {
            int i = (pagoRadioButton.isSelected()) ? 1 : 0;
            Imposto imposto = impostos.get(impostoTable.getSelectedRow());
            imposto.setPago(i);
            impostos.set(impostoTable.getSelectedRow(), imposto);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
        }
    }//GEN-LAST:event_pagoRadioButtonMouseClicked

    private void editNomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNomeButtonActionPerformed
        tipoSelect.setLocation(getLocation());
        tipoSelect.setVisible(true);
    }//GEN-LAST:event_editNomeButtonActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        Authenticated authenticated = new Authenticated();
        EditProfile editProfile = new EditProfile(authenticated.getLogin(), this);
        editProfile.setLocation(getLocation());
        editProfile.setVisible(true);
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (agroComboBox.getSelectedIndex() > 0) {
            Agrotoxico agro = agrotoxicosTotais.get(agroComboBox.getSelectedIndex() - 1);
            int count = 0;
            for (Agrotoxico a : agrotoxicos) {
                if (a.getAgroId() == agro.getAgroId()) {
                    count++;
                }
            }
            if (count == 0) {
                agroModelo.addRow(new Object[]{
                    agro.getNome(),
                    agro.getIngrediente()
                });
                agrotoxicos.add(agro);
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (agroComboBox.getSelectedIndex() > 0) {
            Agrotoxico agro = agrotoxicosTotais.get(agroComboBox.getSelectedIndex() - 1);
            int count = 0;
            for (Agrotoxico a : agrotoxicos) {
                if (a.getAgroId() == agro.getAgroId()) {
                    count++;
                }
            }
            if (count == 1) {
                agroModelo.setNumRows(0);
                agrotoxicos.remove(agro);
                for (Agrotoxico a : agrotoxicos) {
                    agroModelo.addRow(new Object[]{
                        a.getNome(),
                        a.getIngrediente()
                    });
                }
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void detalhesPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detalhesPanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_detalhesPanelMousePressed

    private void pago() {
        if (actionCrud == 1) {
            editNomeButton.setEnabled(true);
        }
        try {
            int pago = impostos.get(impostoTable.getSelectedRow()).getPago();
            if (pago == 1) {
                pagoRadioButton.setSelected(true);
            } else {
                pagoRadioButton.setSelected(false);
            }
        } catch (IndexOutOfBoundsException ex) {
        } catch (NullPointerException ex) {

        }
    }

    private String limitText(String text) {
        return limitText(text, 30);
    }

    private String limitText(String text, int l) {
        if (text.length() > l) {
            text = text.substring(0, l) + " ...";
        }
        return text;
    }

    private void proprietarioSelected() {
        actionCrud = 0;
        agroComboBox.setSelectedIndex(0);
        editNomeButton.setEnabled(false);
        try {
            toggleFields(false);
            Communication communication = new Communication("PROPRIEDADESELECTED");
            communication.setParam("propriedadeId", propriedades.get(propriedadesTable.getSelectedRow()).getPropriedadeId());
            apagar.setEnabled(true);
            communication = server.outPut_inPut(communication);
            propriedades(communication);
            readImpostos(communication);
            readAgrotoxicos(communication);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }

    private void propriedades(Communication communication) {
        currentPropriedade = (Propriedade) communication.getParam("PROPRIEDADESELECTEDREPLY");
        nomePropriedade.setText(limitText(currentPropriedade.getNome(), 35));
        try {
            buscarCidade.setText(limitText(currentPropriedade.getEndereco().getEndereco()));
            buscarCidade.setToolTipText(limitText(currentPropriedade.getEndereco().getEndereco()));
        } catch (NullPointerException ex) {
            buscarCidade.setText("Selecione Endereço");
            buscarCidade.setToolTipText("Selecione Endereço");
        }
        int destino = currentPropriedade.getDestino();
        switch (destino) {
            case 1:
                destinoComboBox.setSelectedIndex(0);
                break;
            case 0:
                destinoComboBox.setSelectedIndex(1);
                break;
        }
        empregadoSpinner.setValue(currentPropriedade.getNumeroEmpregados());
        maquinasSpinner.setValue(currentPropriedade.getMaquinas());
        nivelSpinner.setValue(currentPropriedade.getNivelAutomacao());
    }

    private void readImpostos(Communication communication) {
        DefaultTableModel modelo = (DefaultTableModel) impostoTable.getModel();
        modelo.setNumRows(0);
        List<Imposto> impDAO = (ArrayList) communication.getParam("IMPOSTOSREPLY");
        int count = 0;
        for (Imposto i : impDAO) {
            modelo.addRow(new Object[]{
                i.getValorBruto(),
                i.getValorLiquido(),
                i.getSubsidio(),
                i.getTipo().getNome(),
                i.getTipo().getTipo()
            });
            count++;
        }
        if (count == 0) {
            modelo.setNumRows(1);
        } else {
            modelo.setNumRows(modelo.getRowCount() + 1);
        }
        impostoTotalLabel.setText("Total : R$ " + (double) communication.getParam("IMPOSTOSTOTALREPLY"));
        Imposto i = new Imposto();
        i.setValorBruto(0.0);
        i.setSubsidio(0.0);
        impostos = impDAO;
        impostos.add(i);
    }

    private void readAgrotoxicos(Communication communication) {
        agroModelo = (DefaultTableModel) agroTable.getModel();
        agroModelo.setNumRows(0);
        List<Agrotoxico> impDAO = (ArrayList) communication.getParam("AGROREADREPLY");
        String message = "";
        int count = 0;
        for (Agrotoxico i : impDAO) {
            if (i.getAprovado() == 0) {
                message = "\"" + i.getNome() + "\",\n";
                count++;
            }
            agroModelo.addRow(new Object[]{
                i.getNome(),
                i.getIngrediente(),});
        }

        if (count > 0 && nivel.getSelectedIndex() == 2) {
            JOptionPane.showMessageDialog(null, message + " são agrotoxicos proibidos!");
        }
        agrotoxicos = impDAO;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPNJFormattedTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> agroComboBox;
    private javax.swing.JTable agroTable;
    private javax.swing.JPanel agrotoxicosPanel;
    private javax.swing.JButton apagar;
    private javax.swing.JButton buscarCidade;
    private javax.swing.JLabel clearSearch;
    private javax.swing.JComboBox<String> destinoComboBox;
    private javax.swing.JPanel detalhesPanel;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JButton editNomeButton;
    private javax.swing.JButton editar;
    private javax.swing.JSpinner empregadoSpinner;
    private javax.swing.JPanel impostoPanel;
    private javax.swing.JTable impostoTable;
    private javax.swing.JLabel impostoTotalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner maquinasSpinner;
    private javax.swing.JTabbedPane nivel;
    private javax.swing.JSpinner nivelSpinner;
    private javax.swing.JTextField nomePropriedade;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton novo;
    private javax.swing.JRadioButton pagoRadioButton;
    private javax.swing.JTextField prodAnualLabel;
    private javax.swing.JButton prodButton;
    private javax.swing.JLabel produtos;
    private javax.swing.JLabel produtos1;
    private javax.swing.JTable propriedadesTable;
    private javax.swing.JToggleButton removeButton;
    private javax.swing.JButton salvar;
    private javax.swing.JButton searchPropriedades;
    // End of variables declaration//GEN-END:variables
}
