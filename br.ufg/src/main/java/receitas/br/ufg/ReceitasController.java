package receitas.br.ufg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ReceitasController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/receitas")
    public ArrayList<Receita> receitas(
            @RequestParam(required = false) String pais,
            @RequestParam(required = false) ArrayList<String> ingredientes
    ) {
        if (pais != null) {
            return receitaService.getReceitasByCountry(pais);
        }
        if (ingredientes != null && !ingredientes.isEmpty()) {
            return receitaService.getReceitasByIngredients(ingredientes);
        } else {
            return receitaService.getReceitas();
        }
    }

    @GetMapping("/receitas/{nome}")
    public Receita receitasPorNome(@PathVariable String nome){
        return receitaService.getReceitasByNome(nome);
    }
}