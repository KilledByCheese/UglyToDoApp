package de.killedbycheese.ToDoAppServer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FakeToDoDB {
	
	List<ToDoItem> todos;
	
	public FakeToDoDB() {
		todos = new ArrayList<ToDoItem>();
	}
	
	public void addItem(String todo) {
		if(!todos.contains(new ToDoItem(todo))) {
			todos.add(new ToDoItem(todo));
		}
	}
	
	public void removeItem(String todo) {
		ToDoItem removeItem = new ToDoItem(todo);
		todos.remove(removeItem);
	}
	
	public List<ToDoItem> getTodos() {
		return todos;
	}

}
