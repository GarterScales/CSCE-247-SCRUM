import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> userList;

    private UserList() {
        userList = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean checkUsername(String username) {
        return true;
    }

    public boolean checkUsernameAvailability(String username) {
        return true;
    }

    public boolean checkPassword(String password) {
        return true;
    }

    public boolean checkUser(User user) {
        return true;
    }

    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }
}
