public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public User(String firstName, String lastName, String email, String username, String password) {

    }

    public User(String username, String password) {

    }

    public boolean checkPasswordRequirements(String password) {
        return true;
    }
}
