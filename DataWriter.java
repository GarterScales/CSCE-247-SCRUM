import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProjects() {
        ProjectList projects = ProjectList.getInstance();
        ArrayList<Project> projectList = projects.getProjectList();
        JSONArray jsonProjects = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < projectList.size(); i++) {
            jsonProjects.add(getProjectJSON(projectList.get(i)));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {

            file.write(jsonProjects.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL, user.getEmail());

        return userDetails;
    }

    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectDetails = new JSONObject();
        projectDetails.put(PROJECT_ID, project.getId().toString());
        projectDetails.put(PROJECT_NAME, project.getName());

        ArrayList<Column> columns = project.getColumns();
        JSONArray columnsJSON = new JSONArray();

        for (Column column : columns) {
            columnsJSON.add(getColumnObject(column));
        }

        ArrayList<Comment> comments = project.getComments();
        JSONArray commentsJSON = new JSONArray();

        for (Comment comment : comments) {
            commentsJSON.add(getCommentJSON(comment));
        }
        projectDetails.put(COMMENTS, commentsJSON);

        JSONArray rolesJSON = new JSONArray();
        HashMap<UserRoleEnum, User> roleMap = project.getRoleMap();
        for (Map.Entry<UserRoleEnum, User> entry : roleMap.entrySet()) {
            rolesJSON.add(getRoleObject(entry));

        }
        projectDetails.put(ROLE_MAP, rolesJSON);

        return projectDetails;
    }

    public static JSONObject getCommentJSON(Comment comment) {
        JSONObject commentDetails = new JSONObject();
        commentDetails.put(COMMENTER_ID, comment.getCommenter().getId().toString());
        commentDetails.put(CONTENT, comment.getContent());
        commentDetails.put(DATE, comment.getDate().toString());
        for (Comment reply : comment.getReplies()) {
            commentDetails.put(REPLIES, getCommentJSON(reply));
        }

        return commentDetails;
    }

    public static JSONObject getRoleObject(Map.Entry<UserRoleEnum, User> entry) {
        JSONObject roleObject = new JSONObject();
        roleObject.put(ROLE, entry.getKey());
        roleObject.put(USER_ID, entry.getValue());
        return roleObject;
    }

    public static JSONObject getColumnObject(Column column) {
        JSONObject columnObject = new JSONObject();
        columnObject.put(COLUMN_NAME, column.getName());
        JSONArray tasksJSON = new JSONArray();
        ArrayList<Task> tasks = column.getTasks();
        for (Task task : tasks) {
            tasksJSON.add(getTaskObject(task));
        }
        columnObject.put(TASK_IDS, tasksJSON);
        return columnObject;
    }

    public static JSONObject getTaskObject(Task task) {
        JSONObject taskObject = new JSONObject();
        taskObject.put(TASK_ID, task.getID());
        return taskObject;
    }
}
