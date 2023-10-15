import java.sql.Date;
import java.util.ArrayList;

public class Comment {
    private User commenter;
    private String commentContent;
    private Date date;
    private ArrayList<Comment> replies;

    public Comment(User commenter, String content, Date date) {
        this.commenter = commenter;
        this.commentContent = content;
        this.date = date;
    }

    public void removeComment(Comment comment) {

    }

    public User getCommenter() {
        return this.commenter;
    }

    public Date getDate() {
        return this.date;
    }

    public void addReply(Comment reply) {
        
    }

    public ArrayList<Comment> displayReplies() {
        return this.replies;
    }
}
