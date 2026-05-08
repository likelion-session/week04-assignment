package com.example.practice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 이 클래스는 Spring Boot 애플리케이션의 진입점(entry point)
// - @SpringBootApplication: 컴포넌트 스캔, 자동 설정 등을 활성화
// - main(): 이 메서드가 JVM에서 실행되면 스프링 컨텍스트가 생성되고 내장 톰캣이 시작
@SpringBootApplication
public class Practice1HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(Practice1HelloApplication.class, args);
    }
}