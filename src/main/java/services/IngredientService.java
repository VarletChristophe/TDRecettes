package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import models.Ingredient;
import repositories.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository repository;
	
	public List<Ingredient> getAll() {
		return this.repository.findAll();	
	}
	
	public Ingredient findById(String id) {
		// Retourne un optional (on est pas sur de trouver un client)
		return (this.repository.findById(id))
				.orElseThrow(
						// Retourne une exception HTTP
						()->new ResponseStatusException(HttpStatus.NOT_FOUND)
				);
	}
	
	public List<Ingredient> findByNom(@PathVariable String nom) {
		return this.repository.findByNom(nom);
	}
	
	
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return this.repository.insert(ingredient);
	}
	
	public Ingredient update(@RequestBody Ingredient ingredient) {
		return this.repository.save(ingredient);
	}
	
	public void delete(@PathVariable String id) {
		this.repository.deleteById(id);
	}
}
