package me.bigfanoftim.core.product.service;

import lombok.RequiredArgsConstructor;
import me.bigfanoftim.core.product.domain.Product;
import me.bigfanoftim.core.product.domain.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Optional<Product> findOptByName(String productName) {
        return productRepository.findByName(productName);
    }
}

