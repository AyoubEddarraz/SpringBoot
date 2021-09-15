package com.todo.myapp.TodoServiceImplimentations;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.myapp.entities.TodoEntity;
import com.todo.myapp.repositories.TodoRipository;
import com.todo.myapp.services.TodoService;
import com.todo.myapp.tdo.TodoDto;

@Service
public class TodoImp implements TodoService {

	// Dependency Injection
	@Autowired
	private TodoRipository todoRipository;
	
	@Override
	public TodoDto addNewTodo(TodoDto todo) {
		
		// Convert TOTO DTO(Data transfer Object) to TODO Entity
		TodoEntity todoEntity = new TodoEntity();
		BeanUtils.copyProperties(todo, todoEntity);
		
		// Add TODO Entity to DataBase with save method from CrudRepository extended in todoRepository
		TodoEntity newTodo = todoRipository.save(todoEntity);
		
		// add 
		TodoDto todoDto = new TodoDto();
		BeanUtils.copyProperties(newTodo, todoDto);
		
		return todoDto;
	}

	@Override
	public TodoDto updateTodo(Long id, TodoDto todoDto) {
		
		TodoEntity todoEntity = new TodoEntity();
		BeanUtils.copyProperties(todoDto, todoEntity);
		
		TodoEntity contactFounded = todoRipository.getById(id);
		
		contactFounded.setContactName(todoDto.getContactName());
		contactFounded.setContactNumero(todoDto.getContactNumero());
		
		TodoEntity updatedContact = todoRipository.save(contactFounded);
		
		TodoDto todoContactDto = new TodoDto();
		BeanUtils.copyProperties(updatedContact, todoContactDto);
		
		return todoContactDto;
	}

	@Override
	public String deleteTodo(Long id) {
		
		TodoEntity todo = todoRipository.getById(id);
		todoRipository.delete(todo);
		
		return "contact deleted with success";
		
	}
	

}
