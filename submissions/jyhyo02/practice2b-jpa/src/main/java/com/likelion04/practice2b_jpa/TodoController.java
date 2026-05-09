package com.likelion04.practice2b_jpa;

import com.likelion04.practice2b_jpa.Todo;
import com.likelion04.practice2b_jpa.TodoService;
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

    public List<Todo> getAllTodos() {

        return todoService.getAllTodos();

    }

    // GET 단건조회

    @GetMapping("/{id}")

    public ResponseEntity<?> getTodoById(@PathVariable Long id) {

        Todo todo = todoService.getTodoById(id);

        if (todo == null) {

            return ResponseEntity.status(404).body("Todo 내역을 찾을 수 없습니다.");

        }

        return ResponseEntity.ok(todo);

    }

    // POST 생성

    @PostMapping

    public Todo createTodo(@RequestBody Todo todo) {

        return todoService.createTodo(todo);

    }

    // PUT 수정

    @PutMapping("/{id}")

    public ResponseEntity<?> updateTodo(

            @PathVariable Long id,

            @RequestBody Todo updatedTodo

    ) {

        Todo todo = todoService.updateTodo(id, updatedTodo);

        if (todo == null) {

            return ResponseEntity.status(404).body("Todo 내역을 찾을 수 없습니다.");

        }

        return ResponseEntity.ok(todo);

    }

    // DELETE 삭제

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {

        boolean deleted = todoService.deleteTodo(id);

        if (!deleted) {

            return ResponseEntity.status(404).body("Todo 내역을 찾을 수 없습니다.");

        }

        return ResponseEntity.ok("삭제가 완료되었습니다.");

    }

}