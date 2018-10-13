package com.robinlarsson.webfluxtest.repositories;

import com.robinlarsson.webfluxtest.models.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor,String> {
}
