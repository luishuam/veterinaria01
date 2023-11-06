package ph.edu.cibertec.veterinaria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.edu.cibertec.veterinaria.entidades.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}
