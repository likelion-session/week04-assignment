package com.example.demo.service;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Optional<Todo> getTodoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    public Todo createTodo(Todo todo) {
        todo.setId(nextId++);
        todo.setCompleted(false);
        todo.setCreatedAt(LocalDateTime.now());

        todos.add(todo);

        return todo;
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}