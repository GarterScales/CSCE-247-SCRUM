import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class UserListTest {

    private UserList userList;

    @Test
    public void testAddUser() {
        UserList userList = UserList.getInstance();
        userList.addUser("testFirstName", "testLastName", "testEmail", "testUserName", "testPassword");
        DataWriter.saveUsers();

        ArrayList<User> users = userList.getUsers();
        User testUser = users.get(users.size() - 1);
        String firstName = testUser.getFirstName();
        String lastName = testUser.getLastName();
        String email = testUser.getEmail();
        String username = testUser.getUserName();
        String password = testUser.getPassword();

        assertEquals("testFirstName", firstName);
        assertEquals("testLastName", lastName);
        assertEquals("testEmail", email);
        assertEquals("testUserName", username);
        assertEquals("testPassword", password);
    }

    @Test
    public void testCheckPasswordRequirementsValidPassword() {
        UserList userList = UserList.getInstance();
        assertTrue(userList.checkPasswordRequirements("Password1"));
    }

    @Test
    public void testCheckPasswordRequirementsMissingNumber() {
        UserList userList = UserList.getInstance();
        assertFalse(userList.checkPasswordRequirements("NoNumber"));
    }

    @Test
    public void testCheckPasswordRequirementsMissingCapitalLetter() {
        UserList userList = UserList.getInstance();
        assertFalse(userList.checkPasswordRequirements("nocapital1"));
    }

    @Test
    public void testCheckPasswordRequirementsMissingLowerCaseLetter() {
        UserList userList = UserList.getInstance();
        assertFalse(userList.checkPasswordRequirements("NOLOWERCASE1"));
    }

    @Test
    public void testCheckPasswordRequirementsEmptyPassword() {
        UserList userList = UserList.getInstance();
        assertFalse(userList.checkPasswordRequirements(""));
    }

    @Test
    public void testCheckPasswordRequirementsNullPassword() {
        UserList userList = UserList.getInstance();
        assertFalse(userList.checkPasswordRequirements(null));
    }

    @Test
    public void testUsernameAvailabilityMatch() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();

        String username = users.get(0).getUserName();
        boolean test = userList.checkUsernameAvailability(username);

        assertFalse(test);
    }

    @Test
    public void testUsernameAvailabilityNoMatch() {
        UserList userList = UserList.getInstance();

        String username = "testusername";
        boolean test = userList.checkUsernameAvailability(username);

        assertTrue(test);
    }

    @Test
    public void testIdAvailabilityMatch() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();

        UUID id = users.get(0).getId();
        boolean test = userList.checkIDAvailability(id);

        assertFalse(test);
    }

    @Test
    public void testIdAvailabilityNoMatch() {
        UserList userList = UserList.getInstance();

        UUID id = UUID.randomUUID();
        boolean test = userList.checkIDAvailability(id);

        assertTrue(test);
    }

}
