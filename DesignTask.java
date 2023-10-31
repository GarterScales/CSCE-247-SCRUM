import java.util.ArrayList;
import java.util.UUID;

/**
 * A Design Task which is a subtype of Task
 */
public class DesignTask extends Task {
    private String toDesign;

    /**
     * Constructor for creating a Design Task with attributes
     * 
     * @param id              Identifier for the task
     * @param name            Name of the task
     * @param content         Content of the task
     * @param priority        Priority level of the task
     * @param log             Task's log
     * @param hoursToComplete Hours required to complete the task
     * @param userID          Identifier of the user assigned to the task
     * @param comments        List of comments associated with the task
     * @param pointValue
     * @param toDesign
     */
    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String toDesign) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setToDesign(toDesign);
    }

    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
    }

    public DesignTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, log, hoursToComplete, userID, pointValue);
    }

    public String getToDesign() {
        return toDesign;
    }

    public void setToDesign(String toDesign) {
        this.toDesign = toDesign;
    }

    public String getTaskType() {
        return "DesignTask";
    }
}
