/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Walter
 */
public class Runner extends User {
    DB rdb = new DB("Runner");
    public Runner( String id,String username, String password, String email, String phoneNumber) {
        super(id,username, password, email, phoneNumber);
    }
    public Runner( String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }
    
    public Runner(){
        
    }
    

    public void register() throws IOException{
        rdb.writeFile();
        rdb.bw.write(rdb.id + "," + this.getUsername()+ "," + this.getPassword()+ "," + this.getEmail() + "," + this.getPhoneNumber());
        rdb.bw.newLine();
        rdb.closeResources();
    }
    
    public void update(String userId, String updatedUsername, String updatedPassword, String updatedEmail, String updatedPhoneNumber) {
        ArrayList<String> rdata = rdb.readFile();
        List<String> updatedData = new ArrayList<>();

        for (String line : rdata) {
            String[] value = line.split(",");
            if (value.length >= 5 && value[0].trim().equals(userId.trim())) {
                // Update the user's information
                value[1] = updatedUsername;
                value[2] = updatedPassword;
                value[3] = updatedEmail;
                value[4] = updatedPhoneNumber;
            }
            updatedData.add(String.join(",", value));
        }

        try {
            rdb.writeFile(updatedData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            rdb.closeResources();
        }
    }
    
//    public Runner(){
//        
//    }
//    
 
    
}
