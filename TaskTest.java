import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class TaskTest {

  @Test
  public void testAddTask() {

    Project project = ProjectList.getInstance().getProjectList().get(0);
    project.addTask("TestTask", "", 0, 0, UUID.randomUUID(), 0, "new feature");

    DataWriter.saveProjects();

    DataLoader.getProjects();

    project = ProjectList.getInstance().getProjectList().get(0);
    String name = project.getTasks().get(project.getTasks().size() - 1).getName();

    assertEquals("TestTask", name);
  }

  @Test
  public void testRemoveTask() {

    Project project = ProjectList.getInstance().getProjectList().get(0);
    project.addTask("SuccessTask", "", 0, 0,
        UUID.randomUUID(), 0, "new feature");

    UUID testID = project.addTask("TestTask", "", 0, 0,
        UUID.randomUUID(), 0, "new feature");

    DataWriter.saveProjects();

    DataLoader.getProjects();

    project = ProjectList.getInstance().selectProject(testID);
    String name = project.getTasks().get(project.getTasks().size() - 1).getName();

    assertEquals("SuccessTask", name);
  }

}