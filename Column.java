import java.util.ArrayList;

public class Column {
    private ArrayList<Task> taskList;
    private LogEnum log;

    public Column(ArrayList<Task> tasks, LogEnum log) {
        this.taskList = tasks;
        this.log = log;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public String getName() {
        return this.log.name;
    }

    public LogEnum getLog() {
        return log;
    }

    public String toString() {
        String returnString = "\nColumn Name: " + this.log.name;
        for (Task task : taskList) {
            returnString += task.toString();
        }
        return returnString;
    }
}
