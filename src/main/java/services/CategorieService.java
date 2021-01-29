package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import models.Categorie;
import repositories.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository repository;
	
	public List<Categorie> getAll() {
		return this.repository.findAll();	
	}
	
	public Categorie findById(String id) {
		// Retourne un optional (on est pas sur de trouver un client)
		return (this.repository.findById(id))
				.orElseThrow(
						// Retourne une exception HTTP
						()->new ResponseStatusException(HttpStatus.NOT_FOUND)
				);
	}
	
	public List<Categorie> findByNom(@PathVariable String nom) {
		return this.repository.findByNom(nom);
	}
	
	
	public Categorie create(@RequestBody Categorie categorie) {
		return this.repository.insert(categorie);
	}
	
	public Categorie update(@RequestBody Categorie categorie) {
		return this.repository.save(categorie);
	}
	
	public void delete(@PathVariable String id) {
		this.repository.deleteById(id);
	}

}
