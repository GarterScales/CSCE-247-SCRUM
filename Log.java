import java.time.LocalDate;

public class Log {
    LocalDate date;
    User user;
    LogEnum logEnum;
    String reason;

    /**
     * A method that creates a log object
     * 
     * @param date
     * @param user
     * @param logEnum
     * @param reason
     */
    public Log(LocalDate date, User user, LogEnum logEnum, String reason) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
        this.reason = reason;
    }

    /**
     * A method that creates a log object without the reason string
     * 
     * @param date
     * @param user
     * @param logEnum
     */
    public Log(LocalDate date, User user, LogEnum logEnum) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
    }

    /**
     * Getter for date
     * 
     * @return a date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Getter for user
     * 
     * @return
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Getter for type
     * 
     * @return
     */
    public LogEnum getType() {
        return this.logEnum;
    }

    /**
     * Getter for reason
     * 
     * @return
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * A method that changes the type of log
     * 
     * @param date
     * @param user
     */
    public void changeLog(LocalDate date, User user) {
        switch (this.logEnum) {
            case BACKLOG:
                this.logEnum = LogEnum.TODO;
                break;
            case COMPLETE:
                break;
            case INPROGRESS:
                this.logEnum = LogEnum.COMPLETE;
                break;
            case TODO:
                this.logEnum = LogEnum.INPROGRESS;
                break;
            default:
                this.logEnum = LogEnum.BACKLOG;
                break;

        }
        this.date = date;
        this.user = user;
    }

    /**
     * A method that changes the type of log but in the opposite direction
     * 
     * @param date
     * @param user
     * @param reason
     */
    public void reverseLog(LocalDate date, User user, String reason) {
        switch (this.logEnum) {
            case BACKLOG:
                break;
            case COMPLETE:
                this.logEnum = LogEnum.INPROGRESS;
                break;
            case INPROGRESS:
                this.logEnum = LogEnum.TODO;
                break;
            case TODO:
                this.logEnum = LogEnum.BACKLOG;
                break;
            default:
                this.logEnum = LogEnum.BACKLOG;
                break;

        }
        this.date = date;
        this.user = user;
        this.reason = reason;
    }

    /**
     * A tostring method for log
     */
    public String toString() {
        return "\nDate: " + this.date + "\nUser: " + this.user.toString() + "\nLog Type: " + this.logEnum
                + (this.reason != null ? "" : "\nReason" + this.reason);
    }
}
