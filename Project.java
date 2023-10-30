import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Project {
    private ArrayList<Comment> comments;
    private HashMap<UserRoleEnum, User> roleMap;
    private String projectName;
    private UUID id;
    private ArrayList<Task> taskList;

    public Project(String projectName) {
        setName(projectName);
        genUUID();
        comments = new ArrayList<Comment>();
        roleMap = new HashMap<UserRoleEnum, User>();
        roleMap.put(UserRoleEnum.MASTER, SystemFACADE.currentUser);
        taskList = new ArrayList<Task>();
    }

    public Project(UUID id, String projectName, ArrayList<Task> taskList, ArrayList<Comment> comments,
            HashMap<UserRoleEnum, User> roleMap) {
        setId(id);
        setName(projectName);
        setComments(comments);
        setRoleMap(roleMap);
        this.taskList = taskList;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    // we need to think about creating the log
    // fill this oout
    public void addTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            int pointValue, String type) {
        switch (type) {
            case "design":
                // need new overloaded constructor for all 4
                taskList.add(new DesignTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            case "documentation":
                taskList.add(new DocumentationTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            case "bug":
                taskList.add(new BugTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            case "new feature":
                taskList.add(new NewFeatureTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            default:
                break;
        }
    }

    public void removeTask(UUID taskID) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getID() == taskID) {
                taskList.remove(i);
            }
        }
    }

    public void addUser(UserRoleEnum role, User user) {
        roleMap.put(role, user);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void displayComments() {
        for (Comment comment : comments) {
            comment.toString();
        }
    }

    public void setName(String name) {
        this.projectName = name;
    }

    public String getName() {
        return this.projectName;
    }

    private void genUUID() {
        UUID tempID = UUID.randomUUID();
        boolean x = true;
        while (x) {
            if (ProjectList.getInstance().checkIDAvailability(tempID)) {
                this.id = tempID;
                x = false;
            } else {
                tempID = UUID.randomUUID();
            }
        }
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setRoleMap(HashMap<UserRoleEnum, User> roleMap) {
        this.roleMap = roleMap;
    }

    public HashMap<UserRoleEnum, User> getRoleMap() {
        return roleMap;
    }

    public String toString() {
        String returnString = "\n\nProject Name: " + this.projectName + "\nProject ID: " + this.id;
        if (taskList != null) {
            for (Task task : taskList) {
                returnString += task.toString();
            }
        }
        if (comments != null) {
            for (Comment comment : comments) {
                returnString += comment.toString();
            }
        }
        if (roleMap != null && !roleMap.isEmpty()) {
            for (HashMap.Entry<UserRoleEnum, User> entry : roleMap.entrySet()) {
                returnString += "\nRole: " + entry.getKey().toString() + "\nUser: " + entry.getValue().toString();
            }
        }

        return returnString;
    }
}
