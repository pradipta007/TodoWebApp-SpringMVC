package com.pradipta.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Pradipta", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todo(2, "Pradipta", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "Pradipta", "Learn Hibernate", new Date(),
				false));
	}

	//Add
//	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
//		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
//	}
	public void addTodo(Todo todo) { //using object as a parameter instead of above addTodo method makes our "date" field getting exact input value
		todos.add(todo);
	}
	
	//Update Todo(Step 1: Retrive the id of the todo that u want to update, 
	//Step 2: Update the todo(nothing but adding functionality)
	
	public Todo retrieveTodo(int id) { //retrieve ac to id(int)
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
	
	//Reteive all todos a/q to user
	public List<Todo> retrieveTodos(String user) { // retrive ac to user(String)
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	//Delete a todo
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}
