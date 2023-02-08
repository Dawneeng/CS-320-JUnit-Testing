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

