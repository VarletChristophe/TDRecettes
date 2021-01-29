package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Categorie;

public interface CategorieRepository extends MongoRepository<Categorie, String>{

	public List<Categorie> findAll();
	public Optional<Categorie> findById(String id);
	public List<Categorie> findByNom(String nom);
	@SuppressWarnings("unchecked")
	public Categorie insert(Categorie recette);
	@SuppressWarnings("unchecked")
	public Categorie save(Categorie categorie);
	public void deleteById(String id);
}
