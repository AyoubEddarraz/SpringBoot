package com.todo.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.myapp.entities.TodoEntity;

@Repository
public interface TodoRipository extends JpaRepository<TodoEntity, Long> {

}
