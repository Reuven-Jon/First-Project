/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassessment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Reuven-Jon
 */
public class Login {
    
private User user;
private List<Task> tasks; 
private List<String> developers;
private List<String> taskNames;
private List<Integer> taskIDs;
private List<Integer> taskDurations;
private List<String> taskStatuses;

public Login(String userName, String passWord, String firstName, String lastName){
    User newUser = new User();
    newUser.setFirstName(firstName);
    newUser.setLastName(lastName);
    newUser.setUserName(userName);
    newUser.setPassWord(passWord);
    this.user = newUser;
    this.tasks = new ArrayList<>();
    this.developers = new ArrayList<>() ;
    this.taskNames = new ArrayList<>();
    this.taskIDs = new ArrayList<>();
    this.taskDurations = new ArrayList<>();
    this.taskStatuses = new ArrayList<>();
}
    
public boolean registerUser(String firstName, String lastName, String userName, String passWord){
    boolean userNameAvailable = checkUserName(userName);
    boolean passwordComplexityMet = checkPasswordComplexity(passWord);
    
    if (userNameAvailable && passwordComplexityMet){
        return true;
    }else if(!userNameAvailable){
        JOptionPane.showMessageDialog(null,"Username is unavailable or does not meet the specified requirements. ");
    }else if(!passwordComplexityMet){
        JOptionPane.showMessageDialog(null, "Password does not meet the complexity requirements.");
    }else{
        JOptionPane.showMessageDialog(null, "An error occured while processing your registration requirements. ");
    }
    return false;
    }

public boolean loginUser(String enteredUsername, String enteredPassword){
    if (!enteredUsername.equals(user.getUserName())|| !enteredPassword.equals(user.getPassWord())){
        JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again. ");
        
        enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        enteredPassword = JOptionPane.showInputDialog("Enter your password:");
        
        return loginUser(enteredUsername, enteredPassword);
    }
    
    if (!isUsernameValid(enteredUsername)){
        JOptionPane.showMessageDialog(null,"Invalid username format. Please try again. ");
        
        enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        enteredPassword = JOptionPane.showInputDialog("Enter your password:");
        
        return loginUser(enteredUsername, enteredPassword);
    }
    
    if(!isPasswordValid(enteredPassword)){
        JOptionPane.showMessageDialog(null, "Invalid password format. Please try again.");
        
        enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        enteredPassword = JOptionPane.showInputDialog("Enter your password:");
        
        return loginUser(enteredUsername, enteredPassword);
    }
    
    return true;
}

public String returnLoginStatus(boolean successfulLogin){
    if (successfulLogin){
        return "Welcome" + user.getFirstName() + " " + user.getLastName() + ". It is nice to see you again.";
    }else{
        return "Invalid login credentials. Please try again.";
    }
}

 public void addTask(Task task) {
             if (user != null) {
            tasks.add(task);
            updateArrays(task);
            JOptionPane.showMessageDialog(null, "Task successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "You must log in before adding tasks.");

            // Prompt for task details and create a new task object
            String taskName = JOptionPane.showInputDialog("Enter Task Name: ");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description: ");
            String developerFirstName = JOptionPane.showInputDialog("Enter Developer's Firstname: ");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration: "));
            String developerLastName = JOptionPane.showInputDialog("Enter Developer's Lastname: ");



            Task newTask = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration);
            tasks.add(newTask);
            updateArrays(newTask);
            JOptionPane.showMessageDialog(null, "Task successfully added.");
        }
    }
 
 
 void updateArrays(Task task){
   // Update developers array
        developers.add(task.getDeveloperLastName());

        // Update taskNames array
        taskNames.add(task.getTaskName());

        // Update taskIDs array
        taskIDs.add(Integer.valueOf(task.getTaskID()));

        // Update taskDurations array
        taskDurations.add(task.getTaskDuration());

        // Update taskStatuses array
        taskStatuses.add(task.getTaskStatus());
 }
 
 public void displayTasksWithStatusDone(){
     StringBuilder tasksInfo = new StringBuilder();
        tasksInfo.append("Tasks with Status 'Done':\n");

        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equals("Done")) {
                tasksInfo.append("Developer: ").append(developers.get(i))
                        .append(", Task Name: ").append(taskNames.get(i))
                        .append(", Duration: ").append(taskDurations.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, tasksInfo.toString());
    }
 
