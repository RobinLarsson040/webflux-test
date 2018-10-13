package com.robinlarsson.webfluxtest.start;

import com.robinlarsson.webfluxtest.models.Category;
import com.robinlarsson.webfluxtest.models.Vendor;
import com.robinlarsson.webfluxtest.repositories.CategoryRepository;
import com.robinlarsson.webfluxtest.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Start implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private VendorRepository vendorRepository;

    @Autowired
    public Start(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {

            System.out.println("####### LOADING EXAMPLE DATA #######");

            categoryRepository.save(Category.builder().description("fruits").build()).block();
            categoryRepository.save(Category.builder().description("nuts").build()).block();
            categoryRepository.save(Category.builder().description("sodas").build()).block();
            categoryRepository.save(Category.builder().description("candy").build()).block();

            System.out.println("Loading Categories: " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder().firstName("Jonas").lastName("Karlsson").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Robin").lastName("Larsson").build()).block();

            System.out.println("Loading Categories: " + vendorRepository.count().block());

        }else{
            System.out.println("####### LOADING DATA #######");
            System.out.println("Loading Categories: " + categoryRepository.count().block());
            System.out.println("Loading Categories: " + vendorRepository.count().block());
        }


    }
}
