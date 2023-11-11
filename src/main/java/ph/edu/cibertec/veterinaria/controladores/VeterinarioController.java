package ph.edu.cibertec.veterinaria.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ph.edu.cibertec.veterinaria.entidades.Especialidad;
import ph.edu.cibertec.veterinaria.entidades.Veterinario;
import ph.edu.cibertec.veterinaria.entidades.VeterinarioDto;
import ph.edu.cibertec.veterinaria.entidades.VeterinarioRequest;
import ph.edu.cibertec.veterinaria.repositorios.VeterinarioRepository;

@RestController
@RequestMapping("veterinarios")
@AllArgsConstructor
public class VeterinarioController {

    // Invocar obj desde repository
    VeterinarioRepository veterinarioRepository;

    @GetMapping
    public List<Veterinario> findAll() {

        return veterinarioRepository.findAll();
    }

    /* Por dto seleccionar algunos campos */

    @GetMapping("dto")
    public List<VeterinarioDto> listar() {

        return veterinarioRepository.findAll().stream().map(veterinario -> {
            VeterinarioDto dto = new VeterinarioDto();
            dto.nombre = veterinario.getNombre();
            dto.especialidad = veterinario.getEspecialidad().getNombre();

            return dto;

        }).toList();
    }

    /*------------------Listar, por id-------------------------- */
    @GetMapping("{id}")
    public ResponseEntity<Veterinario> findById(@PathVariable Long id) {

        return ResponseEntity.of(veterinarioRepository.findById(id));
    }

    /*------------------Registrar-------------------------- */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long registrar(@RequestBody @Valid VeterinarioRequest veterinarioRequest) {
        Veterinario veterinario = new Veterinario();
        veterinario.nombre = veterinarioRequest.nombre;
        veterinario.carnet = veterinarioRequest.carnet;
        veterinario.dni = veterinarioRequest.dni;
        veterinario.salario = veterinarioRequest.salario;
        veterinario.especialidad.id = veterinarioRequest.especialidad_id2.id;

        Veterinario veterinarioGuardado = veterinarioRepository.save(veterinario);
        return veterinarioGuardado.getId();

    }

    /*--------------- Eliminar por id ------------------------*/
    @DeleteMapping("{id}")
    public void eliminarPorId(@PathVariable Long id) {
        veterinarioRepository.deleteById(id);
        // hard delete
    }

    // /* -----------------------Actualizar por id ------------------------- */
    // @PutMapping("{id}")
    // public ResponseEntity<Veterinario> modificar(@PathVariable Long id,
    // @RequestBody @Valid VeterinarioRequest veterinarioRequest) {

    // return veterinarioRepository.findById(id).map(veterinario -> {

    // return ResponseEntity.ok(veterinario);

    // }).orElseGet(() -> ResponseEntity.notFound().build());
    // }

}
