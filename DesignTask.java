import java.util.ArrayList;
import java.util.UUID;

public class DesignTask extends Task {
    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        // TODO Auto-generated constructor stub
    }

    private String toDesign;
}
