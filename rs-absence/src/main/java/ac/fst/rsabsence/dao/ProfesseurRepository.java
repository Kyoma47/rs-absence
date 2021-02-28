package ac.fst.rsabsence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.fst.rsabsence.model.Professeur;


public interface ProfesseurRepository extends JpaRepository<Professeur, Long>{
}
