import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

	public ArrayList<Project> getProjects() {
		return new ArrayList<Project>();
	}

	public ArrayList<User> getUsers() {
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