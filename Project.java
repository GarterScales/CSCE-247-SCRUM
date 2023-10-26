import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Project {
    private ArrayList<Column> columnList;
    private ArrayList<Comment> comments;
    private HashMap<UserRoleEnum, User> roleMap;
    private String projectName;
    private UUID id;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(UUID id, String projectName, ArrayList<Column> columnList, ArrayList<Comment> comments,
            HashMap<UserRoleEnum, User> roleMap) {
        this.id = id;
        this.projectName = projectName;
        this.columnList = columnList;
        this.comments = comments;
        this.roleMap = roleMap;
    }

    public void addTask(Task task, String columnName) {

    }

    public void removeTask(Task task) {

    }

    public void editTask(Task task) {

    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<Task>();
    }

    public ArrayList<Task> displayTasks() {
        return new ArrayList<Task>();
    }

    public void addUser(UserRoleEnum role, String username) {

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

    public String toString() {
        String returnString = "Project Name: " + this.projectName + "\nProject ID: " + this.id + "\nColumn List: ";
        if (columnList != null) {
            for (Column column : columnList) {
                returnString += column.toString();
            }
        }
        if (comments != null) {
            for (Comment comment : comments) {
                returnString += comment.toString();
            }
        }
        if (roleMap != null) {
            for (HashMap.Entry<UserRoleEnum, User> entry : roleMap.entrySet()) {
                returnString += "\nRole: " + entry.getKey() + "\nUser: " + entry.getValue().toString();
            }
        }

        return returnString;
    }
}
