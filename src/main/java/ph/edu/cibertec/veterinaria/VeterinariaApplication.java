package ph.edu.cibertec.veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ph.edu.cibertec.veterinaria.entidades.Mascota;
import ph.edu.cibertec.veterinaria.repositorios.MascotaRepository;

@SpringBootApplication

public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

	public void ejemplo(MascotaRepository mascotaRepository) {

		// Ejmplo
		var tomy = new Mascota();
		tomy.setOwner("Arthur");
		tomy.setName("Tomy");

		mascotaRepository.save(tomy);

		var pipo = new Mascota();
		tomy.setOwner("Arthur");
		tomy.setName("Pipo");

		mascotaRepository.save(pipo);

	}

}
