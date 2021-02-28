package ac.fst.rsabsence.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Seance {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDseance;
	private String nom_seance;
	private Date heure_debut;
	private Date heure_fin;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private Classe classe;
	@ManyToMany(mappedBy="seancesAbsences")
	private Set<Eleve> elevesAbsents = new HashSet<Eleve>();
	
	//Constructeurs
	public Seance() {}
	public Seance(String nom_seance, Date heure_debut, Date heure_fin) {
		this.nom_seance = nom_seance;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
	}
	
	//Getters & Setters
	public int getIDseance() {
		return IDseance;
	}
	public void setIDseance(int iDseance) {
		IDseance = iDseance;
	}
	public String getNom_seance() {
		return nom_seance;
	}
	public void setNom_seance(String nom_seance) {
		this.nom_seance = nom_seance;
	}
	public Date getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(Date heure_debut) {
		this.heure_debut = heure_debut;
	}
	public Date getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Set<Eleve> getElevesAbsents() {
		return elevesAbsents;
	}
	public void setElevesAbsents(Set<Eleve> elevesAbsents) {
		this.elevesAbsents = elevesAbsents;
	}
	//Methode
	public String toString() {
		return "Seance :\n\tNom_seance : "+nom_seance+"\n\t Heure_debut : "+heure_debut+"\n\tHeure_fin : "+heure_fin;
	}
}
