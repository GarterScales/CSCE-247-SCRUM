import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Project {
    private ArrayList<Column> columnList;
    private ArrayList<Comment> comments;
    private HashMap<UserRoleEnum, User> roleMap;
    private String projectName;
    private UUID id;

    public Project(String projectName) {
        setName(projectName);
        genUUID();
        columnList = createColumnList();
        comments = new ArrayList<Comment>();
        roleMap = new HashMap<UserRoleEnum, User>();
        roleMap.put(UserRoleEnum.MASTER, SystemFACADE.currentUser);
    }

    public Project(UUID id, String projectName, ArrayList<Column> columnList, ArrayList<Comment> comments,
            HashMap<UserRoleEnum, User> roleMap) {
        setId(id);
        setName(projectName);
        this.columnList = columnList;
        setComments(comments);
        setRoleMap(roleMap);
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<Task>();
    }

    // we need to think about creating the log
    // fill this oout
    public void addTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            int pointValue) {
        switch (log.logEnum) {
            case BACKLOG:

                break;

            default:
                break;
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

    public ArrayList<Column> createColumnList() {
        columnList = new ArrayList<Column>();

        columnList.add(new Column(new ArrayList<Task>(), LogEnum.BACKLOG));
        columnList.add(new Column(new ArrayList<Task>(), LogEnum.TODO));
        columnList.add(new Column(new ArrayList<Task>(), LogEnum.INPROGRESS));
        columnList.add(new Column(new ArrayList<Task>(), LogEnum.COMPLETE));

        return columnList;
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
