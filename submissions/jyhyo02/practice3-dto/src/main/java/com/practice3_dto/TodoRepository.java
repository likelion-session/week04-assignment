package com.likelion04.practice3_dto;

import com.likelion04.practice3_dto.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}