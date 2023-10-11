package ph.edu.cibertec.veterinaria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.edu.cibertec.veterinaria.entidades.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
