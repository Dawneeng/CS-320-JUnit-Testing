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
