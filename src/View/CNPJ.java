package View;

import ConnectionFactory.Server;
import java.awt.Point;
import javax.swing.JOptionPane;
import util.Communication;

/**
 *
 * @author will
 */
public class CNPJ extends javax.swing.JFrame {

    public static boolean cnpjChek = false;
    public static String cnpj;
    public String cnpjFormated = "   .   .   /    -  ";

    public CNPJ(Point p) {
        setLocation(p.x + 140, p.y + 180);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CPNJFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        OKButton = new javax.swing.JToggleButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
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

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPNJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OKButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CPNJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(OKButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        Server server = new Server();
        Communication communication = new Communication("CNPJCHECK");
        communication.setParam("cnpj", CPNJFormattedTextField.getText());
        communication = server.outPut_inPut(communication);
        int count = (int) communication.getParam("CNPJCHECKREPLY");
        if (CPNJFormattedTextField.getText().equals(cnpjFormated)) {
            JOptionPane.showMessageDialog(null, "CNPJ não preechido!");
            setVisible(true);
        } else {
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "CNPJ já existe!");
                cnpjChek = false;
                setVisible(true);
            } else {
                cnpj = CPNJFormattedTextField.getText();
                cnpjChek = true;
                setVisible(false);
            }
        }
    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPNJFormattedTextField;
    private javax.swing.JToggleButton OKButton;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
