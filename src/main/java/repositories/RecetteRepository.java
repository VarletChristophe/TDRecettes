package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{
	public List<Recette> findAll();
	public List<Recette> findByNom(String nom);
	public List<Recette> findByCategorie(String nom);

}
