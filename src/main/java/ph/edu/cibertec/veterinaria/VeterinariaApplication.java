package ph.edu.cibertec.veterinaria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ph.edu.cibertec.veterinaria.entidades.Mascota;
import ph.edu.cibertec.veterinaria.repositorios.MascotaRepository;

@SpringBootApplication

public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}
	/*
	 * // clase objeto que es gestionado por Spring
	 * 
	 * @Bean
	 * // auto execute commanlinerunner
	 * public CommandLineRunner ejemplo(MascotaRepository mascotaRepository) {
	 * 
	 * /*
	 * return new CommandLineRunner() {
	 * 
	 * @Override
	 * public void run(String... args) throws Exception {
	 * // Ejmplo
	 * var tomy = new Mascota();
	 * tomy.setOwner("Arthur");
	 * tomy.setName("Tomy");
	 * 
	 * mascotaRepository.save(tomy);
	 * 
	 * var pipo = new Mascota();
	 * tomy.setOwner("Arthur");
	 * tomy.setName("Pipo");
	 * 
	 * mascotaRepository.save(pipo);
	 * }
	 * };
	 */

	/*
	 * return (args) ->
	 * 
	 * {
	 * // Ejmplo
	 * var tomy = new Mascota();
	 * tomy.setOwner("Arthur");
	 * tomy.setName("Tomy");
	 * 
	 * mascotaRepository.save(tomy);
	 * 
	 * var pipo = new Mascota();
	 * tomy.setOwner("Arthur");
	 * tomy.setName("Pipo");
	 * 
	 * mascotaRepository.save(pipo);
	 * };
	 */
}
