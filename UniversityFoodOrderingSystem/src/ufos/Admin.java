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
public class Admin extends User{
    DB adb = new DB("Admin");
    public Admin(String id,String username, String password, String email, String phoneNumber) {
        super(id,username, password, email, phoneNumber);
    }
    public Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }
    
    public Admin(){
        
    }
    
    public void register() throws IOException{
        adb.writeFile();
        adb.bw.write(adb.id + "," + this.getUsername()+ "," + this.getPassword()+ "," + this.getEmail() + "," + this.getPhoneNumber());
        adb.bw.newLine();
        adb.closeResources();
    }
    
    public void update(String userId, String updatedUsername, String updatedPassword, String updatedEmail, String updatedPhoneNumber) {
        
        ArrayList<String> adata = adb.readFile();
        List<String> updatedData = new ArrayList<>();

        for (String line : adata) {
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
            adb.writeFile(updatedData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            adb.closeResources();
        }
    }
    
}
