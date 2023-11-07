import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class ProjectTest {
    @Test
    public void testGetTaskByIdValid() {
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjectList();
        Project project = projects.get(0);
        ArrayList<Task> tasks = project.getTasks();
        UUID id = tasks.get(0).getID();

        String name = project.getTaskbyId(id).getName();

        assertEquals("Curve the metal to make a cylindrical shape", name);
    }

    @Test
    public void testGetTaskByIdInvalid() {
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjectList();
        Project project = projects.get(0);
        UUID id = UUID.randomUUID();

        String name = null;

        if(project.getTaskbyId(id) == null) {
            name = "nothing";
        }

        assertEquals("nothing", name);
    }


}
