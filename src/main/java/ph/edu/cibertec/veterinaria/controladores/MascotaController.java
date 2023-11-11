package ph.edu.cibertec.veterinaria.controladores;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ph.edu.cibertec.veterinaria.entidades.Mascota;
import ph.edu.cibertec.veterinaria.entidades.MascotaDto;
import ph.edu.cibertec.veterinaria.entidades.MascotaRequest;
import ph.edu.cibertec.veterinaria.repositorios.MascotaRepository;

//crear rest
@RestController
@AllArgsConstructor
@RequestMapping("mascotas")
public class MascotaController {

    MascotaRepository mascotaRepository;

    // public MascotaController(MascotaRepository mascotaRepository) {
    // this.mascotaRepository = mascotaRepository;
    // // o usar ^^ @AllArgsConstructor
    // // Evitar usar autowired
    // }

    /* allargsconstructor */
    // MascotaController(MascotaRepository mascotaRepository) {
    // this.mascotaRepository = mascotaRepository;
    // };

    // @RequestMapping(method = RequestMethod.GET, path = "mascotas")
    // public List<Mascota> listarMascotas() {

    // return mascotaRepository.findAll();
    // // Mascota tomy = new Mascota();
    // // tomy.setName("Panchito");
    // // tomy.setOwner("Arthuro Mendiola");

    // // Mascota lupita = new Mascota();
    // // lupita.setName("Lupita");
    // // lupita.setOwner("Panchita");

    // // return Arrays.asList(tomy, lupita);
    // }

    /*------------------Listar, por nombre %, exact name-------------------------- */
    @GetMapping
    public List<Mascota> findAll(String nombre) {

        if (nombre != null) {
            return mascotaRepository.buscarMascotaPorNombre(nombre);
        }

        return mascotaRepository.findAll();
    }

    // @GetMapping
    // public List<Mascota> findExactByNombre(String nombre) {

    // if (nombre != null) {
    // return mascotaRepository.searchByNombre(nombre);
    // }

    // return mascotaRepository.findAll();
    // }

    // @GetMapping
    // public List<Mascota> listar( ) {

    // return mascotaRepository.findAll();
    // }

    // dto

    @GetMapping("/dto")
    public List<MascotaDto> listar() {

        return mascotaRepository.findAll().stream().map(mascota -> {
            MascotaDto dto = new MascotaDto();
            dto.nombre = mascota.getNombre();
            dto.estado = mascota.getEstaEliminado();

            return dto;

        }).toList();
    }

    /*------------------Listar, por id-------------------------- */
    @GetMapping("{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {

        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        // if (mascotaOptional.isPresent()) {
        // Mascota mascota = mascotaOptional.get();
        // return ResponseEntity.ok(mascota);
        // // 200 ok

        // }
        // return ResponseEntity.notFound().build();
        // // not found 404
        // ^^ codigo de igual funcionamiento

        return ResponseEntity.of(mascotaRepository.findById(id));
    }

    // registro de mascota, uso de post
    // request body para obtner datos
    // primera manera
    // @PostMapping("mascotas")
    // public ResponseEntity<Long> registrar(@RequestBody MascotaRequest
    // mascotaRequest) {
    // Mascota mascota = new Mascota();
    // mascota.nombre = mascotaRequest.nombre;
    // mascota.duenho = mascotaRequest.duenho;

    // Mascota mascotaGuardada = mascotaRepository.save(mascota);
    // return ResponseEntity.status(201).body(mascotaGuardada.id);

    // }

    /*------------------Registrar-------------------------- */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long registrar(@RequestBody @Valid MascotaRequest mascotaRequest) {
        Mascota mascota = new Mascota();
        mascota.nombre = mascotaRequest.nombre;
        mascota.duenho = mascotaRequest.duenho;

        Mascota mascotaGuardada = mascotaRepository.save(mascota);
        return mascotaGuardada.id;

    }

    /*--------------- Eliminar por id ------------------------*/
    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable Long id) {
        mascotaRepository.deleteById(id);
        // hard delete
    }

    /* -----------------------Actualizar por id ------------------------- */
    @PutMapping("{id}")
    public ResponseEntity<Mascota> modificar(@PathVariable Long id, @RequestBody @Valid MascotaRequest mascotaRequest) {

        // Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);

        // if (mascotaOptional.isPresent()) {
        // Mascota mascota = mascotaOptional.get();
        // mascota.nombre = mascotaRequest.nombre;
        // mascota.duenho = mascotaRequest.duenho;
        // mascotaRepository.save(mascota);

        // return ResponseEntity.ok(mascota);
        // }
        // return ResponseEntity.notFound().build();

        return mascotaRepository.findById(id).map(mascota -> {
            mascota.nombre = mascotaRequest.nombre;
            mascota.duenho = mascotaRequest.duenho;
            mascotaRepository.save(mascota);

            return ResponseEntity.ok(mascota);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*--------------------- Patch/parcial no usable/ por id-----------------*/
    @PatchMapping("{id}")
    public ResponseEntity<Mascota> modificarParcial(@PathVariable Long id,
            @RequestBody MascotaRequest mascotaRequest) {

        return mascotaRepository.findById(id).map(mascota -> {

            if (mascotaRequest.nombre != null) {
                mascota.nombre = mascotaRequest.nombre;
            }
            if (mascotaRequest.duenho != null) {
                mascota.duenho = mascotaRequest.duenho;
            }

            mascotaRepository.save(mascota);

            return ResponseEntity.ok(mascota);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
