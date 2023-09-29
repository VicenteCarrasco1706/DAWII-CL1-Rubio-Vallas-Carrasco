package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Servicio;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.ServicioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioService {

    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios(){

        return servicioRepository.findAll();
    }
}
