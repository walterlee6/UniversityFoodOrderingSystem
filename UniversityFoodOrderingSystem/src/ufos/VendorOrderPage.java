package ufos;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;


public class VendorOrderPage extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private String[] columnName = {"OrderID", "Date", "Status", "TotalPrice","DeliveryMethod"};
    private String[] columnName2 = {"FoodName", "Portion", "Price"};
    DB db = new DB("Order");
//    DB nt = new DB("Notification");
    NotifDB nt = new NotifDB();
    User u = new User();
    DB.OrderRowMapper mapper = db.new OrderRowMapper();
    GUI ui = new GUI();
    
    public VendorOrderPage() {
        initComponents();

    }
    public VendorOrderPage(User id) {
        initComponents();
        u = id;
        model.setColumnIdentifiers(columnName);
        model2.setColumnIdentifiers(columnName2);
        load();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderList = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        FoodList = new javax.swing.JTable();
        Cancel = new javax.swing.JButton();
        Accept = new javax.swing.JButton();
        OrderHistory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FoodMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrderList.setModel(model);
        OrderList.getTableHeader().setReorderingAllowed(false);
        OrderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OrderListMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(OrderList);

        FoodList.setModel(model2);
        FoodList.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(FoodList);

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Accept.setText("Accept");
        Accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptActionPerformed(evt);
            }
        });

        OrderHistory.setText("Vendor Dashboard");
        OrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistoryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Order Page");

        FoodMenu.setText("Food Menu");
        FoodMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodMenuActionPerformed(evt);
            }
        });

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FoodMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Accept, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OrderHistory)
                                .addGap(18, 18, 18))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FoodMenu)
                    .addComponent(OrderHistory))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(Accept)
                        .addGap(18, 18, 18)
                        .addComponent(Cancel)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrderListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderListMouseReleased
        int row = OrderList.getSelectedRow();              
        String orderId = String.valueOf(model.getValueAt(row,0));      
        
        List<Object[]> rows = db.readData(mapper);
        model2.setRowCount(0);
        
        
         for (Object[] rowData : rows) {
            String currentOrderId = (String) rowData[0];
            String foodName = (String) rowData[2];
            String portion = (String) rowData[3];
            String price = (String) rowData[4];

            // If currentOrderId is the same as model orderId, add it to the list
            if (currentOrderId.equals(orderId)) {
                model2.addRow(new Object[]{foodName,portion,price});
            }
                
        }
        db.closeResources();
    }//GEN-LAST:event_OrderListMouseReleased

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
// Get the orderId of the chosen row in the model
        int row = OrderList.getSelectedRow();
        if (row != -1){
            String orderId = String.valueOf(model.getValueAt(row, 0));

    // Read the Order.txt file line by line
            List<String> data = db.readFile();
            List<String> sameIDd = new ArrayList<>();
            for (String line : data) {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];

    // If the currentOrderId is the same as the orderId of the chosen row in the model and the status is pending, add the line to the list
                if (currentOrderId.equals(orderId)) {
                    sameIDd.add(line);
                }
            }

            data.removeIf(line -> {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];
                return currentOrderId.equals(orderId);
             });     

            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
            } catch (IOException ex) {
                System.out.println("Something went wrong.");
            }
            db.closeResources();



            db.writeFile();
            for (String line : sameIDd) {
                String[] parts = line.split(",");
                String status = parts[5];
                if (status.equals("Pending")) {
                    String[] updatedParts = Arrays.copyOf(parts, parts.length);
                    updatedParts[5] = "Cancelled";
                    line = String.join(",", updatedParts);                            


                }
                try {
                    db.bw.write(line);
                    db.bw.newLine();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                }                   
            db.closeResources();
            load();
            }
            try {
                nt.Vendor(u);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Order Declined","Fail", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Choose a line","Fail", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void AcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptActionPerformed
// Get the orderId of the chosen row in the model
        int row = OrderList.getSelectedRow();
        if (row != -1){
            String orderId = String.valueOf(model.getValueAt(row, 0));

    // Read the Order.txt file line by line
            List<String> data = db.readFile();
            List<String> sameIDd = new ArrayList<>();
            for (String line : data) {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];

    // If the currentOrderId is the same as the orderId of the chosen row in the model and the status is pending, add the line to the list
                if (currentOrderId.equals(orderId)) {
                    sameIDd.add(line);
                }
            }

            data.removeIf(line -> {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];
                return currentOrderId.equals(orderId);
             });     

            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
            }
            db.closeResources();



            db.writeFile();
            for (String line : sameIDd) {
                String[] parts = line.split(",");
                String status = parts[5];
                if (status.equals("Pending")) {
                    String[] updatedParts = Arrays.copyOf(parts, parts.length);
                    updatedParts[5] = "Preparing";
                    line = String.join(",", updatedParts);                            


                }
                try {
                    db.bw.write(line);
                    db.bw.newLine();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                }           

            }
            JOptionPane.showMessageDialog(null, "Order Accepted", "Success", JOptionPane.INFORMATION_MESSAGE);
            db.closeResources();
            load();
            try {
                nt.Vendor(u);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a line","Fail", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_AcceptActionPerformed

    private void OrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistoryActionPerformed
        ui.callPage("VendorOrderHistory", u);
        this.dispose();
    }//GEN-LAST:event_OrderHistoryActionPerformed

    private void FoodMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodMenuActionPerformed
        ui.callPage("VendorFoodMenu",u);
        this.dispose();
    }//GEN-LAST:event_FoodMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// Get the orderId of the chosen row in the model
        int row = OrderList.getSelectedRow();
        if (row != -1){
            String orderId = String.valueOf(model.getValueAt(row, 0));

    // Read the Order.txt file line by line
            List<String> data = db.readFile();
            List<String> sameIDd = new ArrayList<>();
            for (String line : data) {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];

    // If the currentOrderId is the same as the orderId of the chosen row in the model and the status is pending, add the line to the list
                if (currentOrderId.equals(orderId)) {
                    sameIDd.add(line);
                }
            }

            data.removeIf(line -> {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];
                return currentOrderId.equals(orderId);
             });     

            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
            }
            db.closeResources();



            db.writeFile();
            for (String line : sameIDd) {
                String[] parts = line.split(",");
                String status = parts[5];
                if (status.equals("Preparing")) {
                    String[] updatedParts = Arrays.copyOf(parts, parts.length);
                    updatedParts[5] = "Done";
                    line = String.join(",", updatedParts);                            


                }
                try {
                    db.bw.write(line);
                    db.bw.newLine();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                }           

            }
            JOptionPane.showMessageDialog(null, "Order Done Preparing", "Success", JOptionPane.INFORMATION_MESSAGE);

            db.closeResources();
            load();
            try {
                nt.Vendor(u);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a line","Fail", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void load() {  
        // read data from mapper
        String vId = u.getId();
        List<Object[]> rows = db.readData(mapper);
        LocalDate now = LocalDate.now();
        
        
        model.setRowCount(0);// reset model
        Set<String> orderIds = new HashSet<>(); // Set to store orderIds (it won't have dublicates

        for (Object[] rowData : rows) { // run all the data in the mapper
            // the number of rowData is depended on the number that was asssigned in the DB Override mapper
            String orderId = (String) rowData[0]; 
            String status = (String) rowData[5];
            LocalDate dt = LocalDate.parse((String) rowData[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String totalprice = (String) rowData[7];
            String DM = (String) rowData[8];
            String vendorID = (String) rowData[9];
            

           // If orderId is already in the set, skip this line
            if (vendorID.equals(vId) && dt.isEqual(now)) {
                if (!orderIds.add(orderId)) {
                    continue;
                }
                // If status is Cancelled, skip this line
                if (status.equals("Cancelled")) {
                    continue;
                }

                model.addRow(new Object[]{orderId,dt,status,totalprice,DM}); // add into the model
            }            
       }
       db.closeResources(); // close it
    }
    

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorOrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accept;
    private javax.swing.JButton Cancel;
    private javax.swing.JTable FoodList;
    private javax.swing.JButton FoodMenu;
    private javax.swing.JButton OrderHistory;
    private javax.swing.JTable OrderList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
