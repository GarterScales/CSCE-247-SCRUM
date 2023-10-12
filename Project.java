import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private ArrayList<Column> columnList;
    private ArrayList<Comment> comments;
    private HashMap<UserRole, User> roleMap;
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Task addTask(Task task) {
        return new Task();
    }

    public void removeTask(Task task) {
        
    }

    public Task editTask(Task task) {
        return new Task();
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<Task>();
    }

    public ArrayList<Task> displayTasks() {
        return new ArrayList<Task>();
    }

    public User addUser(UserRole role, String username) {
        return new User();
    }
}
