package com.likelion04.practice3_dto;

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
    public ResponseEntity<?> getTodoById(@PathVariable Long id) {

        TodoResponseDTO todo = todoService.getTodoById(id);

        if (todo == null) {

            return ResponseEntity
                    .status(404)
                    .body("Todo 내역을 찾을 수 없습니다.");
        }

        return ResponseEntity.ok(todo);
    }

    // POST 생성
    @PostMapping
    public TodoResponseDTO createTodo(
            @RequestBody TodoRequestDTO requestDTO
    ) {

        return todoService.createTodo(requestDTO);
    }

    // PUT 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(
            @PathVariable Long id,
            @RequestBody TodoRequestDTO requestDTO
    ) {

        TodoResponseDTO todo =
                todoService.updateTodo(id, requestDTO);

        if (todo == null) {

            return ResponseEntity
                    .status(404)
                    .body("Todo 내역을 찾을 수 없습니다.");
        }

        return ResponseEntity.ok(todo);
    }

    // DELETE 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {

        boolean deleted = todoService.deleteTodo(id);

        if (!deleted) {

            return ResponseEntity
                    .status(404)
                    .body("Todo 내역을 찾을 수 없습니다.");
        }

        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }
}