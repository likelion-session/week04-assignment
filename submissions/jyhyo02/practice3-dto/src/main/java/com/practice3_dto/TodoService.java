package com.likelion04.practice3_dto;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Entity -> ResponseDTO 변환
    private TodoResponseDTO convertToDTO(Todo todo) {

        return new TodoResponseDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }

    // 전체 조회
    public List<TodoResponseDTO> getAllTodos() {

        return todoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 단건 조회
    public TodoResponseDTO getTodoById(Long id) {

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        return optionalTodo
                .map(this::convertToDTO)
                .orElse(null);
    }

    // 생성
    public TodoResponseDTO createTodo(TodoRequestDTO requestDTO) {

        Todo todo = new Todo();

        todo.setTitle(requestDTO.getTitle());
        todo.setDescription(requestDTO.getDescription());
        todo.setCompleted(requestDTO.isCompleted());
        todo.setCreatedAt(LocalDateTime.now());

        Todo savedTodo = todoRepository.save(todo);

        return convertToDTO(savedTodo);
    }

    // 수정
    public TodoResponseDTO updateTodo(Long id, TodoRequestDTO requestDTO) {

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isEmpty()) {
            return null;
        }

        Todo todo = optionalTodo.get();

        todo.setTitle(requestDTO.getTitle());
        todo.setDescription(requestDTO.getDescription());
        todo.setCompleted(requestDTO.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return convertToDTO(updatedTodo);
    }

    // 삭제
    public boolean deleteTodo(Long id) {

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isEmpty()) {
            return false;
        }

        todoRepository.delete(optionalTodo.get());

        return true;
    }
}