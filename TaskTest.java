import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
  @Test
  public void taskId() {
      Task task = new Task("01234567890", "nameHere", "Description here");
      task.setId("00001");
      Assertions.assertEquals("00001", task.getId());
   }
  @Test
  public void taskName() {
      Task task = new Task("0000000001", "nameHere", "Description here");
      task.setName("Bill");
      Assertions.assertEquals("Bill", task.getName());
  }
  @Test
  public void taskDescription() {
      Task task = new Task("0000000001", "nameHere", "Description here");
      task.setDescription("Bill");
      Assertions.assertEquals("Bill", task.getDescription());
  }
}