package ufos;
import java.io.*;
import javax.swing.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class DB {
    public File f;
    public BufferedWriter bw;
    public BufferedReader br;
    public String prefixID;
    public String id;
    
    public DB(String type){
        String directoryPath = "";
        switch (type) {
            case "Admin":
                directoryPath = "DB\\Account\\";
                prefixID = "A";
                break;
            case "Customer":
                directoryPath = "DB\\Account\\";
                prefixID = "C";
                break;
            case "Vendor":
                directoryPath = "DB\\Account\\";
                prefixID = "V";
                break;
            case "Runner":
                directoryPath = "DB\\Account\\";
                prefixID = "R";
                break;
            case "Menu":
                directoryPath = "DB\\Service\\";
                prefixID = "M";
                break;
            case "Order":
                directoryPath = "DB\\Service\\";
                prefixID = "O";
                break;
            case "Transaction":
                directoryPath = "DB\\Service\\";
                prefixID = "T";
                break;
            case "Notification":
                directoryPath = "DB\\Service\\";
                prefixID = "N";
                break;
            case "FoodReview":
                directoryPath = "DB\\Service\\";
                prefixID = "F";
                break;
            case "DeliveryReview":
                directoryPath = "DB\\Service\\";
                prefixID = "D";
                break;
            case "BalanceNotification":
                directoryPath = "DB\\Service\\";
                prefixID = "B";
                break;
            default:
                break;
        }
        f = new File(directoryPath + type + ".txt");
        createDirectory();
        try{
           if(!f.exists()){
             f.createNewFile();   
           }
        }catch(IOException e){
            e.printStackTrace();
        }  
        
    }
               
    private void createDirectory() {
        try {
            Path path = Paths.get(f.getParent());
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating directory");
            e.printStackTrace();
        }
    }
    
    public void overWriteFile(){
        try{
            bw = new BufferedWriter(new FileWriter(f));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error OverWrite file");
            e.printStackTrace();
        }
    
    }
    public void writeFile(){
        try{
            getID(generateId());
            bw = new BufferedWriter(new FileWriter(f,true));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Write file");
            e.printStackTrace();
        }
    }
    public void writeFile(List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Write a new line character after each line
            }
        }
    }
    
    public ArrayList<String> readFile() {
        ArrayList<String> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
            
        }
        
        return data;
    }
    
    public int readLastId() {
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            List<String> ids = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String idStr = line.split(",")[0];
                if (!idStr.isEmpty()) {
                    ids.add(idStr.substring(1));
                }
            }
            br.close();
            Collections.sort(ids);
            if (!ids.isEmpty()) {
                return Integer.parseInt(ids.get(ids.size() - 1));
            } else {
                return 0;
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return 0;
    }

   
    public String generateId() {
        int newId = readLastId() + 1;
        String id = String.format("%s%03d", prefixID, newId);
        return id;
    }
   
    public void getID(String id){
        this.id = id;
    }
    
    public interface RowMapper {
        Object[] mapRow(String line);
    }
    
    public void loadData(DefaultTableModel model, RowMapper mapper) {
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            model.setRowCount(0);
            while ((line = br.readLine()) != null) {
                Object[] rowData = mapper.mapRow(line);
                model.addRow(rowData);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
        }
    }
    
    public void loadData(DefaultTableModel model,DefaultTableModel model2,int row,JTable table ){
        model.setRowCount(0);
        String orderId = String.valueOf(model2.getValueAt(row,0));      
        List<String> sameOrderIds = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String currentOrderId = parts[0];
                String foodName = parts[2];
                String portion = parts[3];
                String price = parts[4];

                // If currentOrderId is the same as model orderId, add it to the list
                if (currentOrderId.equals(orderId)) {
                    sameOrderIds.add(currentOrderId);
                    model.addRow(new Object[]{foodName,portion,price});
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void closeResources() {
       try {
           if (bw != null)
               bw.close();
       } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"error!");
           e.printStackTrace();
       }
    }
    
    public boolean emailExists(String email) {
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String existingEmail = line.split(",")[3].trim(); // Assuming email is at index 2
                if (email.equals(existingEmail)) {
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Object[] loadDataForRow(int row, RowMapper mapper) {
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            int currentRow = 0;
            while ((line = br.readLine()) != null) {
                if (currentRow == row) {
                    return mapper.mapRow(line);
                }
                currentRow++;
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Object[]> readData(RowMapper mapper) {
        List<Object[]> rows = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                Object[] rowData = mapper.mapRow(line);
                rows.add(rowData);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
        }
        return rows;
    }
    
    public class OrderRowMapper implements RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String orderId = parts[0];
            String foodId = parts[1];
            String foodName = parts[2];
            String portion = parts[3];
            String price = parts[4];            
            String status = parts[5];
            String dt = parts[6];
            String totalprice = parts[7];
            String DM = parts[8];
            String vendorId = parts.length > 9 ? parts[9] : null;
            String customerId = parts.length > 10 ? parts[10] : null;
            String runnerId = parts.length > 11 ? parts[11] : null;
            

            return new Object[]{orderId,foodId,foodName,portion,price,status,dt,totalprice,DM,vendorId,customerId,runnerId};
        }
    }

    public class ReviewRowMapper implements RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String foodReviewID  = parts[0];
            String orderId  = parts[1];
            String vendorId  = parts[2];
            String dt  = parts[3];
            String rating  = parts[4];            
            String comment  = parts[5];

            return new Object[]{foodReviewID,orderId,vendorId,dt,rating,comment};

        }
    }
    
    public class MenuRowMapper implements RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String foodID  = parts[0];
            String foodName  = parts[1];
            String price  = parts[2];
            String description  = parts[3];
            String vendorId  = parts[4];            

            return new Object[]{foodID,foodName,price,description,vendorId};
        }
    }
    
    
    public class CustomerRowMapper implements RowMapper {
    @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");

            // Check if parts array has at least 6 elements
            if (parts.length >= 6) {
                String customerId = parts[0];
                String customerName = parts[1];
                String customerPassword = parts[2];
                String customerEmail = parts[3];
                String customerPhoneNumber = parts[4];
                String balanceStr = parts[5];
                
                

                return new Object[]{customerId, customerName, customerPassword, customerEmail, customerPhoneNumber, balanceStr};
            } else {
                
                return null;
            }
        }
    }
    public class TransactionRowMapper implements RowMapper {
    
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            // Check if parts array has at least 6 elements
            if (parts.length >= 6) {
                String transactionID = parts[0];
                String customerID = parts[1];
                String purpose = parts[2];
                String transaction = parts[3];
                String date = parts[4];
                String balance = parts[5];
                return new Object[]{transactionID,customerID,purpose,transaction,date,balance};
            } else {
                return null;
            }
        }
    }
        
    public class BalanceNotificationRowMapper implements RowMapper {
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            if (parts.length >= 6) {
                String nId = parts[0];
                String customerId = parts[1];
                String customerName = parts[2];
                String date = parts[3];
                String TopUp = parts[4];
                String status = parts[5];

                return new Object[]{nId,customerId,customerName,date,TopUp,status};
            } else {
                return null;
           }
        }    
    }
}
   



