package com.todo.myapp.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.myapp.entities.TodoEntity;
import com.todo.myapp.repositories.TodoRipository;
import com.todo.myapp.requests.TodoRequest;
import com.todo.myapp.responses.TodoResponse;
import com.todo.myapp.services.TodoService;
import com.todo.myapp.tdo.TodoDto;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/")
public class TodoController {

	// Dependency Injection
	// TODO Repository extends of CrudRepository
	@Autowired
	private TodoRipository todoRipository;
	
	// TODO Interface Contain all methods logic of TODO
	@Autowired
	private TodoService todoService;
	
	// Get All TODO from TODOS Table
	@GetMapping("/todos")
	private List<TodoEntity> getAllTodos() {
		return todoRipository.findAll();
	}
	
	// Add New TODO to TODOS table
	@PostMapping("/todos")
	private TodoResponse addTodo(@RequestBody TodoRequest todoRequest) {
	
		// Convert TOTO Request to TODO DTO(Data transfer Object)
		TodoDto todoDto = new TodoDto();
		BeanUtils.copyProperties(todoRequest, todoDto);
		
		// Pass DATA to AddNewTodo method
		TodoDto newTodo = todoService.addNewTodo(todoDto);
		
		// Convert Response of newTodo to TODO Response
		TodoResponse todoResponse = new TodoResponse();
		BeanUtils.copyProperties(newTodo, todoResponse);
		
		return todoResponse;
		
	}
	
	// UPDATE TODO
	@PutMapping("/todos/{id}")
	private TodoResponse updateTodo(@PathVariable Long id , @RequestBody TodoRequest todoRequest) {
		
		TodoDto todoDto = new TodoDto();
		BeanUtils.copyProperties(todoRequest, todoDto);
		
		TodoDto contactUpdated = todoService.updateTodo(id, todoDto);
		
		TodoResponse todoResponse = new TodoResponse();
		BeanUtils.copyProperties(contactUpdated, todoResponse);
		
		return todoResponse;
		
	}
	
	// Delete TODO from the Database by TODO Id
	@DeleteMapping("/todos/{id}")
	private String deleteTodo(@PathVariable Long id) {
		
		String todoDelete = todoService.deleteTodo(id);
		return todoDelete;
	
	}
	
	
	
	
}
