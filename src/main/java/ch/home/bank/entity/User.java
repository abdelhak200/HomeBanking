package ch.home.bank.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="USERS")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String  Prenom;
	private String Nom;
	private LocalDate Date_de_naissance;
	private LocalDateTime Date_debut_contrat;
	private LocalDateTime Date_fin_contrat;
	
	public User(String prenom, String nom, LocalDate date_de_naissance, LocalDateTime date_debut_contrat,
			LocalDateTime date_fin_contrat) {
		Prenom = prenom;
		Nom = nom;
		Date_de_naissance = date_de_naissance;
		Date_debut_contrat = date_debut_contrat;
		Date_fin_contrat = date_fin_contrat;
	}

	public User() {}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public LocalDate getDate_de_naissance() {
		return Date_de_naissance;
	}

	public void setDate_de_naissance(LocalDate date_de_naissance) {
		Date_de_naissance = date_de_naissance;
	}

	public LocalDateTime getDate_debut_contrat() {
		return Date_debut_contrat;
	}

	public void setDate_debut_contrat(LocalDateTime date_debut_contrat) {
		Date_debut_contrat = date_debut_contrat;
	}

	public LocalDateTime getDate_fin_contrat() {
		return Date_fin_contrat;
	}

	public void setDate_fin_contrat(LocalDateTime date_fin_contrat) {
		Date_fin_contrat = date_fin_contrat;
	}

}
