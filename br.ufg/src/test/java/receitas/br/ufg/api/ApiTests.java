package receitas.br.ufg.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import receitas.br.ufg.Ingrediente;
import receitas.br.ufg.Receita;
import receitas.br.ufg.ReceitaService;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceitaService receitaService;

    @Test
    void testReceitasIngredientes() throws Exception {
        ArrayList<Receita> receitas = new ArrayList<>();
        Receita receita = new Receita();
        receita.setNome("Bolo de Chocolate");

        ArrayList<Ingrediente> ingredientesArray = new ArrayList<>();
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setNome("chocolate");
        ingrediente1.setQuantidade("200g");

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNome("farinha");
        ingrediente2.setQuantidade("300g");

        ingredientesArray.add(ingrediente1);
        ingredientesArray.add(ingrediente2);

        receita.setIngredientes(ingredientesArray);
        receitas.add(receita);

        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add("chocolate");
        ingredientes.add("farinha");

        when(receitaService.getReceitasByIngredients(ingredientes)).thenReturn(receitas);

        mockMvc.perform(get("/api/receitas")
                        .param("ingredientes", "chocolate")
                        .param("ingredientes", "farinha"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'nome':'Bolo de Chocolate', 'ingredientes':[{'nome':'chocolate', 'quantidade':'200g'}, {'nome':'farinha', 'quantidade':'300g'}]}]"));
    }
}
