public class SystemFACADE
{
    private User user;
    private Project project;
    private Task task;
    
    public User login(String username, String password)
    {
        return new User();
    }
    public User logout(String username, String password)
    {
        return new User();
    }
    public User signUp(String firstName, String lastName, String email, String username, String password)
    {
        return new User();
    }
    public ProjectList getProjects(User user)
    {
        return new ProjectList();
    }
}