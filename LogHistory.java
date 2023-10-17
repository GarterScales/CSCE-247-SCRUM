import java.sql.Date;

public class LogHistory {
    Date date;
    User user;
    Log log;
    String reason;

    public void changeLog(Date date, User user) {
        switch (this.log) {
            case BACKLOG:
                this.log = Log.TODO;
                break;
            case COMPLETE:
                break;
            case INPROGRESS:
                this.log = Log.COMPLETE;
                break;
            case TODO:
                this.log = Log.INPROGRESS;
                break;
            default:
                this.log = Log.BACKLOG;
                break;

        }
        this.date = date;
        this.user = user;
    }

    public void reverseLog(Date date, User user, String reason) {
        switch (this.log) {
            case BACKLOG:
                break;
            case COMPLETE:
                this.log = Log.INPROGRESS;
                break;
            case INPROGRESS:
                this.log = Log.TODO;
                break;
            case TODO:
                this.log = Log.BACKLOG;
                break;
            default:
                this.log = Log.BACKLOG;
                break;

        }
        this.date = date;
        this.user = user;
        this.reason = reason;
    }
}
