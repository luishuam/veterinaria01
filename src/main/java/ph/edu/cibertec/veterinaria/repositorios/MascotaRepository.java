package ph.edu.cibertec.veterinaria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.edu.cibertec.veterinaria.entidades.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // listar mascotas por nombre, no completo
    @Query("select m from Mascota as m where nombre like concat('%', :nombre, '%')") // jpa
    java.util.List<Mascota> buscarMascotaPorNombre(String nombre);

    // Nombre exacto
    java.util.List<Mascota> searchByNombre(String nombre);
}
