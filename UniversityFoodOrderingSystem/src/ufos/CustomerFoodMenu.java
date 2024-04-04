/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.*;


public class CustomerFoodMenu extends javax.swing.JFrame {
    GUI ui = new GUI();
    User u = new User();
    DB db = new DB("Menu");
    DB dbOrder = new DB("Order");
    NotifDB nt = new NotifDB();
    Customer c = new Customer();
    Order o;
    SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
    List<String[]> items = new ArrayList<>();
    private String selectedPrice = "";
    private String orderID;
    private double totalPrice;
    private String selectedVendorId;
    private Map<String, String> vendorNameToIdMap = new HashMap<>();

    
    
    public CustomerFoodMenu() {        
        initComponents();        
    }
    public CustomerFoodMenu(User id) {
        this.o = new Order(items);
        initComponents();     
        this.u = id;
        QuantitySpinner.setModel(spinnerModel);
        load();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        QuantitySpinner = new javax.swing.JSpinner();
        FoodAddCart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AddCartbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TotalPrice = new javax.swing.JTextField();
        Orderbtn = new javax.swing.JButton();
        CancelOrderbtn = new javax.swing.JButton();
        OrderHistorybtn = new javax.swing.JButton();
        FoodReviewbtn = new javax.swing.JButton();
        OrderStatusbtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        DelivaryStatus = new javax.swing.JComboBox<>();
        Deletebtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        FoodMenuTable = new javax.swing.JTable();
        FoodStoreCBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Paymentbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Portion", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(0).setResizable(false);
            CartTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Food Menu");

        jLabel2.setText("Cart");

        jLabel3.setText("Food Name :");

        FoodAddCart.setEditable(false);

        jLabel4.setText("Quantity :");

        AddCartbtn.setText("Add to Cart");
        AddCartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Price :");

        TotalPrice.setEditable(false);

        Orderbtn.setText("Order");
        Orderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderbtnActionPerformed(evt);
            }
        });

        CancelOrderbtn.setText("Cancel");
        CancelOrderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelOrderbtnActionPerformed(evt);
            }
        });

        OrderHistorybtn.setText("Order History");
        OrderHistorybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistorybtnActionPerformed(evt);
            }
        });

        FoodReviewbtn.setText("Food Review");
        FoodReviewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodReviewbtnActionPerformed(evt);
            }
        });

        OrderStatusbtn.setText("Order Status");
        OrderStatusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderStatusbtnActionPerformed(evt);
            }
        });

        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Delivery method");

        DelivaryStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine-in", "Take Away", "Delivery" }));

        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        FoodMenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price", "Desrciption"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FoodMenuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                FoodMenuTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(FoodMenuTable);
        if (FoodMenuTable.getColumnModel().getColumnCount() > 0) {
            FoodMenuTable.getColumnModel().getColumn(0).setResizable(false);
            FoodMenuTable.getColumnModel().getColumn(1).setResizable(false);
            FoodMenuTable.getColumnModel().getColumn(2).setResizable(false);
        }

        FoodStoreCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodStoreCBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Food Store");

        Paymentbtn.setText("Payment");
        Paymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DelivaryStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Deletebtn)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Orderbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CancelOrderbtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(FoodStoreCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(FoodReviewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OrderStatusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OrderHistorybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Backbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(AddCartbtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(QuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FoodAddCart)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Paymentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FoodStoreCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(FoodAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addComponent(AddCartbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DelivaryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Deletebtn))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Orderbtn)
                                .addComponent(CancelOrderbtn)
                                .addComponent(Backbtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FoodReviewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OrderStatusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Paymentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OrderHistorybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartbtnActionPerformed
        DefaultTableModel Cartmodel = (DefaultTableModel)CartTable.getModel();
        String foodName = FoodAddCart.getText();
        int quantity = (int)QuantitySpinner.getValue();
        if(foodName.equals("")){
            JOptionPane.showMessageDialog(null, "Please Select from Food menu");
        }else{
            items.add(new String[]{foodName,String.valueOf(quantity),selectedPrice});
            Cartmodel.setRowCount(0); 
            for(String[] item : items) {
                Cartmodel.addRow(item);   

            }
            o = new Order(items);
            totalPrice = o.calculateTotalPrice();
            TotalPrice.setText(String.valueOf(totalPrice));   
        }
    }//GEN-LAST:event_AddCartbtnActionPerformed

    private void OrderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderbtnActionPerformed
        String Id = u.getId();
        DefaultTableModel Cartmodel = (DefaultTableModel)CartTable.getModel();
        String selectedValue = (String) DelivaryStatus.getSelectedItem();
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String status = "Pending";
        orderID = dbOrder.generateId();
        boolean message = false;
        for(int i = 0; i < Cartmodel.getRowCount(); i++) {
            // Get the values of each column in the current row
            String foodName = Cartmodel.getValueAt(i, 0).toString();
            int quantity = Integer.parseInt(Cartmodel.getValueAt(i, 1).toString());
            double price = Double.parseDouble(Cartmodel.getValueAt(i, 2).toString());
            String foodID = o.getFoodID(foodName);
               
            try {
                double adjustedTotalPrice = totalPrice;      
                // Adjust total price based on delivery method
                if ("Delivery".equals(selectedValue)) {
                    adjustedTotalPrice += 5.0; // Add $5 for delivery
                } else if ("Take Away".equals(selectedValue)) {
                    adjustedTotalPrice += 2.0; // Add $2 for take away
                }else{
                    adjustedTotalPrice = totalPrice;
                }
                c.OrderFood(orderID, foodID, foodName, quantity, price, status, currentDateTime,adjustedTotalPrice , selectedValue,selectedVendorId,u.getId() ,"R001");
                message = true;
            } catch (IOException ex) {
                Logger.getLogger(CustomerFoodMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
        

        if(message == true){
           JOptionPane.showMessageDialog(null, "Order Susscessfull! please wait for Vendor to approve");
           Cartmodel.setRowCount(0);
           items.clear();
           TotalPrice.setText("0.0");
        }  
    }//GEN-LAST:event_OrderbtnActionPerformed

    private void CancelOrderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelOrderbtnActionPerformed
        DefaultTableModel Cartmodel = (DefaultTableModel)CartTable.getModel();
        // Clear the items list
        items.clear();

        // Remove all rows from the CartTable
        Cartmodel.setRowCount(0);

        // Reset the total price
        TotalPrice.setText("0.0");
    }//GEN-LAST:event_CancelOrderbtnActionPerformed

    private void FoodReviewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodReviewbtnActionPerformed
       ui.callPage("CustomerFoodReview",u);
       this.dispose();
    }//GEN-LAST:event_FoodReviewbtnActionPerformed

    private void OrderStatusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderStatusbtnActionPerformed
        ui.callPage("CustomerOrderStatus",u);
        this.dispose();
    }//GEN-LAST:event_OrderStatusbtnActionPerformed

    private void OrderHistorybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistorybtnActionPerformed
        ui.callPage("CustomerOrderHistory",u);
        this.dispose();
    }//GEN-LAST:event_OrderHistorybtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        ui.callPage("CustomerProfilePage",u);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
       DefaultTableModel Cartmodel = (DefaultTableModel)CartTable.getModel();
       int selectedRow = CartTable.getSelectedRow();
       if(selectedRow >= 0) { // Ensure a row is selected
       String foodName = CartTable.getValueAt(selectedRow, 0).toString();
       int quantity = Integer.parseInt(CartTable.getValueAt(selectedRow, 1).toString());
       double price = Double.parseDouble(CartTable.getValueAt(selectedRow, 2).toString());

       // Remove the item from the items list
       for(Iterator<String[]> iterator = items.iterator(); iterator.hasNext();) {
           String[] item = iterator.next();
           if(item[0].equals(foodName) && item[1].equals(String.valueOf(quantity)) && item[2].equals(String.valueOf(price))) {
               iterator.remove();
               break;
           }
       }

       // Remove the row from the CartTable
       Cartmodel.removeRow(selectedRow);

       // Update the total price
       o = new Order(items);
       totalPrice = o.calculateTotalPrice();
       TotalPrice.setText(String.valueOf(totalPrice));
   }
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void FoodMenuTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodMenuTableMouseReleased
       int selectedRow = FoodMenuTable.getSelectedRow();
        if(selectedRow >= 0) { // Ensure a row is selected
            String foodName = FoodMenuTable.getValueAt(selectedRow, 0).toString();
            selectedPrice = FoodMenuTable.getValueAt(selectedRow, 1).toString();
            FoodAddCart.setText(foodName);
           
        }
    }//GEN-LAST:event_FoodMenuTableMouseReleased

    private void FoodStoreCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodStoreCBoxActionPerformed
        String selectedVendorName = (String) FoodStoreCBox.getSelectedItem();
        if (selectedVendorName != null) {
            selectedVendorId = vendorNameToIdMap.get(selectedVendorName);
            // Reload the food menu based on the selected vendor ID
            loadFoodMenu();
        } 
    }//GEN-LAST:event_FoodStoreCBoxActionPerformed

    private void PaymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentbtnActionPerformed
        Transaction t = new Transaction();
        String selectedValue = (String) DelivaryStatus.getSelectedItem();
        t.payment(u.getId(), orderID, totalPrice, selectedValue);
        
    }//GEN-LAST:event_PaymentbtnActionPerformed
    public void load(){    
        try {
            List<String> lines = Files.readAllLines(Paths.get("DB\\Account\\Vendor.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length > 5) {
                    String vendorId = parts[0];
                    String vendorName = parts[5];
                    vendorNameToIdMap.put(vendorName, vendorId);
                    FoodStoreCBox.addItem(vendorName);
                }
            }
        } catch (IOException ex) {
            // Handle the exception (e.g., log it or show an error message)
            ex.printStackTrace();
        }
         if (!vendorNameToIdMap.isEmpty()) {
            selectedVendorId = vendorNameToIdMap.values().iterator().next();
            loadFoodMenu();
        }
    }
    
    private void loadFoodMenu() {
       DefaultTableModel model = (DefaultTableModel) FoodMenuTable.getModel();
       model.setRowCount(0); // Clear existing rows

       // Load data for FoodMenuTable based on the selected vendor ID
       db.loadData(model, line -> {
           String[] parts = line.split(",");
           String foodName = parts[1];
           double price = Double.parseDouble(parts[2]);
           String description = parts[3];
           String vendorId = parts[4];

           if (selectedVendorId.equals(vendorId)) {
               return new Object[]{foodName, price, description};
           } else {
               return null; // Skip items that don't belong to the selected vendor
           }
       });
    }
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
            java.util.logging.Logger.getLogger(CustomerFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerFoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFoodMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCartbtn;
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton CancelOrderbtn;
    private javax.swing.JTable CartTable;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JComboBox<String> DelivaryStatus;
    private javax.swing.JTextField FoodAddCart;
    private javax.swing.JTable FoodMenuTable;
    private javax.swing.JButton FoodReviewbtn;
    private javax.swing.JComboBox<String> FoodStoreCBox;
    private javax.swing.JButton OrderHistorybtn;
    private javax.swing.JButton OrderStatusbtn;
    private javax.swing.JButton Orderbtn;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JSpinner QuantitySpinner;
    private javax.swing.JTextField TotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
