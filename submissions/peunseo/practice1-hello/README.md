# practice1-hello

간단한 Spring Boot REST API 예제입니다.

실행 (프로젝트 루트):

```powershell
.\mvnw.cmd spring-boot:run
# 또는 시스템에 Maven이 설치되어 있으면
mvn spring-boot:run
```

테스트 엔드포인트:

- `GET /api/hello` → `Hello, Spring Boot!`
- `GET /api/hello/{name}` → `Hello, {name}!` (예: `/api/hello/eunseo` → `Hello, eunseo!`)

PowerShell 예시:

```powershell
Invoke-RestMethod http://localhost:8080/api/hello
Invoke-RestMethod http://localhost:8080/api/hello/eunseo
```

브라우저에서 위 두 URL을 열어 응답을 캡처하세요.

## 실습 2A Todo API (메모리 저장)

실습 2A는 `com.example.practice1.todo` 패키지 아래에 구현했습니다.

파일 위치:

- `src/main/java/com/example/practice1/todo/Todo.java`
- `src/main/java/com/example/practice1/todo/TodoService.java`
- `src/main/java/com/example/practice1/todo/TodoController.java`

주요 엔드포인트:

- `GET /api/todos` : 전체 Todo 목록
- `GET /api/todos/{id}` : Todo 단건 조회, 없으면 404
- `POST /api/todos` : 새 Todo 생성
- `DELETE /api/todos/{id}` : Todo 삭제

예시 JSON (POST /api/todos):

```json
{
	"title": "공부하기",
	"description": "Spring Boot 실습 2A",
	"completed": false
}
```

실행 후 Postman에서 GET, POST, DELETE를 한 번씩 테스트하면 제출 요건을 충족합니다.

참고: `updateTodo(PUT)`는 이번 구현에서 제외했습니다.
