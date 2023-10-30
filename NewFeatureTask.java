import java.util.ArrayList;
import java.util.UUID;

public class NewFeatureTask extends Task {
    private String justification;
    private String intention;

    public NewFeatureTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String justification, String intention) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setJustification(justification);
        setIntention(intention);
    }

    public NewFeatureTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
    }

    public NewFeatureTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, log, hoursToComplete, userID, pointValue);
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getTaskType() {
        return "NewFeatureTask";
    }
}
