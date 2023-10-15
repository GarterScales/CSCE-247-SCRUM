public class SystemFACADE
{
    private User user;
    private Project project;
    private Task task;
    
    public User login(String username, String password)
    {
        User temp = new User("", "", "", "", "");
        return temp;
    }
    public User logout(String username, String password)
    {
        User temp = new User("", "", "", "", "");
        return temp;
    }
    public User signUp(String firstName, String lastName, String email, String username, String password)
    {
        User temp = new User("", "", "", "", "");
        return temp;
    }
    public ProjectList getProjects(User user)
    {
        //needs more thought
    }
}