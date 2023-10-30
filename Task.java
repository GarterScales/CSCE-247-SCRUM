import java.util.ArrayList;
import java.util.UUID;

public abstract class Task {
  private String name;
  private String taskContent;
  private int priority;
  private Log log;
  private int hoursToComplete;
  private User user;
  private ArrayList<Comment> comments;
  private UUID id;
  private UUID userId;
  private int pointValue;
  private boolean inSprint = false;
  private String toDesign;
  private String toDocument;
  private String reproductionSteps;
  private String bugEffect;
  private String justification;
  private String intention;

  public Task(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
      ArrayList<Comment> comments, int pointValue) {
    setId(userID);
    setName(name);
    setTaskContent(content);
    setPriority(priority);
    setLog(log);
    setHoursToComplete(hoursToComplete);
    setUserId(userID);
    ;
    setComments(comments);
    setPointValue(pointValue);
  }

  public Task(String name, String content, int priority, Log log, int hoursToComplete, UUID userID, int pointValue) {
    genUUID();
    setName(name);
    setTaskContent(content);
    setHoursToComplete(hoursToComplete);
    setLog(log);
    setUserId(userID);
    setPriority(priority);
    setPointValue(pointValue);
  }

  public abstract String getTaskType();

  public void toggleSprint() {
    this.inSprint = !this.inSprint;
  }

  public boolean getInSprint() {
    return inSprint;
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

  public int getHoursToComplete() {
    return hoursToComplete;
  }

  public void setHoursToComplete(int hoursToComplete) {
    this.hoursToComplete = hoursToComplete;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Log getLog() {
    return log;
  }

  public void setLog(Log log) {
    this.log = log;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public void setComments(ArrayList<Comment> comments) {
    this.comments = comments;
  }

  public int getPointValue() {
    return pointValue;
  }

  public void setPointValue(int pointValue) {
    this.pointValue = pointValue;
  }

  private void genUUID() {
    UUID tempID = UUID.randomUUID();
    boolean x = true;
    while (x) {
      if (ProjectList.getInstance().checkIDAvailability(tempID)) {
        this.id = tempID;
        x = false;
      } else {
        tempID = UUID.randomUUID();
      }
    }
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getID() {
    return id;
  }

  public String getToDesign() {
    return this.toDesign;
  }

  public String getToDocument() {
    return this.toDocument;
  }

  public String getReproductionSteps() {
    return this.reproductionSteps;
  }

  public String getBugEffect() {
    return this.bugEffect;
  }

  public String getJustification() {
    return this.justification;
  }

  public String getIntention() {
    return this.intention;
  }

  public String toString() {
    String returnString = "\nTask Name: " + this.name + "\nIn Sprint?: " + this.inSprint + "\nTask ID: " + this.id
        + "\nTask Content: " +
        this.taskContent + "\nPriority: " + this.priority + "\nLog: " + this.log.toString()
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
