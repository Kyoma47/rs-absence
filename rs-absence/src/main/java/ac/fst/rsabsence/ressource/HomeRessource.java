package ac.fst.rsabsence.ressource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeRessource {
	//@GetMapping("/")
	@RequestMapping("/")
    public String home() {
        //return ("<h1>Bienvenue à tous et à toutes</h1>");
		return "accueil";
    }

    @GetMapping("/prof")
    public String user() {
        return ("<h1>Bienvenue à votre espace <Professeur></h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Bienvenue à votre espace <Admin></h1>");
    }
}
