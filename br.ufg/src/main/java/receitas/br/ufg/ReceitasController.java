package receitas.br.ufg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ReceitasController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/receitas")
    public ArrayList<Receita> a(){
        return receitaService.getReceitas();
    }
}