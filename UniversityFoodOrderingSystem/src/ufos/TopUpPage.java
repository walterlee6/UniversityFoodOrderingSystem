/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author Walter
 */
public class TopUpPage extends javax.swing.JFrame {

    GUI ui = new GUI();
    User u = new User();
    DB customerDB = new DB("Customer");
    DB.CustomerRowMapper cMapper = customerDB.new CustomerRowMapper();
    Transaction t= new Transaction();
    Customer customer = new Customer();
    
    
    
    public TopUpPage() {
        initComponents();
    }
    public TopUpPage(User u) {
        initComponents();
        this.u = u;
        loadCustomerData();
        
    }
    public void loadCustomerData() {
        List<Object[]> rows = customerDB.readData(cMapper);
        DefaultTableModel model = (DefaultTableModel) t_tuRecord.getModel();
        model.setRowCount(0);

        for (Object[] rowData : rows) {
            if (rowData == null || rowData.length < 5) {
                continue; // Skip invalid rows
            }

            String customerId = (String) rowData[0];
            String customerName = (String) rowData[1];
            String balanceStr = (String) rowData[5];

            model.addRow(new Object[]{customerId, customerName, balanceStr});
        }
        customerDB.closeResources();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_tuRecord = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_tuAmount = new javax.swing.JTextField();
        btn_tUp = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_gReceipt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_cId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_cName = new javax.swing.JTextField();
        btn_bNotification = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TopUp Page");

        t_tuRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Customer Name", "Balance"
            }
        ));
        t_tuRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_tuRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_tuRecord);

        jLabel2.setText("TopUp Record");

        jLabel3.setText("TopUp Amount");

        tf_tuAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tuAmountActionPerformed(evt);
            }
        });

        btn_tUp.setText("TopUp");
        btn_tUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tUpActionPerformed(evt);
            }
        });

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_gReceipt.setText("Generate Receipt");
        btn_gReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gReceiptActionPerformed(evt);
            }
        });

        jLabel4.setText("Customer Id");

        jLabel5.setText("Customer Name: ");

        btn_bNotification.setText("Notification");
        btn_bNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bNotificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_cId)
                                            .addComponent(tf_cName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tf_tuAmount)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btn_tUp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(btn_gReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btn_bNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tuAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_gReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(btn_bNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)))
                .addComponent(btn_back)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_tuAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tuAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tuAmountActionPerformed

    private void btn_tUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tUpActionPerformed
        try {
            int selectedRow = t_tuRecord.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a customer from the table.");
                return;
            }

            String customerID = t_tuRecord.getValueAt(selectedRow, 0).toString();
            String customerName = t_tuRecord.getValueAt(selectedRow, 1).toString();

            double topUpAmount = Double.parseDouble(tf_tuAmount.getText());

            DefaultTableModel model = (DefaultTableModel) t_tuRecord.getModel();
            double currentBalance = Double.parseDouble(model.getValueAt(selectedRow, 2).toString());
            double newBalance = currentBalance + topUpAmount;

            model.setValueAt(newBalance, selectedRow, 2);

            // Update the customer balance in the file
            t.updateCustomerBalance(customerID, newBalance);
            t.WriteTransactionFile(customerID, customerName, topUpAmount);
   
            tf_cId.setText("");
            tf_cName.setText("");
            tf_tuAmount.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid top-up amount!");
        } catch (IOException ex) {
            Logger.getLogger(TopUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_btn_tUpActionPerformed
 
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        ui.callPage("AdminDashboard",u);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_gReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gReceiptActionPerformed
        try {
            int selectedRow = t_tuRecord.getSelectedRow(); // Assuming t_tuRecord is your JTable
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a customer from the table.");
                return;
            }

            String customerId = t_tuRecord.getValueAt(selectedRow, 0).toString();
            String customerName = t_tuRecord.getValueAt(selectedRow, 1).toString();
            String balance = t_tuRecord.getValueAt(selectedRow, 2).toString();

            //Open the GenerateReceiptPage and pass the user and customer data
            GenerateReceiptPage generateReceiptPage = new GenerateReceiptPage(u, customerId, customerName, balance);
            generateReceiptPage.setVisible(true);
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid balance format!");
        }
    }//GEN-LAST:event_btn_gReceiptActionPerformed

    private void t_tuRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_tuRecordMouseClicked
        int selectedRow = t_tuRecord.getSelectedRow();
        if (selectedRow != -1) {
            Object idValue = t_tuRecord.getValueAt(selectedRow, 0);
            Object nameValue = t_tuRecord.getValueAt(selectedRow, 1);

            // Check if values are not null before using toString()
            if (idValue != null && nameValue != null) {
                tf_cId.setText(idValue.toString());
                tf_cName.setText(nameValue.toString());
            } else {
                // Handle the case where values are null
                tf_cId.setText("");
                tf_cName.setText("");
            }
        }
    }//GEN-LAST:event_t_tuRecordMouseClicked

    private void btn_bNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bNotificationActionPerformed
        ui.callPage("BalanceNotifcationPage", u);      
    }//GEN-LAST:event_btn_bNotificationActionPerformed

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TopUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TopUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bNotification;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_gReceipt;
    private javax.swing.JButton btn_tUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_tuRecord;
    private javax.swing.JTextField tf_cId;
    private javax.swing.JTextField tf_cName;
    private javax.swing.JTextField tf_tuAmount;
    // End of variables declaration//GEN-END:variables
}
