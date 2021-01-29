package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Categorie;

public interface CategorieRepository extends MongoRepository<Categorie, String>{
	public List<Categorie> findAll();
	public List<Categorie> findByNom(String nom);
}
