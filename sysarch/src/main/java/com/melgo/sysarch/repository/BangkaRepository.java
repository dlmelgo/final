package com.melgo.sysarch.repository;

import com.melgo.sysarch.model.Bangka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BangkaRepository extends MongoRepository<Bangka, String> {
    Optional<Bangka> findByName(String name);
}
