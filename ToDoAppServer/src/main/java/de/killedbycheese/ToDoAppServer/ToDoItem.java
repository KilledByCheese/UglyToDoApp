package de.killedbycheese.ToDoAppServer;

import java.io.Serializable;

public class ToDoItem implements Serializable, Comparable<ToDoItem>{

	private static final long serialVersionUID = -228247113578794773L;
	private String todo;
	
	public ToDoItem() {
	}
	
	public ToDoItem(String todo) {
		super();
		this.todo = todo;
	}
	
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ToDoItem) {
			 return ((ToDoItem) obj).getTodo().equals(this.getTodo());
		}
		return false;
	}

	@Override
	public int compareTo(ToDoItem o) {
		return o.todo.compareTo(o.getTodo());
	}
	
	
	
}
