package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.TipoMascota;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service.TipoMascotaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tipomascota")
public class TipoMascotaController {
    private TipoMascotaService tipoMascotaService;
    @GetMapping("/listar")
    @ResponseBody
    public List<TipoMascota> listarTipoMascotas(){
        return tipoMascotaService.listarTipoMascotas();
    }
}
