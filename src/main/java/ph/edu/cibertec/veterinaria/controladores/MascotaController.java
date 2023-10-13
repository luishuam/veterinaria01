package ph.edu.cibertec.veterinaria.controladores;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ph.edu.cibertec.veterinaria.entidades.Mascota;
import ph.edu.cibertec.veterinaria.repositorios.MascotaRepository;

//crear rest
@RestController
@AllArgsConstructor
public class MascotaController {

    MascotaRepository mascotaRepository; // if I need that it works, DEPENDENCY

    /* allargsconstructor */
    // MascotaController(MascotaRepository mascotaRepository) {
    // this.mascotaRepository = mascotaRepository;
    // };

    @RequestMapping(method = RequestMethod.GET, path = "obtenerMascotas")

    public List<Mascota> listarMascotas() {

        return mascotaRepository.findAll();
        // Mascota tomy = new Mascota();
        // tomy.setName("Panchito");
        // tomy.setOwner("Arthuro Mendiola");

        // Mascota lupita = new Mascota();
        // lupita.setName("Lupita");
        // lupita.setOwner("Panchita");

        // return Arrays.asList(tomy, lupita);
    }

    @GetMapping("obtenerMascotitas")
    public List<Mascota> listarMascotitas() {
        return mascotaRepository.findAll();
    }
}
