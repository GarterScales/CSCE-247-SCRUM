import java.util.ArrayList;
import java.util.UUID;

public abstract class Task {
  private String name;
  private String taskContent;
  private int priority;
  private Log logHistory;
  private int hoursToComplete;
  private User user;
  private ArrayList<Comment> comments;
  private UUID id;
  private int pointValue;
  private boolean inSprint = false;

  public Task(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
      ArrayList<Comment> comments, int pointValue) {

  }

  public Task(String name, String content, int priority, Log log, int hoursToComplete, UUID userID, int pointValue) {

  }

  public void toggleSprint() {
    this.inSprint = !this.inSprint;
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

  public UUID getID() {
    return id;
  }

  public String toString() {
    String returnString = "\nTask Name: " + this.name + "\nIn Sprint?: " + this.inSprint + "\nTask ID: " + this.id
        + "\nTask Content: " +
        this.taskContent + "\nPriority: " + this.priority + "\nLog: " + this.logHistory.toString()
        + "\nHours to Complete: " + this.hoursToComplete +
        "\nAssigned User: " + this.user.toString() + "\nPoint Value: " + this.pointValue;

    if (comments != null) {
      for (Comment comment : comments) {
        returnString += comment.toString();
      }
    }

    return returnString;
  }

}
