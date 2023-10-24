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
                if (systemFacade.signUp(firstName, lastName, email, newUsername, newPassword)) {
                    System.out.println("Sucessfully registered");
                } else {
                    System.out.println("Registration failed");
                }
                break;
        }
        keyboard.close();
    }

    // only allows user to login
    public void run2() {
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = keyboard2.nextLine();
        System.out.println("Enter your password");
        String password = keyboard2.nextLine();
        if (systemFacade.login(username, password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    // only allows user to sign up
    public void run3() {
        Scanner keyboard = new Scanner(System.in);
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
        if (systemFacade.signUp(firstName, lastName, email, newUsername, newPassword)) {
            System.out.println("Sucessfully registered");
        } else {
            System.out.println("Registration failed");
        }
    }

    public void scenario() {

    }
}