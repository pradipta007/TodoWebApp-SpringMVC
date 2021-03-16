package com.pradipta.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	//Bind the given type of date format whenever binding happens
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	@RequestMapping(value = "/list-todos",method = RequestMethod.GET)	 
	public String showTodoPage(ModelMap model)
	{
		
		model.addAttribute("todos",service.retrieveTodos(retrieveLoggedinUserName()));
		
		return "list-todos"; 
	}
	
	private String retrieveLoggedinUserName() {
		return "Pradipta";
	}


	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)	 
	public String showAddTodoPage(ModelMap model)
	{
		model.addAttribute("todo",new Todo(0,"pradipta","Default description",new Date(),false));
		return "todo"; 
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)	 
	public String addTodo(ModelMap model, Todo todo)
	{
//		service.addTodo("Pradipta",todo.getDesc(),new Date(),false);
		todo.setUser("Pradipta");
		service.addTodo(todo);
		return "redirect:list-todos"; 
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.GET)
	public String UpdateTodo(@RequestParam int id, ModelMap model)
	{
		Todo todo =service.retrieveTodo(id);
		model.addAttribute("todo",todo);
		return "todo"; 
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.POST)
	public String UpdateTodo(Todo todo, ModelMap model)
	{
		todo.setUser("Pradipta");//not passing the name using <form:hidden path="name" due to security issue
		service.updateTodo(todo);
		return "redirect:list-todos"; 
	}

	@RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos"; 
	}
	
}
