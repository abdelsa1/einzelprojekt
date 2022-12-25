package ch.zhaw.einzelprojekt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.einzelprojekt.model.Studierende;

public interface StudierendeRepository extends 
MongoRepository <Studierende, String> {
        List<Studierende> findByEmail(String email); 
    }
