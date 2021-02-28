package ac.fst.rsabsence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ac.fst.rsabsence.dao.ClasseRepository;
import ac.fst.rsabsence.dao.EleveRepository;
import ac.fst.rsabsence.dao.ProfesseurRepository;
import ac.fst.rsabsence.dao.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RsAbsenceApplication implements CommandLineRunner{

	@Autowired
	EleveRepository eleve_repository;
	
	@Autowired
	ClasseRepository classe_repository;
	
	@Autowired
	ProfesseurRepository prof_repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RsAbsenceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}

}
