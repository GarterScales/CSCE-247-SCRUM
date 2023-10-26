import java.util.ArrayList;

public class ProjectList {
    private User user;
    public static ProjectList instance;
    private ArrayList<Project> projectList;

    private ProjectList() {
        projectList = DataLoader.getProjects();
    }

    public static ProjectList getInstance() {
        if (instance == null) {
            instance = new ProjectList();
        }
        return instance;
    }

    public void ProjectBoard(User user, ArrayList<Project> projects) {

    }

    public ArrayList<Project> viewProjects(User user) {
        return new ArrayList<Project>();
    }

    public void addProject(ArrayList<Project> projects, String projectName) {

    }

    public void removeProject(ArrayList<Project> projects, String projectName) {

    }

    public Project selectProject(ArrayList<Project> projects, String projectName) {
        Project temp = new Project("temp");
        return temp;
    }

    public void printProjects() {
        // for (Project project : projectList) {
        // System.out.println(project.toString());
        // }
        if (!projectList.isEmpty()) {
            for (Project project : projectList) {
                System.out.println(project.toString());
            }
        }

    }
}