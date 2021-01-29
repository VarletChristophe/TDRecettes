package models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Recette")

public class Recette {
	
	@Id
	private String id;
	
	private String nom;
	private String description;
	private List<Ingredient> ingredients;
	@DBRef
	private List<Categorie> categories;
	
	public Recette() {
		super();
	}

	public Recette(String id, String nom, String description, List<Ingredient> ingredients,
			List<Categorie> categories) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.ingredients = ingredients;
		this.categories = categories;
	}

	
	
}
