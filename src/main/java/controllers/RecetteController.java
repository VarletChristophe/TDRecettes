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
import models.Recette;
import services.RecetteService;


@Data
@RestController
@RequestMapping("recettes") //localhost:8080/recettes 
public class RecetteController {

	@Autowired
	private RecetteService recetteService;
	
	
	@GetMapping() //localhost:8080/recettes --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findAll() {
		return this.recetteService.getAll();
	}
	
	
	// CRUD : Create / Read / Update / Delete
	
	
	//Read
	@GetMapping("/{id}") //localhost:8080/recettes/id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.recetteService.findById(id);
	}
	
	//Exercice ... User qui donne la liste des clients qui ont le nom "nom"
	@GetMapping("/nom/{nom}") //localhost:8080/recettes/nom/recette_nom--> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByNom(@PathVariable String nom) {
		return this.recetteService.findByNom(nom);
	}
	
	//Create
	@PostMapping() //localhost:8080/recettes  --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recette create(@RequestBody Recette recette) {
		return this.recetteService.create(recette);
	}
	
	//Update
	@PutMapping("/{id}") //localhost:8080/recettes/id  --> PUT
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Recette update(@PathVariable String id, @RequestBody Recette recette) {
		Recette oldRecette = this.recetteService.findById(id);
		recette.setId(oldRecette.getId());
		return this.recetteService.update(recette);
	}
	
	//Delete
	@DeleteMapping("/{id}") //localhost:8080/recettes  --> POST
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		this.recetteService.delete(id);
	}
}
