package com.likelion04.practice4_exception;

import com.likelion04.practice4_exception.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}