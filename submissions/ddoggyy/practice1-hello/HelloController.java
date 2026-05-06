
package com.likelion.week04_assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/hello")
	public String hello() {
		return "Hello, Spring Boot!";
	}

	@GetMapping("/api/hello/{name}")
	public String helloName(@PathVariable String name) {
		return "Hello, " + name + "!";
	}
}
