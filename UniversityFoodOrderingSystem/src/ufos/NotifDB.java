package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;


public class NotifDB {    
    DB nt = new DB("Notification");
    DB db = new DB("Order");
    DB.OrderRowMapper mapper = db.new OrderRowMapper();
    DB.CustomerRowMapper cmapper = db.new CustomerRowMapper();
           
    
    public void Vendor(User u) throws IOException{
        String vId = u.getId();
        List<Object[]> rows = db.readData(mapper);       
        //NotificationID | Notification Context | SenderID | ReceiverID | Status |
        Set<String> orderIds = new HashSet<>();
        
        for (Object[] rowData : rows) { // run all the data in the mapper
            // the number of rowData is depended on the number that was asssigned in the DB Override mapper
            String orderId = (String) rowData[0]; 
            String status = (String) rowData[5];
            String dt = (String) rowData[6];
            String totalprice = (String) rowData[7];
            String DM = (String) rowData[8];
            String vendorID = (String) rowData[9];
            String customerId = (String) rowData[10];
            String runnerId = (String) rowData[11];

            //vendorId = getID
            if (vendorID.equals(vId)) {
                // If orderId is already in the set, skip this line
                if (!orderIds.add(orderId)) {
                    continue;
                }
                nt.writeFile();
                if (status.equals("Preparing")) {
                    String notif = nt.id + "," + "Your Order is being prepared" + "," + vId + "," + customerId + "," + "Unread";
                    try {
                        nt.bw.write(notif + "\n");                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (status.equals("Cancelled")){
                    String notif = nt.id + "," + "Your Order have been cancelled" + "," + vId + "," + customerId + "," + "Unread";
                    try {
                        nt.bw.write(notif + "\n");                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    String notif = nt.id + "," + "Your Order is done" + "," + vId + "," + customerId + "," + "Unread";
                    if (DM.equals("Delivery")) {
                        String runner = nt.id + "," + "Your Order is done" + "," + vId + "," + null + "," + "Unread";
                        nt.bw.write(runner + "\n");
                    }                
                    try {
                        nt.bw.write(notif + "\n"); 
                        
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                } 
            }            
        }        
        nt.closeResources(); // close it          
    }
    public void Customer(String vId) throws IOException{
        
        List<Object[]> rows = db.readData(mapper);       
        //NotificationID | Notification Context | SenderID | ReceiverID | Status |
        Set<String> orderIds = new HashSet<>();
        
        for (Object[] rowData : rows) { // run all the data in the mapper
            // the number of rowData is depended on the number that was asssigned in the DB Override mapper
            String orderId = (String) rowData[0]; 
            String status = (String) rowData[5];
            String dt = (String) rowData[6];
            String totalprice = (String) rowData[7];
            String DM = (String) rowData[8];
            String vendorID = (String) rowData[9];
            String CUSTOMERID = (String) rowData[10];
            String runnerId = (String) rowData[11];

            //vendorId = getID
            if (CUSTOMERID.equals(vId)) {
                // If orderId is already in the set, skip this line
                if (!orderIds.add(orderId)) {
                    continue;
                }
                nt.writeFile();                
                if (status.equals("Pending")) {
                    String notif = nt.id + "," + "There's a new Order!" + "," + vId + "," + vendorID + "," + "Unread";
                    try {
                        nt.bw.write(notif + "\n");                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                } 
            }            
        }        
        nt.closeResources(); // close it          
    }
    public void Runner(User u) throws IOException{
        String vId = u.getId();
        List<Object[]> rows = db.readData(mapper);       
        //NotificationID | Notification Context | SenderID | ReceiverID | Status |
        Set<String> orderIds = new HashSet<>();
        
        for (Object[] rowData : rows) { // run all the data in the mapper
            // the number of rowData is depended on the number that was asssigned in the DB Override mapper
            String orderId = (String) rowData[0]; 
            String status = (String) rowData[5];
            String dt = (String) rowData[6];
            String totalprice = (String) rowData[7];
            String DM = (String) rowData[8];
            String vendorID = (String) rowData[9];
            String customerId = (String) rowData[10];
            String runnerId = (String) rowData[11];

            //vendorId = getID
            if (vendorID.equals(vId)) {
                // If orderId is already in the set, skip this line
                if (!orderIds.add(orderId)) {
                    continue;
                }
                nt.writeFile();
                if (status.equals("Delivering")) {
                    String notif = nt.id + "," + "Your Order is being delievered" + "," + vId + "," + customerId + "," + "Unread";
                    try {
                        nt.bw.write(notif + "\n");                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (status.equals("Delivered")){
                    String notif = nt.id + "," + "Order have been Delivered" + "," + vId + "," + vendorID + "," + "Unread";
                    try {
                        nt.bw.write(notif + "\n");                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }            
        }        
        nt.closeResources(); // close it          
    }
}
