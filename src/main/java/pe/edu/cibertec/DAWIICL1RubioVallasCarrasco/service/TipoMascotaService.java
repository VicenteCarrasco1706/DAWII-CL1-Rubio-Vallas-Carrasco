package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.TipoMascota;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.TipoMascotaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoMascotaService {
    private TipoMascotaRepository tipoMascotaRepository;

    public List<TipoMascota> listarTipoMascotas(){
        return tipoMascotaRepository.findAll();
    }
}
