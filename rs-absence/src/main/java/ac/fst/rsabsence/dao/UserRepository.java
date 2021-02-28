package ac.fst.rsabsence.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.fst.rsabsence.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer>{

	Optional<MyUser> findByUsername(String username);
}
