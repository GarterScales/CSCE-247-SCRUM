import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class CommentTest {
    @Test
    public void testAddCommentProject() {
        Project project = ProjectList.getInstance().getProjectList().get(0);
        User user = UserList.getInstance().getUsers().get(0);
        String content = "testCommentProject";
        LocalDate date = LocalDate.now();
        project.addComment(new Comment(user, content, date, new ArrayList<Comment>()));
        ArrayList<Comment> comments = project.getComments();

        String comment = comments.get(comments.size() - 1).getContent();

        assertEquals("testCommentProject", comment);
    }

    @Test
    public void testAddCommentTask() {
        Task task = ProjectList.getInstance().getProjectList().get(0).getTasks().get(0);
        User user = UserList.getInstance().getUsers().get(0);
        String content = "testCommentTask";
        LocalDate date = LocalDate.now();
        task.addComment(new Comment(user, content, date, new ArrayList<Comment>()));
        ArrayList<Comment> comments = task.getComments();

        String comment = comments.get(comments.size() - 1).getContent();

        assertEquals("testCommentTask", comment);
    }

    @Test
    public void testAddReply() {
        Comment comment = ProjectList.getInstance().getProjectList().get(0).getTasks().get(0).getComments().get(0);
        User user = UserList.getInstance().getUsers().get(0);
        String content = "testReply";
        LocalDate date = LocalDate.now();
        comment.addReply(new Comment(user, content, date, new ArrayList<Comment>()));
        ArrayList<Comment> replies = comment.getReplies();

        String reply = replies.get(replies.size() - 1).getContent();

        assertEquals("testReply", reply);
    }

    // @Test
    // public void testRemoveCommentProjectValid() {

    // }

    // @Test
    // public void testRemoveCommentProjectInvalid() {

    // }

    // @Test
    // public void testRemoveCommentTaskValid() {

    // }

    // @Test
    // public void testRemoveCommentTaskInvalid() {

    // }

    // @Test
    // public void testRemoveReplyValid() {

    // }

    // @Test
    // public void testRemoveReplyInvalid() {

    // }
}