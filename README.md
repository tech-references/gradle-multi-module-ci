# 공통 모듈 테스트 환경
- `common` 모듈과 같이 `main` 메소드가 없는 모듈의 경우 별도의 `CommonApplicationTest`를 `@SpringBootApplication` 애너테이션과 함께 추가하여 성공적으로 테스트가 동작할 수 있도록 한다.
  - 이때 불필요한 테스트 케이스 추가를 막기 위해 `@Test` 애너테이션은 사용하지 않는다.

# settings.gradle
- `settings.gradle`은 root directory에만 존재해야 함