package receitas.br.ufg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}