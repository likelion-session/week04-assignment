package com.likelion04.practice2b_jpa;

import com.likelion04.practice2b_jpa.Todo;
import com.likelion04.practice2b_jpa.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 전체 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 단건 조회
    public Todo getTodoById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        return optionalTodo.orElse(null);
    }

    // 생성
    public Todo createTodo(Todo todo) {

        todo.setCreatedAt(LocalDateTime.now());

        return todoRepository.save(todo);
    }

    // 수정
    public Todo updateTodo(Long id, Todo updatedTodo) {

        Todo todo = getTodoById(id);

        if (todo == null) {
            return null;
        }

        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(todo);
    }

    // 삭제
    public boolean deleteTodo(Long id) {

        Todo todo = getTodoById(id);

        if (todo == null) {
            return false;
        }

        todoRepository.delete(todo);

        return true;
    }
}