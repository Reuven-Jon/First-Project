/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassessment;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author Reuven-Jon
 */
public class Task {

  
    private static int taskCount = 0;
    private static int totalTaskDuration = 0;
    private static List<Task> tasks = new ArrayList<>();
     
     
    private String taskName;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private int taskNumber;
   
    
    
     public Task (String taskName, String taskDescription, String developerFirstName, int taskDuration, String developerLastName){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = "To Do";
        this.taskNumber = taskCount++;
        totalTaskDuration += taskDuration;
    }
    
    
    
    
    
    Task(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Task() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    //Getters and Setters
    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @param taskDescription the taskDescription to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @param developerFirstName the developerFirstName to set
     */
    public void setDeveloperFirstName(String developerFirstName) {
        this.developerFirstName = developerFirstName;
    }

    /**
     * @param developerLastName the developerLastName to set
     */
    public void setDeveloperLastName(String developerLastName) {
        this.developerLastName = developerLastName;
    }

    /**
     * @param taskDuration the taskDuration to set
     */
    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
   
    /**
     * @return the totalTaskDuration
     */
    public static int getTotalTaskDuration() {
        return totalTaskDuration;
    }
     /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @return the developerFirstName
     */
    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    /**
     * @return the developerLastName
     */
    public String getDeveloperLastName() {
        return developerLastName;
    }

    /**
     * @return the taskDuration
     */
    public int getTaskDuration() {
        return taskDuration;
    }

 
    public String getTaskStatus() {
        return taskStatus;
    }
   
    
   //This checks if the task description is valid.
    public boolean checkTaskDescription(){
        return taskDescription.length() <= 50;
    }
        
   //Generates a random TaskID using UUID
    public String createTaskID(){
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastNameInitials = developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return initials + ";" + taskNumber + ";" + lastNameInitials;
    }
    
     //Generates the TaskID based on the name of the developer and the task name.
    public String getTaskID(){
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastNameInitials = developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return initials + ":" + taskNumber + ":" + lastNameInitials;
    }
    
    //Prints the details of the task.
    public String printTaskDetails(){
        return "Task Status: " + getTaskStatus() + "\n" +
                "Developer: " + getDeveloperFirstName() + " " + getDeveloperLastName() + "\n" +
                "Task Name: " + getTaskName() + "\n" + 
                "Task Description: " + getTaskDescription() + "\n" +               
                "Task Duration: " + getTaskDuration() + "hours"; 
    }
    
    //This method will return the total task duration. 
    public static int returnTotalHours(){
        return getTotalTaskDuration();
    }

    //Main method to start the kanban app.
public void startKanbanApp(){
    while (true){
    int choice = showMainMenu();

    switch(choice){
        case 1:
            addTask();
            break;
            
        case 2:
            showReport();
            break;
            
        case 3:
            JOptionPane.showMessageDialog(null, "Quitting program. ");
            System.exit(0);
            break;
            
        default:
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            break;
}

}
}

//Shows the main menu and return the user's choice. 
private int showMainMenu(){
    String choiceString = JOptionPane.showInputDialog("""
                                                      Main Menu:
                                                      1. Add Task
                                                      2. Show Report
                                                      3. Quit
                                                      Enter your choice (1-3):""");
    return Integer.parseInt(choiceString);
}

//Adds a new task.
private void addTask(){
    
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = null;
        boolean validDescription = false;
        
        while(!validDescription){
            taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            
            if(taskDescription.length() <= 50){
                validDescription = true;
            }else{
                JOptionPane.showMessageDialog(null, "Task Description should not exceed 50 characters. Please try again. ");
                
            }
            }
        
        String developerFirstName = JOptionPane.showInputDialog("Enter Developer's firstname:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration: "));
        String developerLastName = JOptionPane.showInputDialog("Enter Developer's lastname: ");
        
        Task task = new Task(taskName, taskDescription, developerFirstName, taskDuration, developerLastName );
        tasks.add(task);
        
        JOptionPane.showMessageDialog(null, "Task successfully added.");
    
        
    }
        

private void showReport(){
    JOptionPane.showMessageDialog(null, "Coming Soon...");
}
}