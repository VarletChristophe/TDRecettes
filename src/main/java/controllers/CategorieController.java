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
import models.Categorie;
import services.CategorieService;


@Data
@RestController
@RequestMapping("categories") //localhost:8080/categories 
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	
	
	@GetMapping() //localhost:8080/categories --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findAll() {
		return this.categorieService.getAll();
	}
	
	
	// CRUD : Create / Read / Update / Delete
	
	
	//Read
	@GetMapping("/{id}") //localhost:8080/categories/id --> GET
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie findById(@PathVariable String id) {
		return this.categorieService.findById(id);
	}
	
	//Exercice ... User qui donne la liste des clients qui ont le nom "nom"
	@GetMapping("/nom/{nom}") //localhost:8080/categories/nom/recette_nom--> GET
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findByNom(@PathVariable String nom) {
		return this.categorieService.findByNom(nom);
	}
	
	//Create
	@PostMapping() //localhost:8080/categories  --> POST
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categorie create(@RequestBody Categorie categorie) {
		return this.categorieService.create(categorie);
	}
	
	//Update
	@PutMapping("/{id}") //localhost:8080/categories/id  --> PUT
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Categorie update(@PathVariable String id, @RequestBody Categorie categorie) {
		Categorie oldCategorie = this.categorieService.findById(id);
		categorie.setId(oldCategorie.getId());
		return this.categorieService.update(categorie);
	}
	
	//Delete
	@DeleteMapping("/{id}") //localhost:8080/categories  --> POST
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		this.categorieService.delete(id);
	}
}
