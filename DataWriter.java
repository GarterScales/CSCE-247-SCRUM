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

    // NONFUNCTIONAL
    public static void saveTasks() {
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

        ArrayList<Task> tasks = project.getTasks();
        JSONArray tasksJSON = new JSONArray();

        for (Task task : tasks) {
            tasksJSON.add(getTaskIDObject(task));
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

    public static JSONObject getTaskIDObject(Task task) {
        JSONObject taskIDObject = new JSONObject();
        taskIDObject.put(TASK_ID, task.getID().toString());
        return taskIDObject;
    }

    public static JSONObject getTaskObject(Task task) {
        JSONObject taskObject = new JSONObject();
        taskObject.put(TASK_ID, task.getID().toString());
        taskObject.put(TASK_NAME, task.getName());
        taskObject.put(TASK_CONTENT, task.getTaskContent());
        taskObject.put(PRIORITY, task.getPriority());
        taskObject.put(TASK_TYPE, task.getTaskType());
        taskObject.put(LOG, getLogObject(task.getLog()));
        taskObject.put(HOURS, task.getHoursToComplete());
        taskObject.put(USER_ID, task.getUserId().toString());

        ArrayList<Comment> comments = task.getComments();
        JSONArray commentsJSON = new JSONArray();

        for (Comment comment : comments) {
            commentsJSON.add(getCommentJSON(comment));
        }
        taskObject.put(COMMENTS, commentsJSON);
        taskObject.put(POINT_VALUE, task.getPointValue());

        return taskObject;
    }

    public static JSONObject getLogObject(Log log) {
        JSONObject logObject = new JSONObject();
        logObject.put(LOG_DATE, log.getDate().toString());
        logObject.put(LOG_USER_ID, log.getUser().getId().toString());
        logObject.put(LOG_ENUM, log.getType());
        logObject.put(LOG_REASON, log.getReason());
        return logObject;
    }
}
