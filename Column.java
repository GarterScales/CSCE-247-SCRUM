import java.util.ArrayList;

public class Column {
    private ArrayList<Task> taskList;
    private String columnName;

    public Column(ArrayList<Task> tasks, String name) {
        this.taskList = tasks;
        this.columnName = name;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public void setName(String name) {
        this.columnName = name;
    }

    public String getName() {
        return columnName;
    }
}
