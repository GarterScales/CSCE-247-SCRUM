import java.util.Scanner;

public class UI {
    private SystemFACADE systemFacade;

    public UI() {
        systemFacade = new SystemFACADE();
    }

    public void run() {
        UserList userList = UserList.getInstance();
        ProjectList projectList = ProjectList.getInstance();
        projectList.printProjects();

        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("Would you like to: ");
        // System.out.println("1. Login");
        // System.out.println("2. Sign up");
        // int choice = keyboard.nextInt();
        // keyboard.nextLine();
        // switch (choice) {
        // case 1:
        // System.out.println("Enter your username");
        // String username = keyboard.nextLine();
        // System.out.println("Enter your password");
        // String password = keyboard.nextLine();
        // if (systemFacade.login(username, password)) {
        // System.out.println("Login successful");
        // } else {
        // System.out.println("Login failed");
        // }
        // break;

        // case 2:
        // System.out.println("Enter your first name");
        // String firstName = keyboard.nextLine();
        // System.out.println("Enter your last name");
        // String lastName = keyboard.nextLine();
        // System.out.println("Enter your email");
        // String email = keyboard.nextLine();
        // System.out.println("Enter your username");
        // String newUsername = keyboard.nextLine();
        // System.out.println("Enter your password");
        // String newPassword = keyboard.nextLine();
        // switch (systemFacade.signUp(firstName, lastName, email, newUsername,
        // newPassword)) {
        // case 0:
        // System.out.println("Sucessfully registered");
        // break;
        // case 1:
        // System.out.println(
        // "Password insufficient, please use at least one upper case, one lower case,
        // and one digit.");
        // break;
        // case 2:
        // System.out.println("Username already exists, please choose a new Username.");
        // break;
        // }
        // break;
        // }
        // keyboard.close();
    }

    public void scenario() {

    }
}