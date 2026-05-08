package com.example.practice1.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

// Todo를 메모리에 저장
// DB 없이 Map 사용, id 1씩 증가
@Service
public class TodoService {
    private final Map<Long, Todo> todos = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public synchronized List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    public synchronized Optional<Todo> getTodoById(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    public synchronized Todo createTodo(Todo todo) {
        Long id = sequence.incrementAndGet();
        todo.setId(id);
        todo.setCreatedAt(LocalDateTime.now());
        todos.put(id, todo);
        return todo;
    }

    public synchronized boolean deleteTodo(Long id) {
        return todos.remove(id) != null;
    }
}
