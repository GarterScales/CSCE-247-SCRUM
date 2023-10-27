import java.time.LocalDate;

public class Log {
    LocalDate date;
    User user;
    LogEnum logEnum;
    String reason;

    public Log(LocalDate date, User user, LogEnum logEnum, String reason) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
        this.reason = reason;
    }

    public Log(LocalDate date, User user, LogEnum logEnum) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
    }

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

    public String toString() {
        return "\nDate: " + this.date + "\nUser: " + this.user.toString() + "\nLog Type: " + this.logEnum
                + (this.reason != null ? "" : "\nReason" + this.reason);
    }
}
