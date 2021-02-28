package ac.fst.rsabsence.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ac.fst.rsabsence.dao.UserRepository;
import ac.fst.rsabsence.model.MyUser;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> user = repository.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException(username+" non trouvé!"));
		return user.map(MyUserDetails::new).get();
	}
}
