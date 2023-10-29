import java.util.ArrayList;
import java.util.UUID;

public class DocumentationTask extends Task {
    private String toDocument;
    
    public DocumentationTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete,
            UUID userID, ArrayList<Comment> comments, int pointValue, String toDocument) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setToDocument(toDocument);
    }

    public DocumentationTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete,
            UUID userID, ArrayList<Comment> comments, int pointValue) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
    }

    public DocumentationTask(String name, String content, int priority, Log log, int hoursToComplete, UUID userID, int pointValue) {
        super(name, content, priority, log, hoursToComplete, userID, pointValue);
    }

    public String getToDocument() {
        return toDocument;
    }

    public void setToDocument(String toDocument) {
        this.toDocument = toDocument;
    }
}
