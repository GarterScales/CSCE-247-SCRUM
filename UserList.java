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

    public int checkUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                return i;
            }
        }

        return -1;
    }

    public boolean checkUsernameAvailability(String username) {
        return true;
    }

    public int checkPassword(String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (password.equals(userList.get(i).getPassword())) {
                return i;
            }
        }

        return -1;
    }

    public boolean checkUser(User user) {
        if (checkUsername(user.getUserName()) == -1 || checkPassword(user.getPassword()) == -1) {
            return false;
        }

        if (checkUsername(user.getUserName()) == checkPassword(user.getPassword())) {
            return true;
        }

        return false;
    }

    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }
}
