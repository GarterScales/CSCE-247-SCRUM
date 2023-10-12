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

    public Task addTask(Task task, String columnName) {
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

    public void addUser(UserRole role, String username) {
        
    }

    public void addComment(Comment comment) {

    }

    public ArrayList<Comment> displayComments() {
        return this.comments;
    }

    public void setName(String name) {
        this.projectName = name;
    }

    public String getName() {
        return this.projectName;
    }
}
