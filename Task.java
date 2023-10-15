import java.util.ArrayList;

public abstract class Task {
    private String name;
    private String taskContent;
    private int priority;
    private String type;
    private LogHistory logHistory;
    private int hoursToComplete;
    private User user;
    private ArrayList<Comment> comments;
    public int pointValue;

    public Task() {
      comments = Database.getComments();
    }

    public void SetIntSprint(boolean inSprint) {
        
    }
}
