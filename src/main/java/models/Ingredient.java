package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Ingredient")
public class Ingredient {
	
	@Id
	private String id;
	
	private String nom;
	private double quantite;
	private String unite;
	
	public Ingredient() {
		super();
	}

	public Ingredient(String id, String nom, double quantite, String unite) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}

}
