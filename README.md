# 공통 모듈 테스트 환경
- `common` 모듈과 같이 `main` 메소드가 없는 모듈의 경우 별도의 `CommonApplicationTest`를 `@SpringBootApplication` 애너테이션과 함께 추가하여 성공적으로 테스트가 동작할 수 있도록 한다.
  - 이때 불필요한 테스트 케이스 추가를 막기 위해 `@Test` 애너테이션은 사용하지 않는다.

# settings.gradle
- `settings.gradle`은 root directory에만 존재해야 함

# api 모듈에서 bean 불러오기
```java
package me.bigfanoftim.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"me.bigfanoftim.core"})
@EnableJpaRepositories(basePackages = {"me.bigfanoftim.core"})
@ComponentScan(basePackages = {"me.bigfanoftim.api", "me.bigfanoftim.core"})
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
```
위와 같이 적절한 애너테이션을 사용해서 필요한 모듈을 스캔해줘야 한다.

또한 `@ComponentScan` 애너테이션은 지정한 패키지와, 그 하위 패키지만 스캔하기 때문에 만약 `core`만 추가해줬다면 api 모듈의 
다른 패키지를 불러오지 못하게 된다.

![core만 스캔한 경우 ProductController Bean이 없다.](images%2F%40ComponentScan_Spring_Bean.png)

따라서 이런 식으로 멀티 모듈을 구성하는 경우 api 모듈도 추가해줘야 한다.
