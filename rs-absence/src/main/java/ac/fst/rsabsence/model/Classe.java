package ac.fst.rsabsence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classe {

	//Attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDclasse;
	private int annee;
	private String semestre;
	@OneToMany(mappedBy="classe")
	private Set<Seance> liste_seances = new HashSet<Seance>();
	@OneToMany(mappedBy="classe", cascade=CascadeType.PERSIST)
	private Set<Eleve> liste_eleves = new HashSet<Eleve>();
	
	//Constructeurs
	public Classe() {}
	public Classe(int annee, String semestre) {
		this.annee = annee;
		this.semestre = semestre;
	}


	//Getters & Setters
	public int getIDclasse() {
		return IDclasse;
	}
	public void setIDclasse(int iDclasse) {
		IDclasse = iDclasse;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public Set<Seance> getListe_seances() {
		return liste_seances;
	}
	public void setListe_seances(Set<Seance> liste_seances) {
		this.liste_seances = liste_seances;
	}
	public Set<Eleve> getListe_eleves() {
		return liste_eleves;
	}
	public void setListe_eleves(Set<Eleve> liste_eleves) {
		this.liste_eleves = liste_eleves;
	}
	//Methode
	public String toString() {
		return "Classe :\n\tID : "+IDclasse+"\n\t Annee : "+annee+"\n\t Semestre : "+semestre;
	}
}
