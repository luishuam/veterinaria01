package ph.edu.cibertec.veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

	public void ejemplo(MascotaRepository mascotaRepository){

		//Ejmplo
		var tomy = new Mascota();
		tomy.owner = "Arthur";
		tomy.name = "Tomy";

		mascotaRepository.save(tomy);

		var pipo = new Mascota();
		pipo.owner = "Arthur";
		pipo.name = "Pipo";

		mascotaRepository.save(pipo);
		
	}


}
