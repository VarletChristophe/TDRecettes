package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{
	public List<Recette> findAll();
	public Optional<Recette> findById(String id);
	public List<Recette> findByNom(String nom);
	@SuppressWarnings("unchecked")
	public Recette insert(Recette recette);
	@SuppressWarnings("unchecked")
	public Recette save(Recette recette);
	public void deleteById(String id);
}
