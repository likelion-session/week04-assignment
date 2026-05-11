package com.example.practice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST 컨트롤러 클래스 
// - @RestController: 이 클래스의 모든 핸들러 메서드는 응답 본문(body)을 반환
// - @RequestMapping("/api"): 이 컨트롤러의 기본 경로를 "/api"로 설정
@RestController
@RequestMapping("/api")
public class HelloController {

    // GET /api/hello 요청을 처리
    // 브라우저나 Postman에서 호출하면 문자열 "Hello, Spring Boot!"반환
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    // GET /api/hello/{name} 요청을 처리
    // {name} 부분은 경로 변수(Path Variable)로 받아서 메서드의 매개변수로 전달
    // 예: GET /api/hello/eunseo -> 응답: "Hello, eunseo!"
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}