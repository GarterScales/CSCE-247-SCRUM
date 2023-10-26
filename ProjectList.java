import java.util.ArrayList;
import java.util.UUID;

public class ProjectList {
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

    public void ProjectBoard() {
        for(Project project : projectList) {
            project.toString();
        }
    }

    public ArrayList<Project> viewProjects() {
        return new ArrayList<Project>();
    }

    public void addProject(String name) {
        projectList.add(new Project(name));
    }

    public void removeProject(String name) {
        for(int i = 0; i < projectList.size(); i++) {
            if(projectList.get(i).getName().equals(name)) {
                projectList.remove(i);
            }
        }
    }

    public Project selectProject(String name) {
        for(Project project : projectList) {
            if(project.getName().equals(name)) {
                return project;
            }
        }

        return null;
    }
    
    public boolean checkIDAvailability(UUID id) {
        for (Project project : projectList) {
            if (id.equals(project.getId())) {
                return false;
            }
        }
        return true;
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