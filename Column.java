import java.util.ArrayList;

public class Column {
    private ArrayList<Task> taskList;
    private String columnName;
    private LogEnum log;

    public Column(ArrayList<Task> tasks, LogEnum log) {
        this.taskList = tasks;
        this.log = log;
        setName();
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public void setName() {
        if (log.equals(LogEnum.BACKLOG)) {
            columnName = "Back Log";
        } else if (log.equals(LogEnum.TODO)) {
            columnName = "To Do";
        } else if (log.equals(LogEnum.INPROGRESS)) {
            columnName = "In Progress";
        } else if (log.equals(LogEnum.COMPLETE)) {
            columnName = "Complete";
        }
    }

    public String getName() {
        return columnName;
    }

    public LogEnum getLog() {
        return log;
    }

    public String toString() {
        String returnString = "\nColumn Name: " + this.columnName;
        for (Task task : taskList) {
            returnString += task.toString();
        }
        return returnString;
    }
}
