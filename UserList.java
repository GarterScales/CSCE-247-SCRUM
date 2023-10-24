import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList instance;
    private ArrayList<User> userList;

    private UserList() {
        userList = DataLoader.getUsers();
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

    public UUID checkUsername(String username) {
        for (User user : userList) {
            if (username.equals(user.getUserName())) {
                return user.getId();
            }
        }
        return null;
    }

    public boolean checkUsernameAvailability(String username) {
        return true;
    }

    public UUID checkPassword(String password) {
        for (User user : userList) {
            if (password.equals(user.getPassword())) {
                return user.getId();
            }
        }
        return null;
    }

    public User checkUser(String username, String password) {
        for (User user : userList) {
            if (checkPassword(password) == checkUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }
}
