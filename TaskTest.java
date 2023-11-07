import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class TaskTest {

  @Test
  public void test() {
    ProjectList projectList = ProjectList.getInstance();
    projectList.addProject("testProject");
    DataWriter.saveProjects();

    ArrayList<Project> projects = projectList.getProjectList();
    Project testProject = projects.get(projects.size() - 1);
    String name = testProject.getName();

    assertEquals("testProject", name);
  }

}