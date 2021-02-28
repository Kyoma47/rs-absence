package ac.fst.rsabsence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Eleve {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IDeleve;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private Boolean isAbsent = false;
	@ManyToOne
	private Classe classe;
	@ManyToMany
	private Set<Seance> seancesAbsences = new HashSet<Seance>();
	
	//Constructeurs
	public Eleve(){}
	public Eleve(String nom, String prenom, String email, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}
	
	//Getters & Setters
	public long getIDeleve() {
		return IDeleve;
	}
	public void setIDeleve(long iDeleve) {
		IDeleve = iDeleve;
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
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Set<Seance> getSeancesAbsences() {
		return seancesAbsences;
	}
	public void setSeancesAbsences(Set<Seance> seancesAbsences) {
		this.seancesAbsences = seancesAbsences;
	}
	public Boolean getIsAbsent() {
		return isAbsent;
	}
	public void setIsAbsent(Boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	//Methode
	public String toString() {
		return "Eleve :\tId : "+IDeleve+"\n\tNom : "+nom+"\n\tPrenom : "+prenom+"\n\tEmail : "+email+"\n\tAdresse : "+adresse+"\n\tClasse : "+classe;
	}
}
