package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.*;


@Service
public class TodoJpaService {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    public List<Todo> getAllTodos() {
        return todoJpaRepository.findAll();
    }

    public Todo getTodoById(int id) {
        return todoJpaRepository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return todoJpaRepository.save(todo);
    }

    public Todo updateTodo(int id, Todo updatedTodo) {
        Optional<Todo> optionalTodo = todoJpaRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setStatus(updatedTodo.getStatus());
            return todoJpaRepository.save(todo);
        }
        return null;
    }

    public void deleteTodoById(int id) {
        todoJpaRepository.deleteById(id);
    }
}
