package receitas.br.ufg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ReceitasController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/receitas")
    public ArrayList<Receita> receitas(@RequestParam(required = false) String pais) {
        if (pais != null) {
            return receitaService.getReceitasByCountry(pais);
        } else {
            return receitaService.getReceitas();
        }
    }

}