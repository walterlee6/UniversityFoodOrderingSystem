/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class GUI {
    public void OpenPage(JFrame frame) {
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void callPage(String pageName, User u){
        // page name just same as the class name
        JFrame page = null;
    
        switch (pageName) {
            case "EWallet":
                page = new EWallet(u);
                break;
            case "CustomerFoodMenu":
                page = new CustomerFoodMenu(u);
                break;
            case "CustomerProfile":
                page = new CustomerProfile(u);
                break;
            case "CustomerProfilePage":
                page = new CustomerProfilePage(u);
                break;
            case "CustomerTransactionHistory":
                page = new CustomerTransactionHistory(u);
                break;
            case "CustomerOrderHistory":
                page = new CustomerOrderHistory(u);
                break;
            case "CustomerOrderStatus":
                page = new CustomerOrderStatus(u);
                break;
            case "CustomerFoodReview":
                page = new CustomerFoodReview(u);
                break;
            case "VendorOrderHistory":
                page = new VendorOrderHistory(u);
                break;
            case "VendorOrderPage":
                page = new VendorOrderPage(u);
                break;
            case "VendorFoodMenu":
                page = new VendorFoodMenu(u);
                break;
            case "AccountRegistration":
                page = new AccountRegistration(u);
                break;
            case "AdminDashboard":
                page = new AdminDashboard(u);
                break;
            case "RunnerFrame":
                page = new RunnerFrame(u);
                break;
            case "RunnerHistory":
                page = new RunnerHistory(u);
                break;
            case "NotificationPage":
                page = new NotificationPage(u);
                break;
            case "TopUpPage":
                page = new TopUpPage(u);
                break;
            case "GenerateReceiptPage":
                page = new GenerateReceiptPage(u);
                break;
            case "loginPage":
                page = new loginPage(u);
                break;
            case "BalanceNotifcationPage":
                page = new BalanceNotifcationPage(u);
                break;
            case "TopUpNotification":
                page = new TopUpNotification(u);
                break;
            case "RunnerReview":
                page = new RunnerReview(u);
                break;
            default:
                throw new IllegalArgumentException("Invalid page: " + pageName);
        }

        if (page != null) {
            OpenPage(page);
        }
    }
}
