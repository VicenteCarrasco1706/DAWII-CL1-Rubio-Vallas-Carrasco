package pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.model.bd.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Integer> {
}
