import java.util.ArrayList;
import java.util.UUID;

public class BugTask extends Task {
    public BugTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        // TODO Auto-generated constructor stub
    }

    private ArrayList<String> reproductionSteps;
    private String bugEffect;
}
