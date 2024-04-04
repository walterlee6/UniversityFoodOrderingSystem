package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class VendorFoodMenu extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Food Name", "Description", "Price"};
    User u = new User();
    GUI ui = new GUI();
    DB db = new DB("Menu");
    DB.MenuRowMapper mapper = db.new MenuRowMapper();

    
    public VendorFoodMenu() {
        initComponents();
        
    }
    
    public VendorFoodMenu(User id) {
        initComponents();
        model.setColumnIdentifiers(columnName); 
        this.u = id;
        load();
           
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        FoodMenu = new javax.swing.JTable();
        OrderPage = new javax.swing.JButton();
        deleteItem = new javax.swing.JButton();
        OrderHistory = new javax.swing.JButton();
        addItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        updateItem = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Price = new javax.swing.JLabel();
        PriceText = new javax.swing.JTextField();
        Desciption = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescriptionText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FoodMenu.setModel(model);
        FoodMenu.getTableHeader().setReorderingAllowed(false);
        FoodMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                FoodMenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(FoodMenu);

        OrderPage.setText("Order Page");
        OrderPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageActionPerformed(evt);
            }
        });

        deleteItem.setText("Delete");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });

        OrderHistory.setText("Vendor Dashboard");
        OrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistoryActionPerformed(evt);
            }
        });

        addItem.setText("Add");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Food Menu");

        updateItem.setText("Update");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });

        Price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Price.setText("Price : ");

        Desciption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Desciption.setText("Desciption : ");

        DescriptionText.setColumns(20);
        DescriptionText.setRows(5);
        jScrollPane2.setViewportView(DescriptionText);

        jLabel2.setText("Name : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Desciption)
                                    .addComponent(Price)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(PriceText)
                                    .addComponent(NameText)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addItem)
                                .addGap(18, 18, 18)
                                .addComponent(deleteItem)
                                .addGap(18, 18, 18)
                                .addComponent(updateItem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OrderHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(199, 199, 199)
                        .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OrderPage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Price)
                                    .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Desciption)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(deleteItem)
                                    .addComponent(updateItem)
                                    .addComponent(addItem))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OrderHistory)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FoodMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodMenuMouseReleased
        int row = FoodMenu.getSelectedRow();
        String name = String.valueOf(model.getValueAt(row,0));
        double price = Double.parseDouble(String.valueOf(model.getValueAt(row,2)));
        String desc = String.valueOf(model.getValueAt(row,1));

        NameText.setText(name);
        PriceText.setText(String.valueOf(price));
        DescriptionText.setText(desc);
    }//GEN-LAST:event_FoodMenuMouseReleased

    private void OrderPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageActionPerformed
        ui.callPage("VendorOrderPage",u);
        this.dispose();
    }//GEN-LAST:event_OrderPageActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed

        int selectedRow = FoodMenu.getSelectedRow();
        if (selectedRow != -1) {
            TableModel model = FoodMenu.getModel();
            String foodName = (String) model.getValueAt(selectedRow, 0);
            String description = (String) model.getValueAt(selectedRow, 1);
            double price = (Double) model.getValueAt(selectedRow, 2);

            List<String> data = db.readFile();
            String temp = "";
            String id = "";
            for (String line : data) {
                String[] parts = line.split(",");
                if (parts[1].equals(foodName) && parts[2].equals(Double.toString(price)) && parts[3].equals(description)) {
                    temp = line;
                    id = parts[0];

                } else {
                    JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                }
            } 
            data.remove(temp);
            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }             
                JOptionPane.showMessageDialog(null, "Food Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "This item can't be delete","Fail", JOptionPane.ERROR_MESSAGE);
            }
            db.closeResources();


        }

        load();
        clearTextField();

    }//GEN-LAST:event_deleteItemActionPerformed

    private void OrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistoryActionPerformed
        ui.callPage("VendorOrderHistory",u);
        this.dispose();
    }//GEN-LAST:event_OrderHistoryActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed

        // variables
        String vId = u.getId();
        String foodName =  NameText.getText();
        double price = Double.parseDouble(PriceText.getText());
        String Description = DescriptionText.getText();
        

        //Add in Text
        db.writeFile();
        String priceString = String.valueOf(price);
        String vendorIdString = String.valueOf(vId);
        System.out.print(vId);
        String FoodItem = db.id + "," + foodName + "," +  priceString + "," + Description + "," + vendorIdString;
        try {
            db.bw.write(FoodItem + "\n");
            JOptionPane.showMessageDialog(null, "Food Added", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding","Fail", JOptionPane.ERROR_MESSAGE);
        }
        db.closeResources();

        load();
        clearTextField();
        
    }//GEN-LAST:event_addItemActionPerformed

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        String vId = u.getId();
        int selectedRow = FoodMenu.getSelectedRow();
        if (selectedRow != -1) {
            // get modal information
            TableModel model = FoodMenu.getModel();
            String foodName = (String) model.getValueAt(selectedRow, 0);
            String description = (String) model.getValueAt(selectedRow, 1);
            double price = (Double) model.getValueAt(selectedRow, 2);

            // get the id of the selected row
            List<String> data = db.readFile();
            String id = "";
            String temp = "";
            for (String line : data) {
                String[] parts = line.split(",");
                if (parts[1].equals(foodName) && parts[2].equals(Double.toString(price)) && parts[3].equals(description)) {
                    temp = line;
                    id = parts[0];
                }
            }
            // delete the row
            data.remove(temp);

            // get the updated information
            String foodText = NameText.getText();
            double priceText = Double.parseDouble(PriceText.getText());
            String descText = DescriptionText.getText();
            String vendorIdString = String.valueOf(vId);
            // update the information but keep the original id
            String updatedLine = id + "," + foodText + "," + String.valueOf(priceText) + "," + descText + "," + vendorIdString;
            data.add(updatedLine);
            // rewrite it into the file
            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "Food Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error in updating","Fail", JOptionPane.ERROR_MESSAGE);

            }
            db.closeResources();
        }
        load();
        clearTextField();

    }//GEN-LAST:event_updateItemActionPerformed

    private void clearTextField(){
        NameText.setText("");
        PriceText.setText("");
        DescriptionText.setText("");
    }
    
    private void load() {
        String vId = u.getId();        
        List<Object[]> rows = db.readData(mapper);
        List<Object[]> newRows = new ArrayList<>();
        model.setRowCount(0);
        for (Object[] rowData : rows) {
            String foodName = (String) rowData[1];
            double price = Double.parseDouble((String) rowData[2]);
            String description = (String) rowData[3];
            String vdId = (String) rowData[4];
            
            // If orderId is already in the set, skip this line
            if (vdId.equals(vId)) {
                model.addRow(new Object[]{foodName, description, price});
            }
        }             
        db.closeResources();

    }
    
    
    
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
            java.util.logging.Logger.getLogger(VendorFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorFoodMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Desciption;
    private javax.swing.JTextArea DescriptionText;
    private javax.swing.JTable FoodMenu;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton OrderHistory;
    private javax.swing.JButton OrderPage;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField PriceText;
    private javax.swing.JButton addItem;
    private javax.swing.JButton deleteItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton updateItem;
    // End of variables declaration//GEN-END:variables
}
