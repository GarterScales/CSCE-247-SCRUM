import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

	public static void main(String[] args) {
		UI ui = new UI();
		ui.run();
	}

	public static ArrayList<Task> getTasks() {
		UserList userList = UserList.getInstance();
		ArrayList<Task> tasks = new ArrayList<Task>();

		try {
			FileReader reader = new FileReader(TASK_FILE_NAME);
			JSONArray tasksJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < tasksJSON.size(); i++) {
				JSONObject taskJSON = (JSONObject) tasksJSON.get(i);
				UUID id = UUID.fromString((String) taskJSON.get(TASK_ID));

				String taskName = (String) taskJSON.get(TASK_NAME);
				String content = (String) taskJSON.get(TASK_CONTENT);
				int priority = (int) taskJSON.get(PRIORITY);
				int hoursToComplete = (int) taskJSON.get(HOURS);
				UUID userID = (UUID) taskJSON.get(TASK_USER_ID);
				int pointValue = (int) taskJSON.get(POINT_VALUE);

				JSONObject logObject = (JSONObject) taskJSON.get(LOG);
				UUID logUserUUID = (UUID) logObject.get(LOG_USER_ID);
				LogEnum logEnum = (LogEnum) logObject.get(LOG_ENUM);
				Date logDate = (Date) logObject.get(LOG_DATE);
				String logReason = (String) logObject.get(LOG_REASON);

				Log log = new Log(logDate, userList.getUserbyId(logUserUUID), logEnum, logReason);

				JSONArray commentsJSON = (JSONArray) taskJSON.get(COMMENTS);
				ArrayList<Comment> comments = new ArrayList<>();

				for (Object c : commentsJSON) {
					JSONObject toPass = (JSONObject) c;
					comments.add(parseComment(toPass, userList));
				}

				switch ((String) taskJSON.get(TASK_TYPE)) {
					// will need to add custom elements of these classes to the JSON and load them
					// here
					case "BugTask":
						tasks.add((Task) (new BugTask(id, taskName, content, priority, log, hoursToComplete, userID, comments,
								pointValue)));
						break;
					case "DesignTask":
						tasks.add((Task) (new DesignTask(id, taskName, content, priority, log, hoursToComplete, userID, comments,
								pointValue)));
						break;
					case "NewFeatureTask":
						tasks.add((Task) (new NewFeatureTask(id, taskName, content, priority, log, hoursToComplete, userID,
								comments, pointValue)));
						break;
					case "DocumentationTask":
						tasks.add((Task) (new NewFeatureTask(id, taskName, content, priority, log, hoursToComplete, userID,
								comments, pointValue)));
						break;
				}
			}

			return tasks;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Comment parseComment(JSONObject commentJSON, UserList userList) {

		UUID commenterID = (UUID) commentJSON.get(COMMENTER_ID);
		String content = (String) commentJSON.get(CONTENT);
		Date date = (Date) commentJSON.get(DATE);
		ArrayList<Comment> replies = new ArrayList<Comment>();
		JSONArray repliesJSON = (JSONArray) commentJSON.get(REPLIES);

		if (!repliesJSON.isEmpty()) {
			for (int i = 0; i < repliesJSON.size(); i++) {
				JSONObject subcommentJson = (JSONObject) repliesJSON.get(i);
				Comment subcomment = parseComment(subcommentJson, userList);
				replies.add(subcomment);
			}
		}

		return new Comment(userList.getUserbyId(commenterID), content, date, replies);
	}

	public ArrayList<Project> getProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();

		try {
			FileReader reader = new FileReader(PROJECT_FILE_NAME);
			JSONArray projectJSON = (JSONArray) new JSONParser().parse(reader);


		}

		return null;
	}

	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject) peopleJSON.get(i);
				UUID id = UUID.fromString((String) personJSON.get(USER_ID));
				String firstName = (String) personJSON.get(USER_FIRST_NAME);
				String lastName = (String) personJSON.get(USER_LAST_NAME);
				String email = (String) personJSON.get(USER_EMAIL);
				String userName = (String) personJSON.get(USER_USER_NAME);
				String password = ((String) personJSON.get(USER_PASSWORD));

				users.add(new User(id, firstName, lastName, email, userName, password));
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}