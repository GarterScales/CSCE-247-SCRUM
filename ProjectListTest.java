import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class ProjectListTest {

    @Test
    public void testAddProject() {
        ProjectList projectList = ProjectList.getInstance();
        projectList.addProject("testProject");
        DataWriter.saveProjects();

        DataLoader.getProjects();

        ArrayList<Project> projects = projectList.getProjectList();
        Project testProject = projects.get(projects.size() - 1);
        String name = testProject.getName();

        assertEquals("testProject", name);
    }

    @Test
    public void testRemoveProjectValid() {
        ProjectList projectList = ProjectList.getInstance();
        projectList.addProject("Air Computers");
        DataWriter.saveProjects();

        projectList.addProject("testProject");
        DataWriter.saveProjects();

        projectList.removeProject("testProject");
        DataWriter.saveProjects();

        DataLoader.getProjects();

        ArrayList<Project> projects = projectList.getProjectList();
        Project testProject = projects.get(projects.size() - 1);
        String name = testProject.getName();

        assertEquals("Air Computers", name);
    }

    @Test
    public void testRemoveProjectInvalid() {
        ProjectList projectList = ProjectList.getInstance();
        projectList.addProject("testProject");
        DataWriter.saveProjects();

        projectList.removeProject("none");
        DataWriter.saveProjects();

        DataLoader.getProjects();

        ArrayList<Project> projects = projectList.getProjectList();
        Project testProject = projects.get(projects.size() - 1);
        String name = testProject.getName();

        assertEquals("testProject", name);
    }

    @Test
    public void testSelectProjectValid() {
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjectList();

        UUID id = projects.get(0).getId();
        Project test = projectList.selectProject(id);

        assertEquals(projects.get(0), test);
    }

    @Test
    public void testSelectProjectInvalid() {
        ProjectList projectList = ProjectList.getInstance();

        UUID id = UUID.randomUUID();
        Project test = projectList.selectProject(id);

        assertEquals(null, test);
    }

    @Test
    public void testIdAvailabilityMatch() {
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjectList();

        UUID id = projects.get(0).getId();
        boolean test = projectList.checkIDAvailability(id);

        assertFalse(test);
    }

    @Test
    public void testIdAvailabilityNoMatch() {
        ProjectList projectList = ProjectList.getInstance();

        UUID id = UUID.randomUUID();
        boolean test = projectList.checkIDAvailability(id);

        assertTrue(test);
    }
}