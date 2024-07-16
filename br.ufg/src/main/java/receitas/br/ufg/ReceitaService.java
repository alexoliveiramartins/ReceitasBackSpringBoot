package receitas.br.ufg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class ReceitaService {
    private ArrayList<Receita> receitas;

    public ReceitaService() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            receitas = objectMapper.readValue(new File("br.ufg/src/main/resources/receitas.json"), new TypeReference<ArrayList<Receita>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Receita> getReceitas() {
        return receitas;
    }

    public ArrayList<Receita> getReceitasByCountry(String pais){
        ArrayList<Receita> receitasPais = new ArrayList<Receita>();

        for(Receita a : receitas){
            if(a.getOrigem().equals(pais)){
                receitasPais.add(a);
            }
        }
        return receitasPais;
    }

    public Receita getReceitasByNome(String nome){
        for (Receita receita : receitas) {
            if (receita.getNome().equalsIgnoreCase(nome)) {
                return receita;
            }
        }
        return receitas.get(1);
     }

    public ArrayList<Receita> getReceitasByIngredients(String ingredientes) {
        ArrayList<Receita> sameIngredients = new ArrayList<>();
        String[] ingredientesInput = ingredientes.split(",");
        ArrayList<String> listaIngredientes = new ArrayList<>(Arrays.asList(ingredientesInput));

        for (Receita r : receitas) {
            int count = 0;
            int ingredientesCount = 0;
            ArrayList<Ingrediente> receitaIngredientes = r.getIngredientes();
            for (Ingrediente i : receitaIngredientes) {
                if (listaIngredientes.contains(i.getNome())) {
                    count++;
                }
                ingredientesCount++;
            }
            if (count == listaIngredientes.size() && count == ingredientesCount) {
                sameIngredients.add(r);
            }
        }
        return sameIngredients;
    }
}