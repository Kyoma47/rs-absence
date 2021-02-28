package ac.fst.rsabsence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matiere {
	
	//Attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDmatiere;
	private String nom_matiere;
	@ManyToOne
	private Professeur prof;
	@OneToMany(mappedBy="matiere")
	private Set<Seance> liste_seances = new HashSet<Seance>();
	
	//Constructeur
	public Matiere() {}
	public Matiere(String nom_matiere) {
		super();
		this.nom_matiere = nom_matiere;
	}

	//Getters & Setters
	public int getIDmatiere() {
		return IDmatiere;
	}

	public void setIDmatiere(int iDmatiere) {
		IDmatiere = iDmatiere;
	}

	public String getNom_matiere() {
		return nom_matiere;
	}

	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	
	public Set<Seance> getListe_seances() {
		return liste_seances;
	}
	
	public void setListe_seances(Set<Seance> liste_seances) {
		this.liste_seances = liste_seances;
	}
	//Methode
	public String toString() {
		return "Matière :\n\tNom_matière : "+nom_matiere;
	}
}
