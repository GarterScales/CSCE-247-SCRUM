import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public User(UUID id, String firstName, String lastName, String email, String username, String password) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserName(username);
        setPassword(password);
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserName(username);
        setPassword(password);
        genUUID();
    }

    public User(String username, String password) {
        setUserName(username);
        setPassword(password);
    }

    private void genUUID() {
        UUID tempID = UUID.randomUUID();
        boolean x = true;
        while (x) {
            if (UserList.getInstance().checkIDAvailability(tempID)) {
                this.id = tempID;
                x = false;
            } else {
                tempID = UUID.randomUUID();
            }
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPasswordRequirements(String password) {
        return true;
    }
}
