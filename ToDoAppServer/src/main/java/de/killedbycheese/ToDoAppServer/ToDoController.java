package de.killedbycheese.ToDoAppServer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/todo")
public class ToDoController {
	
	@Autowired
	FakeToDoDB database;
			
	@GetMapping
	public ResponseEntity<?> getToDos()  {
		List<ToDoItem> todos = database.getTodos();
		return new ResponseEntity<List<ToDoItem>>(todos, HttpStatus.OK);			
	}
	
	@PostMapping
	public ResponseEntity<?> addToDo(@RequestBody String todo)  {
		database.addItem(todo);
		return new ResponseEntity<String>("Added", HttpStatus.OK);			
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeTodo(@RequestBody String todo)  {
		database.removeItem(todo);
		return new ResponseEntity<String>("Removed", HttpStatus.OK);			
	}
	
}
