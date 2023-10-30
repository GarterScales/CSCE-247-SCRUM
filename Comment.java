import java.time.LocalDate;
import java.util.ArrayList;

public class Comment {
    private User commenter;
    private String content;
    private LocalDate date;
    private ArrayList<Comment> replies;

    public Comment(User commenter, String content, LocalDate date, ArrayList<Comment> replies) {
        this.commenter = commenter;
        this.content = content;
        this.date = date;
        this.replies = replies;
    }

    public void removeComment(Comment comment) {
        replies.remove(comment);
    }

    public User getCommenter() {
        return this.commenter;
    }

    public String getContent(String comment) {
        return this.content;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public ArrayList<Comment> getReplies(ArrayList<Comment> replies) {
        return this.replies;
    }

    public void addReply(Comment reply) {
        replies.add(reply);
    }

    public ArrayList<Comment> displayReplies() {
        return this.replies;
    }

    public String toString() {
        String returnString = "\nCommenter: " + this.commenter.toString() + "\nComment Content: " +
                this.content + "\nDate: " + this.date;

        if (!replies.isEmpty()) {
            for (Comment reply : replies) {
                returnString += reply.toString();
            }
        }

        return returnString;
    }
}