 public void displayLongestTaskDuration(){
     int maxDuration = 0;
     int maxDurationIndex = -1;
     
     for (int i = 0; i < taskDurations.size(); i++){
         if(taskDurations.get(i) > maxDuration){
             maxDuration = taskDurations.get(i);
             maxDurationIndex = i;
         }
     }
     
     if(maxDurationIndex != -1){
         String developer = developers.get(maxDurationIndex);
         int duration = taskDurations.get(maxDurationIndex);
         
         JOptionPane.showMessageDialog (null, "Developer: "+ developer + ", Duration: "+ duration);
     }else{
         JOptionPane.showMessageDialog(null, "No tasks found.");
                 
     }
 }
 
 public void searchTaskByName(String taskName){
     boolean found = false;
     StringBuilder taskInfo = new StringBuilder();
     
     for(int i = 0; i < taskNames.size(); i++){
         if(taskNames.get(i).equals(taskName)){
             found = true;
             taskInfo.append("Task Name: ").append(taskNames.get(i))
                     .append(", Developer: ").append(developers.get(i))
                     .append(", Task Status: ").append(taskStatuses.get(i)).append("\n");
         }
     }
     
     if(found){
         JOptionPane.showMessageDialog(null, taskInfo.toString());
     }else{
         JOptionPane.showMessageDialog(null , "No task found with the given name.");
     }
 }
 
  public void searchTasksByDeveloper(String developerName) {
        boolean found = false;
        StringBuilder tasksInfo = new StringBuilder();

        for (int i = 0; i < developers.size(); i++) {
           
            if (developers.get(i).equals(developerName)) {
                found = true;
                tasksInfo.append("Task Name: ").append(taskNames.get(i))
                        .append(", Task Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, tasksInfo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for the given developer.");
        }
    }
  
  public void deleteTaskByName(String taskName) {
        boolean found = false;
        int index = -1;

        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(taskName)) {
                found = true;
                index = i;
                break;
            }
        }

        if (found) {
            tasks.remove(index);
            developers.remove(index);
            taskNames.remove(index);
            taskIDs.remove(index);
            taskDurations.remove(index);
            taskStatuses.remove(index);
            JOptionPane.showMessageDialog(null, "Task successfully deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "No task found with the given name.");
        }
    }
  
  public void displayTaskReport(){
      StringBuilder tasksInfo = new StringBuilder();
      tasksInfo.append("Task Report:\n");
      
      for(int i = 0; i < tasks.size(); i++){
          tasksInfo.append(tasks.get(i).printTaskDetails()).append("\n");
      }
      
      JOptionPane.showMessageDialog(null, tasksInfo.toString());
  }



public void displayTasks(){
    if(!tasks.isEmpty()){
        StringBuilder tasksInfo = new StringBuilder();
        tasksInfo.append("Tasks:\n");
        
        for (Task task : tasks){
            tasksInfo.append(task.printTaskDetails()).append("\n");
        }
        
        tasksInfo.append("Total hours acr5oss all tasks: ").append(returnTotalHours());
        
        JOptionPane.showMessageDialog(null, tasksInfo.toString());
    }else{
        JOptionPane.showMessageDialog(null, "No tasks found.");
    }
}

public int returnTotalHours() {
    return tasks.stream().mapToInt(Task::getTaskDuration).sum();
}

private boolean isUsernameValid(String username){
    return username.length() <= 5 && username.contains("_");
}   

private boolean isPasswordValid(String password){
    boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");
    boolean hasMinLength = password.length() >= 8;
    boolean hasNumber = password.matches(".*\\d.*");
    boolean hasCapitalLetter = password.matches(".*[A-Z].*");
    
    return hasSpecialChar && hasMinLength && hasNumber && hasCapitalLetter;
}

private boolean checkUserName(String userName) {
        if (userName.length() <= 5 && userName.contains("_")) {
            System.out.println("Username successfully captured.");
            return true;
        } else {
            System.out.println("Username is incorrectly formatted. Please make sure your username is no longer than 5 characters long and contains an underscore.");
            return false;
        }
    }
    
    private boolean checkPasswordComplexity(String passWord) {
        boolean hasSpecialChar = passWord.matches(".*[!@#$%^&*()].*");
        boolean hasMinLength = passWord.length() >= 8;
        boolean hasNumber = passWord.matches(".*[!@#$%^&*()].*");
        boolean hasCapitalLetter = passWord.matches(".*[A-Z].*");
        
        return hasMinLength && hasSpecialChar && hasNumber && hasCapitalLetter;
    }
}







    

 
    


            
        
              
        
    

