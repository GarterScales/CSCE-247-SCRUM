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

    public boolean checkUsernameAvailability(String username) {
        return true;
    }

    public boolean checkIDAvailability(UUID id) {
        for (User user : userList) {
            if (id.equals(user.getId())) {
                return false;
            }
        }
        return true;
    }

    // handle all here
    public User checkUser(String username, String password) {
        for (User user : userList) {
            if (username.equals(user.getUserName())) {
                if (password.equals(user.getPassword())) {
                    return user;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public User getUserbyId(UUID id) {
        User user = null;

        return user;
    }

    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }
}
