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
      
    }

    public void SetIntSprint(boolean inSprint) {

    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getTaskContent() {
      return taskContent;
    }

    public void setTaskContent(String taskContent) {
      this.taskContent = taskContent;
    }

    public int getPriority() {
      return priority;
    }

    public void setPriority(int priority) {
      this.priority = priority;
    }

    public int getPointValue() {
      return pointValue;
    }

    public void setPointValue(int pointValue) {
      this.pointValue = pointValue;
    }

}
