package com.gestionFichier.gestionFichier.Repository;

import com.gestionFichier.gestionFichier.Model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<Document,  String>{
}
