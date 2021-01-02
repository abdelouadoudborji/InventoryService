package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository produitRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            produitRepository.save(new Product(null, "Ordinateur", 5000, 3));
            produitRepository.save(new Product(null, "Imprimante", 4000, 2));
            produitRepository.save(new Product(null, "SmartPhone", 3000, 1));
            produitRepository.findAll().forEach(p ->{
                System.out.println(p.getName());
            });

        };
    }
}
