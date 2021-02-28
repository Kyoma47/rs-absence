package ac.fst.rsabsence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDprof;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	@OneToMany(mappedBy="prof")
	private Set<Matiere> liste_matieres = new HashSet<Matiere>();
	
	//Constructeurs
	public Professeur() {}
	public Professeur(String nom, String prenom, String email, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	//Getters & Setters
	public int getIDprof() {
		return IDprof;
	}
	public void setIDprof(int iDprof) {
		IDprof = iDprof;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Set<Matiere> getListe_matieres() {
		return liste_matieres;
	}
	public void setListe_matieres(Set<Matiere> liste_matieres) {
		this.liste_matieres = liste_matieres;
	}
	//Methode
	public String toString() {
		return "Professeur :\tId : "+IDprof+"\n\tNom : "+nom+"\n\tPrenom : "+prenom+"\n\tEmail : "+email+"\n\tAdresse : "+adresse;
	}
}
