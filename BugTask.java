import java.util.ArrayList;
import java.util.UUID;

public class BugTask extends Task {
    private String reproductionSteps;
    private String bugEffect;

    public BugTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String reproductionSteps, String bugEffect) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setReproductionSteps(reproductionSteps);
        setBugEffect(bugEffect);
    }

    public BugTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
    }

    public BugTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID, int pointValue) {
        super(name, content, priority, log, hoursToComplete, userID, pointValue);
       
    }

    public String getReproductionSteps() {
        return reproductionSteps;
    }

    public void setReproductionSteps(String reproductionSteps) {
        this.reproductionSteps = reproductionSteps;
    }

    public String getBugEffect() {
        return bugEffect;
    }

    public void setBugEffect(String bugEffect) {
        this.bugEffect = bugEffect;
    }
}