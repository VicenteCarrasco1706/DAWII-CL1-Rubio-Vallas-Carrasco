package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Especialidad;
@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
