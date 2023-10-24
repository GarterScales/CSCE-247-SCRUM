import java.util.Scanner;

public class UI {
    private SystemFACADE systemFacade;

    public UI() {
        systemFacade = new SystemFACADE();
    }

    public void run() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to: ");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter your username");
                String username = keyboard.nextLine();
                System.out.println("Enter your password");
                String password = keyboard.nextLine();
                if (systemFacade.login(username, password)) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login failed");
                }
                break;

            case 2:
                System.out.println("Enter your first name");
                String firstName = keyboard.nextLine();
                System.out.println("Enter your last name");
                String lastName = keyboard.nextLine();
                System.out.println("Enter your email");
                String email = keyboard.nextLine();
                System.out.println("Enter your username");
                String newUsername = keyboard.nextLine();
                System.out.println("Enter your password");
                String newPassword = keyboard.nextLine();
                switch (systemFacade.signUp(firstName, lastName, email, newUsername, newPassword)) {
                    case 0:
                        System.out.println("Sucessfully registered");
                        break;
                    case 1:
                        System.out.println(
                                "Password insufficient, please use at least one upper case, one lower case, and one digit.");
                        break;
                    case 2:
                        System.out.println("Username already exists, please choose a new Username.");
                        break;
                }
                break;
        }
        keyboard.close();
    }

    public void run2() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to make a project?");
        System.out.println("1. Yes 2. No");
        int projectChoice = keyboard.nextInt();
        if (projectChoice == 1) {
            System.out.println("Would you like to add a task?");
            System.out.println("1. Yes 2. No");
            int taskChoice = keyboard.nextInt();
            if (taskChoice == 1) {

                // assigning task
                System.out.println("Would you like to assign the task to another memember?");
                int assignChoice = keyboard.nextInt();
                System.out.println("1. Yes 2. No");
                if (assignChoice == 1) {

                } else if (assignChoice == 2) {

                }

                // adding priority to task
                System.out.println("Would you like to add a priority to the task?");
                System.out.println("1. Yes 2. No");
                int priorityChoice = keyboard.nextInt();
                if (priorityChoice == 1) {
                    System.out.println(
                            "Would you like to assign the task as 1. highest priority, 2. medium priority, or 3. low priority");
                    int priorityRank = keyboard.nextInt();
                } else if (priorityChoice == 2) {

                }

                // edit task
                System.out.println("Would you like to edit the task?");
                int editChoice = keyboard.nextInt();
                if (editChoice == 1) {

                } else if (editChoice == 2) {

                }

                // add name to ask
                System.out.println("What would you like to name the task?");
                String taskName = keyboard.nextLine();

                // add type to task
                System.out.println("Would you like to add a type for the task?");
                int typeChoice = keyboard.nextInt();
                if (typeChoice == 1) {

                } else if (typeChoice == 2) {

                }

                // archive task
                System.out.println("Would you like to archive the task?");
                int archiveChoice = keyboard.nextInt();
                if (archiveChoice == 1) {

                } else if (archiveChoice == 2) {

                }

            } else if (taskChoice == 2) {
                System.out.println("Would you like to delete the project?");
                System.out.println("1. Yes 2. No");
                int deleteChoice = keyboard.nextInt();
                if (deleteChoice == 1) {
                    System.out.println("Goodbye");
                } else if (deleteChoice == 2) {

                }
            }
        } else if (projectChoice == 2) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Please enter a valid choice");
        }

    }

    public void scenario() {

    }
}