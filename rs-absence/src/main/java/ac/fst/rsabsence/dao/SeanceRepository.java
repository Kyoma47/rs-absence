package ac.fst.rsabsence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.fst.rsabsence.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long>{

}
