import java.util.ArrayList;

public class SystemFACADE {
    public User currentUser;
    private User user;
    private Project project;
    private Task task;

    public User login(String username, String password) {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        if (userList.checkUsername(username)) {
            for (User user : users) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User logout(String username, String password) {
        User temp = new User("", "", "", "", "");
        return temp;
    }

    public User signUp(String firstName, String lastName, String email, String username, String password) {
        UserList userList = UserList.getInstance();

        // check if username is available
        if (!userList.checkUsernameAvailability(username)) {
            return null;
        }

        // add user to user list
        userList.addUser(firstName, lastName, email, username, password);

        // save updated user list to data writer
        DataWriter.saveUsers();

        // return newly created user
        User newUser = new User(firstName, lastName, email, username, password);
        return newUser;
    }

    public ProjectList getProjects(User user) {
        return ProjectList.getInstance();
    }
}