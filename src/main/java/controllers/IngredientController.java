package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import models.Ingredient;
import services.IngredientService;



@Data
@RestController
@RequestMapping("ingredients") //localhost:8080/recettes 
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	
	@GetMapping() //localhost:8080/ingredients --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findAll() {
		return this.ingredientService.getAll();
	}
	
	
	// CRUD : Create / Read / Update / Delete
	
	
	//Read
	@GetMapping("/{id}") //localhost:8080/ingredients/id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient findById(@PathVariable String id) {
		return this.ingredientService.findById(id);
	}
	
	//Exercice ... User qui donne la liste des clients qui ont le nom "nom"
	@GetMapping("/nom/{nom}") //localhost:8080/ingredients/nom/ingredient_nom--> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findByNom(@PathVariable String nom) {
		return this.ingredientService.findByNom(nom);
	}
	
	//Create
	@PostMapping() //localhost:8080/ingredients  --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return this.ingredientService.create(ingredient);
	}
	
	//Update
	@PutMapping("/{id}") //localhost:8080/ingredients/id  --> PUT
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Ingredient update(@PathVariable String id, @RequestBody Ingredient ingredient) {
		Ingredient oldIngredient = this.ingredientService.findById(id);
		ingredient.setId(oldIngredient.getId());
		return this.ingredientService.update(ingredient);
	}
	
	//Delete
	@DeleteMapping("/{id}") //localhost:8080/recettes  --> POST
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		this.ingredientService.delete(id);
	}
}
