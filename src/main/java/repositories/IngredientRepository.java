package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
	public List<Ingredient> findAll();
	public List<Ingredient> findByNom(String nom);
}
