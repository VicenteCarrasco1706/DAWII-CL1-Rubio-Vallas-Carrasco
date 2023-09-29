package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Mascota;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service.MascotaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/mascota")
public class MascotaController {
    private MascotaService mascotaService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaMascotas",
                mascotaService.listarMascotas());
        return "backoffice/mascota/frmMantMascota";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Mascota> listarMascotas(){
        return mascotaService.listarMascotas();
    }



}
