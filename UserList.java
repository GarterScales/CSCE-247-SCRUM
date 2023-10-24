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

    public boolean checkPasswordRequirements(String password) {
        char ch;
        boolean hasNumber = false;
        boolean hasCapital = false;
        boolean hasLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
            if (hasNumber && hasCapital && hasLowerCase)
                return true;
        }
        return false;
    }

    public boolean checkUsernameAvailability(String username) {
        for (User user : userList) {
            if (username.equals(user.getUserName())) {
                return false;
            }
        }
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
        for (User user : userList) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }
}
