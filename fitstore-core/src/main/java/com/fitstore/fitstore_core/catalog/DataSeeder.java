package com.fitstore.fitstore_core.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    public  DataSeeder(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args){
        if(productRepository.count() == 0){
            productRepository.save(createProduct("Whey Protein 1kg", "High quality whey protein isolate", new BigDecimal("2499.00")));
            productRepository.save(createProduct("Creatine Monohydrate", "Pure creatine for strength gains", new BigDecimal("899.00")));
            productRepository.save(createProduct("Adjustable Dumbbells", "5-50kg adjustable dumbbell set", new BigDecimal("15999.00")));
            productRepository.save(createProduct("Resistance Bands Set", "5 levels of resistance", new BigDecimal("599.00")));
            productRepository.save(createProduct("Yoga Mat", "Non-slip premium yoga mat", new BigDecimal("1299.00")));
            System.out.println("Seeded 5 products.");
        }
    }
    private Product createProduct(String name, String description, BigDecimal price){
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setCreatedAt(java.time.LocalDateTime.now());
        return p;
    }
}
