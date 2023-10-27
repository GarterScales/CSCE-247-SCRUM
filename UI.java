import java.util.ArrayList;
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
                switch (systemFacade.signUp(firstName, lastName, email, newUsername,
                        newPassword)) {
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

    public void runPrintData() {
        UserList userList = UserList.getInstance();
        ProjectList projectList = ProjectList.getInstance();
        projectList.printProjects();
    }

    public void run2() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to view your projects?");
        System.out.println("1. Yes 2. No");
        int projectChoice = keyboard.nextInt();
        keyboard.nextLine();

        if (projectChoice == 1) {
            // list projects
            ProjectList projectList = ProjectList.getInstance();
            ArrayList<Project> projects = projectList.viewProjects();

            for (int i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                System.out.println((i + 1) + " " + project.getName());
            }

            // add and/or remove projects
            System.out.println("Would you like to 1. add or 2. remove");
            int addRemove = keyboard.nextInt();
            if (addRemove == 1) {
                // add project
                System.out.println("Enter the name of the project you would like to add");
                String addName = keyboard.nextLine();
                ProjectList.addProject(addName);
            } else if (addRemove == 2) {
                // remove project
                System.out.println("Enter the name of the project you would like to remove");
                String removeName = keyboard.nextLine();
                ProjectList.removeProject(removeName);
            } else {
                System.out.println("Please enter a valid choice");
            }

            System.out.println("Which project would you like to view?");
            int projectView = keyboard.nextInt();

            if (projectView > 0 && projectView <= projects.size()) {
                // user views selected project
                Project selectedProject = projects.get(projectView - 1);
                System.out.println(selectedProject.toString());

            } else {
                System.out.println("Please enter a valid choice");
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