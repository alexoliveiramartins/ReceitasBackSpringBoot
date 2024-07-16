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
    public ArrayList<Receita> receitas( @RequestParam(required = false) String ingredientes) {
        if(ingredientes == null){
            return receitaService.getReceitas();
        }
        else {
            return receitaService.getReceitasByIngredients(ingredientes);
        }
    }

    @GetMapping("/receitas/pais")
    public ArrayList<Receita> receitasPorPais(@RequestParam(required = true) String pais){
        return receitaService.getReceitasByCountry(pais);
    }

    @GetMapping("/receitas/{nome}")
    public Receita receitasPorNome(@PathVariable String nome){
        return receitaService.getReceitasByNome(nome);
    }
}