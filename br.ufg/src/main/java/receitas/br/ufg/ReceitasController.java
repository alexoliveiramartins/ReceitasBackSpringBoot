package receitas.br.ufg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceitasController {

    @GetMapping("/receitas")
    public String a(){
        return "a";
    }

}