package ac.fst.rsabsence.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.fst.rsabsence.dao.EleveRepository;
import ac.fst.rsabsence.dao.ProfesseurRepository;
import ac.fst.rsabsence.dao.SeanceRepository;
import ac.fst.rsabsence.model.Eleve;
import ac.fst.rsabsence.model.Matiere;
import ac.fst.rsabsence.model.Seance;

@RestController
public class AbsenceRest {


	@Autowired
	EleveRepository eleveRepository;
	@Autowired
	ProfesseurRepository professeurRepository;
	@Autowired
	SeanceRepository seanceRepository;
	
	@PostMapping("prof/saveAbsence/eleve/{idEleve}/seance/{idSeance}")
	public void addAbsenceEleve(@PathVariable("idEleve") long idEleve, @PathVariable("idSeance") long idSeance) {
		Eleve e = eleveRepository.findById(idEleve).get();
		Seance s = seanceRepository.findById(idSeance).get();
		e.setIsAbsent(true);
		e.getSeancesAbsences().add(s);
		s.getElevesAbsents().add(e);
		seanceRepository.save(s);
		eleveRepository.save(e);
	}
	
	
	@DeleteMapping("prof/deleteAbsence/eleve/{idEleve}/seance/{idSeance}")
	public void deleteAbsence(@PathVariable("idEleve") long idEleve, @PathVariable("idSeance") long idSeance) {
		Eleve e = eleveRepository.findById(idEleve).get();
		Seance s = seanceRepository.findById(idSeance).get();
		e.getSeancesAbsences().remove(s);
		if(e.getSeancesAbsences().isEmpty()) {
			e.setIsAbsent(false); }
		eleveRepository.save(e);
	}
	
	
	@GetMapping("prof/{id}/seances")
	public List<Seance> listeSeances(@PathVariable("id") long id){
		List<Seance> liste = new ArrayList<Seance>();
		for (Matiere m : professeurRepository.findById(id).get().getListe_matieres()) {
				liste.addAll(m.getListe_seances());
		}
		return liste;	
	}
	
	@GetMapping("prof/eleves/seance/{id}")
	public Set <Eleve> listeElevesAvecEleveSeance(@PathVariable("id") long id){		
		return seanceRepository.findById(id).get().getClasse().getListe_eleves();
	}
	
}
