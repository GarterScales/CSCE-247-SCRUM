import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

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
        ProjectList projectList = ProjectList.getInstance();
        System.out.println(projectList.ProjectBoard());
    }

    public void runScenarioOne() {
        ProjectList projectList = ProjectList.getInstance();
        System.out.println(projectList.ProjectBoard());
        UserList userList = UserList.getInstance();
        SystemFACADE.currentUser = userList.getUserbyId(UUID.fromString("ac7dde12-f50c-4c3e-baf0-85268de6d5b0"));
        SystemFACADE.currentProject = projectList
                .selectProject(UUID.fromString("06a992aa-b849-432f-8730-cf80c1561450"));
        UUID jeffID = UUID.fromString("453eba52-95be-4bd8-9d07-1aca5dc3021a");

        System.out.println(
                "Adding a new task \"Initialize super algorithm to detonate at warp speed\". Assigning to Jeff Goldblum");

        SystemFACADE.currentProject.addTask("Initialize super algorithm to detonate at warp speed", "", 0, 0,
                jeffID, 0, "new feature");

        System.out.println("Adding Comment to super algorithm Task");

        SystemFACADE.currentProject
                .getTasks().get(SystemFACADE.currentProject
                        .getTasks().size() - 1)
                .addComment(new Comment(SystemFACADE.currentUser, "Avoid civilians Jeff", LocalDate.now(),
                        new ArrayList<Comment>()));

        Task metalTask = SystemFACADE.currentProject
                .getTaskbyId(UUID.fromString("babf9e9b-a5da-4330-8699-4a2f043f17a0"));
        System.out.println("Moving metal task to in progress");
        metalTask
                .getLog().reverseLog(LocalDate.now(), SystemFACADE.currentUser, "Not cylindrical");
        System.out.println("Replying to Jeff's Comment.");
        for (Comment comment : metalTask.getComments()) {
            if (comment.getCommenter() == userList.getUserbyId(jeffID)) {
                comment.addReply(
                        new Comment(SystemFACADE.currentUser, "How about you do it jeff", LocalDate.now(),
                                new ArrayList<Comment>()));
                break;
            }
        }
        System.out.println("Reassigning metal task");
        metalTask.setUserId(jeffID);

        System.out.println("Removing Impossible Burger Task");

        SystemFACADE.currentProject
                .removeTask(UUID.fromString("f0b62a92-6251-401a-84f6-52ac4894a3b2"));

        DataWriter.saveTasks();
        DataWriter.saveProjects();

        // Write JSON file
        try (FileWriter file = new FileWriter("output.txt")) {

            file.write("Results:\n" + projectList.ProjectBoard());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void run2() {
    // Scanner keyboard = new Scanner(System.in);
    // System.out.println("Would you like to view your projects?");
    // System.out.println("1. Yes 2. No");
    // int projectChoice = keyboard.nextInt();
    // keyboard.nextLine();

    // if (projectChoice == 1) {
    // // list projects
    // ProjectList projectList = ProjectList.getInstance();
    // ArrayList<Project> projects = projectList.getProjectList();

    // for (int i = 0; i < projects.size(); i++) {
    // Project project = projects.get(i);
    // System.out.println((i + 1) + " " + project.getName());
    // }

    // // add and/or remove projects
    // System.out.println("Would you like to 1. add or 2. remove");
    // int addRemove = keyboard.nextInt();
    // keyboard.nextLine();
    // if (addRemove == 1) {
    // // add project
    // System.out.println("Enter the name of the project you would like to add");
    // String addName = keyboard.nextLine();
    // projectList.addProject(addName);
    // } else if (addRemove == 2) {
    // // remove project
    // System.out.println("Enter the name of the project you would like to remove");
    // String removeName = keyboard.nextLine();
    // projectList.removeProject(removeName);
    // } else {
    // System.out.println("Please enter a valid choice");
    // }

    // System.out.println("Which project would you like to view?");
    // int projectView = keyboard.nextInt();
    // keyboard.nextLine();

    // if (projectView > 0 && projectView <= projects.size()) {
    // // user views selected project
    // SystemFACADE.currentProject = projects.get(projectView - 1);
    // System.out.println(SystemFACADE.currentProject.toString());

    // } else {
    // System.out.println("Please enter a valid choice");
    // }
    // } else if (projectChoice == 2) {
    // System.out.println("Goodbye");
    // } else {
    // System.out.println("Please enter a valid choice");
    // }
    // keyboard.close();
    // }

    public void scenario() {

    }
}