public class LogHistory {
    Date date;
    User user;
    Log log;

    Log changLog (Date date, User user) {
        Log newLog = new Log();
        this.date = date;
        this.user = user;
        this.log = newLog;

        return newLog;
    }

    Log reverseLog(Date date, User user, String reason) {
        Log reversedLog = new Log();
        this.date = date;
        this.user = user;
        reversedLog.setReasonForReversal(reason);

        return reversedLog;
    }
}
