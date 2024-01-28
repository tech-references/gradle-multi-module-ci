package me.bigfanoftim.common.product.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ProductRepository Interface")
@ActiveProfiles("test")
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Nested
    @DisplayName("이미 생성된 Product를")
    class WithProduct {

        private String productName;

        @BeforeEach
        void prepare() {
            productName = "Macbook";
            Product macbook = Product.builder()
                    .name(productName)
                    .imageUrl("www.apple.com")
                    .build();
            productRepository.save(macbook);
        }

        @Test
        @DisplayName("이름으로 조회할 수 있다.")
        public void 이름으로_조회할_수_있다() throws Exception {
            Optional<Product> product = productRepository.findByName(productName);

            assertThat(product).isNotEmpty();
        }
    }
}