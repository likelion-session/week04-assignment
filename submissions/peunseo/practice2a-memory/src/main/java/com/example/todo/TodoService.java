package com.example.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final Map<Long, Todo> store = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<Todo> getAllTodos() {
        return new ArrayList<>(store.values());
    }

    public Optional<Todo> getTodoById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Todo createTodo(Todo todo) {
        Long id = sequence.incrementAndGet();
        todo.setId(id);
        todo.setCreatedAt(LocalDateTime.now());
        store.put(id, todo);
        return todo;
    }

    public boolean deleteTodo(Long id) {
        return store.remove(id) != null;
    }
}
