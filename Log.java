import java.sql.Date;

public class Log {
    Date date;
    User user;
    LogEnum logEnum;
    String reason;

    public Log(Date date, User user, LogEnum logEnum, String reason) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
        this.reason = reason;
    }

    public Log(Date date, User user, LogEnum logEnum) {
        this.date = date;
        this.user = user;
        this.logEnum = logEnum;
    }

    public void changeLog(Date date, User user) {
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

    public void reverseLog(Date date, User user, String reason) {
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
}
