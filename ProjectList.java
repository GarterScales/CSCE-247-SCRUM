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

    public ArrayList<Project> getProjectList() {
        return this.projectList;
    }

    public String ProjectBoard() {
        String returnString = "";
        if (!projectList.isEmpty()) {
            for (Project project : projectList) {
                returnString += project.toString();
            }
        }
        return returnString;
    }

    public void addProject(String name) {
        projectList.add(new Project(name));
        DataWriter.saveProjects();
    }

    public void removeProject(String name) {
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getName().equals(name)) {
                projectList.remove(i);
                DataWriter.saveProjects();
            }
        }
    }

    public Project selectProject(UUID id) {
        for (Project project : projectList) {
            if (project.getId().equals(id)) {
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
}