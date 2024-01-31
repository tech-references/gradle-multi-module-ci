package me.bigfanoftim.api.product.controller;

import lombok.RequiredArgsConstructor;
import me.bigfanoftim.core.product.domain.Product;
import me.bigfanoftim.core.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public int find() {
        Optional<Product> productOpt = productService.findOptByName("noProduct");

        if (productOpt.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
