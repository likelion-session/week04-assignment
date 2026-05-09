package com.likelion04.practice5_validation;

public class TodoNotFoundException
        extends RuntimeException {

    public TodoNotFoundException(Long id) {

        super("본 아이디의 Todo를 찾을 수 없습니다: " + id);
    }
}