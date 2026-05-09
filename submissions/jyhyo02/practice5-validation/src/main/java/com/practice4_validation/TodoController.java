package com.likelion04.practice5_validation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET 전체조회
    @GetMapping
    public List<TodoResponseDTO> getAllTodos() {

        return todoService.getAllTodos();
    }

    // GET 단건조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDTO>
    getTodoById(@PathVariable Long id) {

        TodoResponseDTO todo =
                todoService.getTodoById(id);

        return ResponseEntity.ok(todo);
    }

    // POST 생성
    @PostMapping
    public TodoResponseDTO createTodo(
            @Valid @RequestBody TodoRequestDTO requestDTO
    ) {

        return todoService.createTodo(requestDTO);
    }

    // PUT 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO>
    updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody TodoRequestDTO requestDTO
    ) {

        TodoResponseDTO todo =
                todoService.updateTodo(id, requestDTO);

        return ResponseEntity.ok(todo);
    }

    // DELETE 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }
}