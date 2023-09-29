package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Estado;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Servicio;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request.ServicioRequest;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.ServicioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioService {

    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios(){

        return servicioRepository.findAll();
    }

    public ResultadoResponse guardarServicio(ServicioRequest servicio){
        String mensaje = "Servicio registrado correctamente";
        Boolean respuesta = true;
        try {
            Servicio oServicio = new Servicio();
            if(servicio.getIdservicio() > 0){
                oServicio.setIdservicio(servicio.getIdservicio());
            }
            oServicio.setDescripcion(servicio.getDescripcion());
            oServicio.setPrecio(servicio.getPrecio());

            Estado estado = new Estado();
            estado.setIdestado(servicio.getIdestado());

            oServicio.setEstado(estado);
            servicioRepository.save(oServicio);
        }catch (Exception ex){
            mensaje = "Servicio no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }



}
