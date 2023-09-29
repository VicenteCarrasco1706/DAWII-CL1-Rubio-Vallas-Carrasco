package pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.model.bd.Mascota;
import pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.repository.MascotaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MascotaService {
    private MascotaRepository mascotaRepository;
    public List<Mascota> listarMascotas(){

        return mascotaRepository.findAll();
    }
    
}
