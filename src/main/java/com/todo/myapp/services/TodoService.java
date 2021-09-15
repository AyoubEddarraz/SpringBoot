package com.todo.myapp.services;

import com.todo.myapp.tdo.TodoDto;

public interface TodoService {

	TodoDto addNewTodo(TodoDto todoDto);
	
	TodoDto updateTodo(Long id , TodoDto todoDto);
	
	String deleteTodo(Long id);
	
}
