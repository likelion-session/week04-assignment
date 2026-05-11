package com.likelion.week04_assignment;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable Long id) {
		return todoService.getTodoById(id);
	}

	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todo));
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		return todoService.updateTodo(id, todo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
}
