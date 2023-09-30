package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Estado;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Mascota;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.TipoMascota;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request.MascotaRequest;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.MascotaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MascotaService {
    private MascotaRepository mascotaRepository;
    public List<Mascota> listarMascotas(){

        return mascotaRepository.findAll();
    }

    public ResultadoResponse guardarMascota(MascotaRequest mascota){
        String mensaje = "Mascota registrada correctamente";
        Boolean respuesta = true;
        try {
            Mascota objMascota = new Mascota();
            if(mascota.getIdmascota() > 0){
                objMascota.setIdmascota(mascota.getIdmascota());
            }
            objMascota.setNombre(mascota.getNombre());
            objMascota.setFechanacimiento(mascota.getFechanacimiento());
            objMascota.setNombrepropietario(mascota.getNombrepropietario());

            TipoMascota tipoMascota = new TipoMascota();
            tipoMascota.setIdtipomascota(mascota.getIdtipomascota());

            objMascota.setRaza(mascota.getRaza());

            Estado estado = new Estado();
            estado.setIdestado(mascota.getIdestado());


            objMascota.setTipomascota(tipoMascota);
            objMascota.setEstado(estado);
            mascotaRepository.save(objMascota);
        }catch (Exception ex){
            mensaje = "Mascota no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
