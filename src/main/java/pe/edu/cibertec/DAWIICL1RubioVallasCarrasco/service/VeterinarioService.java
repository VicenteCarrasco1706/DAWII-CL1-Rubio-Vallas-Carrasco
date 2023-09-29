package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Especialidad;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Estado;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Veterinario;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request.VeterinarioRequest;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.repository.VeterinarioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class VeterinarioService {

    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> listarVeterinarios(){

        return veterinarioRepository.findAll();
    }


    public ResultadoResponse guardarVeterinario(VeterinarioRequest veterinario){
        String mensaje = "Veterinario registrado correctamente";
        Boolean respuesta = true;
        try {
            Veterinario objVeterinario = new Veterinario();
            if(veterinario.getIdveterinario() > 0){
                objVeterinario.setIdveterinario(veterinario.getIdveterinario());
            }
            objVeterinario.setNombrecompleto(veterinario.getNombrecompleto());
            objVeterinario.setNumerodocumento(veterinario.getNumerodocumento());
            objVeterinario.setCorreo(veterinario.getCorreo());

            Estado estado = new Estado();
            estado.setIdestado(veterinario.getIdestado());

            Especialidad especialidad = new Especialidad();
            especialidad.setIdespecialidad(veterinario.getIdespecialidad());

            objVeterinario.setEstado(estado);
            objVeterinario.setEspecialidad(especialidad);

            veterinarioRepository.save(objVeterinario);

        }catch (Exception ex){
            mensaje = "Veterinario no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
