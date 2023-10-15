import java.util.ArrayList;

public class ProjectList {
    private static ProjectList projectList;
    private User user;

    private ProjectList() {
        
    }

    public static ProjectList getInstance() {
        return new ProjectList();
    }

    public void ProjectBoard (User user, ArrayList<Project> projects) {
        
    }

    public ArrayList<Project> viewProjects(User user) {
        return new ArrayList<Project>();
    }

    public Project addProject(ArrayList<Project> projects, String projectName) {
        return new Project();
    }

    public Project removeProject(ArrayList<Project> projects, String projectName) {
        return new Project();
    }

    public Project selectProject(ArrayList<Project> projects, String projectName) {
        return new Project();
    }
}