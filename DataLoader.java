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
		return new ArrayList<User>();
	}
}