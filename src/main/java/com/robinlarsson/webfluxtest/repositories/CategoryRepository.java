package com.robinlarsson.webfluxtest.repositories;

import com.robinlarsson.webfluxtest.models.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {

}
