
package com.example.todo.repository;

import com.example.todo.model.Todo;

import java.util.*;

public interface TodoRepository {
    List<Todo> findAll();

    Optional<Todo> findById(int id);

    Todo save(Todo todo);

    void deleteById(int id);
}
