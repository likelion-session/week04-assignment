package com.likelion04.practice2b_jpa;

import com.likelion04.practice2b_jpa.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}