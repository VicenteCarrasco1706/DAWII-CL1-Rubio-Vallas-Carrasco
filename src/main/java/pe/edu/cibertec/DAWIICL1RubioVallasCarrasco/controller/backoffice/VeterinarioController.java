package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Veterinario;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request.VeterinarioRequest;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service.VeterinarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {

    private VeterinarioService veterinarioService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaVeterinario",
                veterinarioService.listarVeterinarios());
        return "backoffice/veterinario/frmMantVeterinario";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Veterinario> listarVeterinarios(){
        return veterinarioService.listarVeterinarios();
    }



    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarVeterinario(
            @RequestBody VeterinarioRequest veterinarioRequest
    ){
        return veterinarioService.guardarVeterinario(veterinarioRequest);
    }


}
