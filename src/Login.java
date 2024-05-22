
import java.util.Scanner;
import javax.swing.JOptionPane;
//ST10449610
public class Login {

    // DECLARATIONS
    String loginUsername; 
    String loginPassword; 
    String regFirstname;  
    String regLastname; 
    String password;
    String username; 

    //METHOD TO CHECK THE USERNAME COMPLEXITY
    public boolean checkUsername() {

        boolean check = false;
        for (int i = 0; i < username.length(); i++) {
            if (username.length() <= 5) {

                if ((int) username.charAt(i) == 95) {
                    check = true;
                }
            }
        }
        return check;
    }

    //METHOD TO CHECK IF THE PASSWORD REQUIREMENTS WERE MET
    public boolean checkPasswordComplexity() {

        boolean CapitalLetter = false;
        boolean Number = false;
        boolean Special = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.length() >= 8) {
                if ((int) password.charAt(i) > 65 && (int) password.charAt(i) <= 90) {
                    CapitalLetter = true;
                }
                if ((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57) {
                    Number = true;
                }
                if ((int) password.charAt(i) >= 33 && (int) password.charAt(i) <= 47
                        || (int) password.charAt(i) >= 58 && (int) password.charAt(i) <= 64
                        || (int) password.charAt(i) >= 91 && (int) password.charAt(i) <= 96
                        || (int) password.charAt(i) >= 123 && (int) password.charAt(i) <= 126) {
                    Special = true;
                }
            }

        }
        return CapitalLetter && Number && Special;
    }

    
    public String registerUser() {

        if (checkUsername() == true) {
            System.out.println("Username succefully captured.");
        } else {
            System.out.println("Username is not correctly formatted,please ensure that your Username contains an underscore and is no more than 5 characters in length.");
        }
        if (checkPasswordComplexity() == true) {
            System.out.println("Password succefully captured.");
        } else {
            System.out.println("Password is not correctly formatted please ensure that the password contains atleast 8characters, a capital letter , a number and a special character.");
        }
        if (checkUsername() == true && (checkPasswordComplexity() == true)) {
            System.out.println("The two above conditions have been met and the user has been registered succefully.");

        }
        if (checkPasswordComplexity() == false) {
            System.out.println("The Password does not meet the complexity requirements.");
        }
        if (checkUsername() == false) {
            System.out.println("The username is incorrectly formatted.");

        }

        return ("");
    }
    //METHOD TO CHECK IF THE ENTERED PASSWORD  AND USERNAME = REGISTERED USERNAME & PASSWORD
    public boolean loginUser() {

        boolean Compare = false;

        if (username.equals(loginUsername) && (password.equals(loginPassword))) {

            Compare = true;
        }
        return Compare;
    }
    // THIS METHOD RETURNS THE USER'S LOGIN STATUS

    public String returnLoginStatus() {

        if (loginUser() == true) {

            System.out.println("Successful login");

            System.out.println("welcome " + " " + regFirstname + " " + " " + " " + regLastname + " " + " it is great to see you again ");

        } else {

            System.out.println("A failed login");
            System.out.println("Username or Password incorrect please try again");

        }

        return "";
    }

    public static void main(String[] args) {
        Login login = new Login();
        Task info = new Task();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Firstname :");
        login.regFirstname = input.next();
        System.out.println("Enter Lastname :");
        login.regLastname = input.next();
        System.out.println("Enter Username :");
        login.username = input.next();
        System.out.println("Enter Password :");
        login.password = input.next();

        System.out.println(login.registerUser());
        if (login.checkUsername() == true & (login.checkPasswordComplexity()) == true) {
        //CHECKING USERNAME AND PASSWORD
        
            System.out.println("Enter Username :");
            login.loginUsername = input.next();
            System.out.println("Enter Password :");
            login.loginPassword = input.next();

            System.out.println(login.returnLoginStatus());
        }
        if (login.loginUser() == true) {
            JOptionPane.showMessageDialog(null, "Welcome, it is great to see you.");
            int choice;
            do {

                info.input = JOptionPane.showInputDialog("Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");
                choice = Integer.parseInt(info.input);

                switch (choice) {
                    case 1:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                        Task task = new Task();
                        int totalHours = 0;
                        
                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name:");
                            info.taskDescription = JOptionPane.showInputDialog("Enter task description:");
                            
                            while (info.checkTaskDescription() == false) {
                                JOptionPane.showMessageDialog(null, "Task defination incorrectly formatted, please try again");
                                info.taskDescription = JOptionPane.showInputDialog("Enter task description: ");
                            }
                            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
                            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration:"));

                            String taskID = task.createTaskID(taskName, i, developerLastName);
                            String taskStatus = "";

                            int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose the Status of this task from the three options.\n"
                                    + "1.To Do\n"
                                    + "2.Doing\n"
                                    + "3.Done"));
                            switch (option) {
                                case 1:
                                    taskStatus = "To Do";
                                    break;
                                case 2:
                                    taskStatus = "Doing";
                                    break;
                                case 3:
                                    taskStatus = "Done";
                                    break;
                            }
                            String taskDetails = task.printTaskDetails(taskStatus, developerFirstName, developerLastName,
                                    i, taskName, info.taskDescription, taskID, taskDuration);
                            JOptionPane.showMessageDialog(null, taskDetails);

                            totalHours += taskDuration;
                        }

                        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting the application.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 3);
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
        }
    }
}
