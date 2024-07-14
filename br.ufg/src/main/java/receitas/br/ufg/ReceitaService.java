package receitas.br.ufg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ArrayList<Receita> getReceitasByIngredients(ArrayList<String> ingredientes) {
        ArrayList<Receita> sameIngredients = new ArrayList<>();

        for (Receita r : receitas) {
            int count = 0;
            ArrayList<Ingrediente> receitaIngredientes = r.getIngredientes();
            for (Ingrediente i : receitaIngredientes) {
                if (ingredientes.contains(i.getNome())) {
                    count++;
                }
            }
            if (count == ingredientes.size()) {
                sameIngredients.add(r);
            }
        }
        return sameIngredients;
    }
}