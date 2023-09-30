package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Especialidad;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.EspecialidadRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecialidadService {

    private EspecialidadRepository espacialidadRepository;

    public List<Especialidad> listarEspecialidades(){
        return espacialidadRepository.findAll();
    }
}
