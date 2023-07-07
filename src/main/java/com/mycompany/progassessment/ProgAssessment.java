/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progassessment;

import javax.swing.JOptionPane;
/**
 *
 * @author Reuven-Jon
 */
public class ProgAssessment {
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome! Please register.");

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        Login login = new Login(username, password, firstName, lastName);

        boolean registrationResult = login.registerUser(firstName, lastName, username, password);
         

        if (registrationResult) {
            JOptionPane.showMessageDialog(null, "Registration successful. Please log in to continue.");

            String enteredUsername = JOptionPane.showInputDialog("Enter your username:");
            String enteredPassword = JOptionPane.showInputDialog("Enter your password:");

            boolean loginStatus = login.loginUser(enteredUsername, enteredPassword);
            String message = login.returnLoginStatus(loginStatus);
            JOptionPane.showMessageDialog(null, message);

            if (loginStatus) {
               JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
               displayMenu(login);
               
                
              
                
            }
        }
    }
    
    public static void displayMenu(Login login){
        boolean exit = false;
        while (!exit){
            String choiceString = JOptionPane.showInputDialog("""
               Main Menu:
               1. Add Task
               2. Show Report
               3. Quit
               Enter your choice (1-3):""");
            int choice = Integer.parseInt(choiceString);
            
            switch (choice){
                case 1:
                    Task task = createTaskFromUserInput();
                    login.addTask(task);
                    JOptionPane.showMessageDialog(null, "Task succesfully added");
                    break;
                    
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming soon...");
                    break;
                    
                case 3:
                    exit = true;
                    JOptionPane.showMessageDialog(null, "Quitting Program.");
                    
                default: 
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again. " );
                    break;
            }
        }
    }
    
    public static Task createTaskFromUserInput(){
        String taskName = JOptionPane.showInputDialog("Enter the task name: ");
        String taskDescription = JOptionPane.showInputDialog("Enter the task description: ");
        String developerFirstName = JOptionPane.showInputDialog("Enter the developer's firstname: ");
        String developerLastName = JOptionPane.showInputDialog("Enter the developer's lastname: ");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration (in hours)"));
        
        Task task = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration);
        return task;
    }
}




       