package com.likelion04.practice5_validation;

import com.likelion04.practice5_validation.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}