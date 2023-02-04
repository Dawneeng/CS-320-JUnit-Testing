# CS-320-JUnit-Testing
task.java

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
}import org.junit.jupiter.api.Assertions;
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
------------------------------------------------------------------------------
taskService.java
import java.util.HashMap;

public class TaskService {
	private HashMap<String, Task> idToTask;
	public TaskService() {
		idToTask = new HashMap<String, Task>();
	}

public void addTask (String taskId, String name, String description) {
	if(taskId == null 
			|| taskId.length() > 10 
			|| name == null 
			|| name.length() > 20 
			|| description == null
			|| description.length() > 50) {
		throw new IllegalArgumentException();
	}
	if(idToTask.containsKey(taskId)){
		throw new IllegalArgumentException ("Duplicate ID");
	}
	Task newTask = new Task(taskId, name, description);
	idToTask.put(taskId, newTask);
}

public void deleteTask(String taskId){
	if (!idToTask.containsKey(taskId)) {
		throw new IllegalArgumentException("ID Does not exist");
	}
	idToTask.remove(taskId);
}

public Task getTask(String taskId) {
	if (!idToTask.containsKey(taskId)) {
		throw new IllegalArgumentException("ID Does not exist");
	}
	return idToTask.get(taskId);
}

public void updateName(String taskId,String name){
	if (!idToTask.containsKey(taskId)) {
		throw new IllegalArgumentException("ID Does not exist");
	}
	Task taskToUpdate = idToTask.get(taskId);
	taskToUpdate.setName(name);

}
public void updateDescription (String taskId, String description) {
	if (!idToTask.containsKey(taskId)) {
		throw new IllegalArgumentException("ID Does not exist");
	}
	Task taskToUpdate = idToTask.get(description);
	taskToUpdate.setDescription(description);
}
}
-----------------------------------------------------------------
taskServiceTest.java
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
   public static List<Task> tasks = new ArrayList<>();
    TaskService taskService = new TaskService();
    
    @Test
    public void invalidNameTest() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	taskService.addTask("1", "Go to the store kjk;lajdsf;lkjsj", "at 5pm");
    	});
    }
    
    @Test
    public void invalidIdTest() {
    	Assertions.assertThrows(IllegalArgumentException.class,() -> {
    		taskService.addTask("234389874323", "name", "description");
    	});
    }
    
    @Test
    public void invalidDescriptionTest() {
    	Assertions.assertThrows(IllegalArgumentException.class,() -> {
    		taskService.addTask("234389", "name", "welrekjosjdifjadjflakjdslgjaijweoiajlsdkjfaljglkasaf");
    	});

    }
    @Test
    public void addValidTask () {
    	taskService.addTask("1", "test", "description");
    	Task testTask = taskService.getTask("1");
    	Assertions.assertEquals("description", testTask.getDescription());
    }
    @Test
    public void deleteTaskMissingId() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		taskService.deleteTask("10");
    	});
    }
    
    @Test
    public void deleteTask() {
    	taskService.addTask("1", "test", "description");
    	taskService.deleteTask("1");
    }
}

--------------------------------------------------------------
taskTest.java
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
