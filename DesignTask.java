import java.util.ArrayList;
import java.util.UUID;

public class DesignTask extends Task {
    private String toDesign;
    
    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String toDesign) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setToDesign(toDesign);
    }
    
    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
    }

    public DesignTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID, int pointValue) {
        super(name, content, priority, log, hoursToComplete, userID, pointValue);
    }

    public String getToDesign() {
        return toDesign;
    }

    public void setToDesign(String toDesign) {
        this.toDesign = toDesign;
    }
}
