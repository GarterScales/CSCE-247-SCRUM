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

    public Task removeTask(Task task) {
        return null;
    }

    public Task editTask(Task task) {
        return new Task();
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<Task>();
    }

    public void displayTasks() {

    }

    public User addUser(UserRole role, String username) {
        return new User();
    }
}
