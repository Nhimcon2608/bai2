package com.example.bai2.service;

import com.example.bai2.model.Category;
import com.example.bai2.model.Product;
import com.example.bai2.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(Long categoryId) {
        if (categoryId == null) {
            return productRepository.findAllByOrderByCreatedAtDesc();
        }
        return productRepository.findByCategoryIdOrderByCreatedAtDesc(categoryId);
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product saveProduct(Product product, Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại."));
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public long countProducts() {
        return productRepository.count();
    }

    @Transactional(readOnly = true)
    public long countActiveProducts() {
        return productRepository.countByActiveTrue();
    }
}
