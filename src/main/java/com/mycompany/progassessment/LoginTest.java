 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class LoginTest {

@Test
void testUsernameCorrectlyFormatted(){
    User user = new User();
    user.setFirstName("Kyle");
    user.setLastName("Smith");
    user.setUserName("kyl_1");
    user.setPassWord("Ch&&sec@ke99!");
    
    String expected = "Welcome Kyle, Smith. It is great to see you.";
    Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
    boolean result = login.loginUser(user.getUserName(), user.getPassWord());
    Assertions.assertTrue(result, "Failed testUsernameCorrectlyFormatted");
    Assertions.assertEquals(expected, login.returnLoginStatus(result),"Failed testUsernameCorrectlyFormatted" );
}

 @Test
    void testUsernameIncorrectlyFormatted() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyle!!!!!!!");
        user.setPassWord("Ch&&sec@ke99!");

        String expected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters long. Please try again.";
        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        boolean result = login.loginUser(user.getUserName(), user.getPassWord());
        Assertions.assertFalse(result, "Failed testUsernameIncorrectlyFormatted");
        Assertions.assertEquals(expected, login.returnLoginStatus(result), "Failed testUsernameIncorrectlyFormatted");
    }

    @Test
    void testPasswordMeetsComplexityRequirements() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");

        String password = "Ch&&sec@ke99!";
        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        boolean result = login.loginUser(user.getUserName(), password);
        Assertions.assertTrue(result, "Failed testPasswordMeetsComplexityRequirements");
    }

    @Test
    void testPasswordDoesNotMeetComplexityRequirements() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");

        String password = "password";
        Login login = new Login(user.getUserName(), "", user.getFirstName(), user.getLastName());
        boolean result = login.loginUser(user.getUserName(), password);
        Assertions.assertFalse(result, "Failed testPasswordDoesNotMeetComplexityRequirements");
    }

    @Test
    void testLoginSuccessful() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");
        user.setPassWord("Ch&&sec@ke99!");

        String expected = "Welcome Kyle, Smith. It is nice to see you again.";
        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        boolean result = login.loginUser(user.getUserName(), user.getPassWord());
        Assertions.assertTrue(result, "Failed testLoginSuccessful");
        Assertions.assertEquals(expected, login.returnLoginStatus(result), "Failed testLoginSuccessful");
    }

    @Test
    void testLoginFailed() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");
        user.setPassWord("Ch&&sec@ke99!");

        String expected = "Invalid username or password. Please try again. ";
        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        boolean result = login.loginUser("incorrect_username", "incorrect_password");
        Assertions.assertFalse(result, "Failed testLoginFailed");
        Assertions.assertEquals(expected, login.returnLoginStatus(result), "Failed testLoginFailed");
    }

    @Test
    void testAddTask() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");
        user.setPassWord("Ch&&sec@ke99!");

        Task task = new Task();
        task.setTaskName("Task 1");
        task.setTaskDescription("Description for Task 1");
        task.setDeveloperFirstName("John");
        task.setTaskDuration(5);
        task.setDeveloperLastName("Doe");

        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        login.addTask(task);

        Assertions.assertEquals(5, login.returnTotalHours(), "Failed testAddTask");
    }

    @Test
    void testDisplayTasks() {
        User user = new User();
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setUserName("kyl_1");
        user.setPassWord("Ch&&sec@ke99!");

        Task task1 = new Task();
        task1.setTaskName("Task 1");
        task1.setTaskDescription("Description for Task 1");
        task1.setDeveloperFirstName("John");
        task1.setTaskDuration(5);
        task1.setDeveloperLastName("Doe");

        Task task2 = new Task();
        task2.setTaskName("Task 2");
        task2.setTaskDescription("Description for Task 2");
        task2.setDeveloperFirstName("Jane");
        task2.setTaskDuration(3);
        task2.setDeveloperLastName("Doe");

        Login login = new Login(user.getUserName(), user.getPassWord(), user.getFirstName(), user.getLastName());
        login.addTask(task1);
        login.addTask(task2);

        login.displayTasks();
}
    
      @Test
    void testPopulatedDeveloperArray() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setDeveloperLastName("Mike Smith");
        Task task2 = new Task();
        task2.setDeveloperLastName("Edward Harrison");
        Task task3 = new Task();
        task3.setDeveloperLastName("Samantha Paulson");
        Task task4 = new Task();
        task4.setDeveloperLastName("Glenda Oberholzer");

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Check if the developer array contains the expected data
        Assertions.assertEquals("Mike Smith", login.getDevelopers().get(0), "Failed testPopulatedDeveloperArray");
        Assertions.assertEquals("Edward Harrison", login.getDevelopers().get(1), "Failed testPopulatedDeveloperArray");
        Assertions.assertEquals("Samantha Paulson", login.getDevelopers().get(2), "Failed testPopulatedDeveloperArray");
        Assertions.assertEquals("Glenda Oberholzer", login.getDevelopers().get(3), "Failed testPopulatedDeveloperArray");
    }

    @Test
    void testDisplayDeveloperAndDurationForLongestTaskDuration() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setDeveloperLastName("Mike Smith");
        task1.setTaskDuration(5);
        Task task2 = new Task();
        task2.setDeveloperLastName("Edward Harrison");
        task2.setTaskDuration(8);
        Task task3 = new Task();
        task3.setDeveloperLastName("Samantha Paulson");
        task3.setTaskDuration(2);
        Task task4 = new Task();
        task4.setDeveloperLastName("Glenda Oberholzer");
        task4.setTaskDuration(11);

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Check if the developer and duration for the task with the longest duration is displayed correctly
        Assertions.assertEquals("Glenda Oberholzer, 11", login.displayLongestTaskDuration(), "Failed testDisplayDeveloperAndDurationForLongestTaskDuration");
    }

    @Test
    void testSearchForTask() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setTaskName("Create Login");
        task1.setDeveloperLastName("Mike Smith");
        Task task2 = new Task();
        task2.setTaskName("Create Add Features");
        task2.setDeveloperLastName("Edward Harrison");
        Task task3 = new Task();
        task3.setTaskName("Create Reports");
        task3.setDeveloperLastName("Samantha Paulson");
        Task task4 = new Task();
        task4.setTaskName("Add Arrays");
        task4.setDeveloperLastName("Glenda Oberholzer");

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Search for a task and check if the task name, developer, and task status are displayed correctly
        Assertions.assertEquals("Create Login, Mike Smith, To Do", login.searchForTask("Create Login"), "Failed testSearchForTask");
    }

    @Test
    void testSearchTasksAssignedToDeveloper() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setTaskName("Create Login");
        task1.setDeveloperLastName("Mike Smith");
        Task task2 = new Task();
        task2.setTaskName("Create Add Features");
        task2.setDeveloperLastName("Edward Harrison");
        Task task3 = new Task();
        task3.setTaskName("Create Reports");
        task3.setDeveloperLastName("Samantha Paulson");
        Task task4 = new Task();
        task4.setTaskName("Add Arrays");
        task4.setDeveloperLastName("Glenda Oberholzer");

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Search for tasks assigned to a developer and check if the task names and task statuses are displayed correctly
        Assertions.assertEquals("Create Reports, Done", login.searchTasksAssignedToDeveloper("Samantha Paulson"), "Failed testSearchTasksAssignedToDeveloper");
    }

    @Test
    void testDeleteTask() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setTaskName("Create Login");
        task1.setDeveloperLastName("Mike Smith");
        Task task2 = new Task();
        task2.setTaskName("Create Add Features");
        task2.setDeveloperLastName("Edward Harrison");
        Task task3 = new Task();
        task3.setTaskName("Create Reports");
        task3.setDeveloperLastName("Samantha Paulson");
        Task task4 = new Task();
        task4.setTaskName("Add Arrays");
        task4.setDeveloperLastName("Glenda Oberholzer");

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Delete a task and check if it is successfully removed from the arraysAssertions.assertTrue(login.getTaskNames().contains("Create Reports"), "Failed testDeleteTask: Task should exist before deletion");

        login.deleteTask("Create Reports");

        Assertions.assertFalse(login.getTaskNames().contains("Create Reports"), "Failed testDeleteTask: Task should be deleted");
    }

    @Test
    void testDisplayReport() {
        Login login = new Login("", "", "", "");

        // Add tasks to the login object
        Task task1 = new Task();
        task1.setTaskName("Create Login");
        task1.setDeveloperLastName("Mike Smith");
        Task task2 = new Task();
        task2.setTaskName("Create Add Features");
        task2.setDeveloperLastName("Edward Harrison");
        Task task3 = new Task();
        task3.setTaskName("Create Reports");
        task3.setDeveloperLastName("Samantha Paulson");
        Task task4 = new Task();
        task4.setTaskName("Add Arrays");
        task4.setDeveloperLastName("Glenda Oberholzer");

        login.updateArrays(task1);
        login.updateArrays(task2);
        login.updateArrays(task3);
        login.updateArrays(task4);

        // Display the report and check if it is displayed correctly
        Assertions.assertEquals("Tasks with Status 'Done':\nDeveloper: Samantha Paulson, Task Name: Create Reports, Duration: 2\n", login.displayTasksWithStatusDone(), "Failed testDisplayReport");
    
    
}

}
   

    




   
    




