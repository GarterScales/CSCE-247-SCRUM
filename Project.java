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
            int pointValue, String type) {
        switch (type) {
            case "design":
                getColumnType(log).add(new DesignTask(name, content, priority, log, hoursToComplete, userID, pointValue)); //need new overloaded constructor for all 4
                break;

            case "documentation":
            getColumnType(log).add(new DocumentationTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            case "bug":
            getColumnType(log).add(new BugTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            case "new feature":
            getColumnType(log).add(new NewFeatureTask(name, content, priority, log, hoursToComplete, userID, pointValue));
                break;

            default:
                break;
        }
    }

    public ArrayList<Task> getColumnType(Log log) {
        int columnNum = 0;
        
        switch (log.logEnum) {
            case BACKLOG:
                columnNum = 0;
                break;

            case TODO:
                columnNum = 1;
                break;

            case INPROGRESS:
            columnNum = 2;
                break;

            case COMPLETE:
            columnNum = 3;
                break;

            default:
                break;
        }

        return columnList.get(columnNum).getTasks();
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
