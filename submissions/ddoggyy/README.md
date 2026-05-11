## 개발 환경

- **JDK 버전**: JDK 21
- **Spring Boot**: 4.0.6
- **빌드 도구**: Gradle

## 실행 방법

```bash
gradlew bootRun
```

### ✅ 실습 1: 첫 번째 REST API 만들기
- HelloController 구현
- GET `/api/hello` - "Hello, Spring Boot!" 반환
- GET `/api/hello/{name}` - "Hello, {name}!" 반환

### ✅ 실습 2B: Todo CRUD API — JPA + DB
- Todo 엔티티 구현 (@Entity 사용)
- TodoRepository (JpaRepository 상속)
- TodoService (CRUD 메서드)
- TodoController (REST API 구현)
  - GET `/api/todos` - 전체 목록 조회
  - GET `/api/todos/{id}` - 단건 조회
  - POST `/api/todos` - 새 Todo 생성
  - PUT `/api/todos/{id}` - Todo 수정
  - DELETE `/api/todos/{id}` - Todo 삭제
