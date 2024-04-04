/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Walter
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private List<User> users;
  
    public User(){
        
    }
    
    public User(String id,String username, String password, String email, String phoneNumber){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
    }
    public User(String username, String password, String email, String phoneNumber){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber; 
    }
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean login(String Email, String Password,String role){
        DB db = new DB(role);
        ArrayList<String> data = db.readFile();
        for(String line : data){
            String[] value = line.split(",");
            if(value[3].equals(Email) && value[2].equals(Password)){
                this.id = value[0];
                this.username = value[1];
                this.email = value[3];
                return true;
            }
        }
        return false;
    }
    
    
    
    public void delete(String id, String role) throws IOException{
        DB db = new DB(role);
        ArrayList<String> data = db.readFile();
        List<String> updatedData = new ArrayList<>();
        for (String line : data) {
            String[] value = line.split(",");
            if (!value[0].equals(id)) {
                updatedData.add(line);
            }
        }
        db.writeFile(updatedData);
        db.closeResources();
        }
    
 }

