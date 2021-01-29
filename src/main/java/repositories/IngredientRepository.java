package repositories;

import java.util.List;
import java.util.Optional;

import models.Ingredient;

public interface IngredientRepository {
	public List<Ingredient> findAll();
	public Optional<Ingredient> findById(String id);
	public List<Ingredient> findByNom(String nom);
	public Ingredient insert(Ingredient ingredient);
	public Ingredient save(Ingredient ingredient);
	public void deleteById(String id);
}
