import java.sql.Date;
import java.util.ArrayList;

public class Sprint {
    private ArrayList<Task> associatedTasks;
    private int sprintID;
    private Date startDate;
    private Date endDate;

    // CONVERT THIS TASK TO BOOLEAN IN TASK AND HAVE INDICATION OF BOOLEAN IN
    // TOSTRING/HIGHLIGHT

    public Sprint(int sprintID) {
        this.sprintID = sprintID;
    }

    public void addTask(Task task) {

    }

    public void removeTask(Task task) {

    }

    public void setDate(int day, int month, int year, boolean isStart) {

    }
}
