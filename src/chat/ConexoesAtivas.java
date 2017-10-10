package chat;

import java.util.ArrayList;

public class ConexoesAtivas {
    
    ArrayList<Conexao> conexoes = new ArrayList<>();
    
    public void adicionarConexao(Conexao temp){
        conexoes.add(temp);
    }
    
    @Override
    public String toString(){
        String saida = "";
        for(int i=0; i<conexoes.size();i++)
            saida+=conexoes.get(i).toString()+"\n";
        
        return saida;
    }
    
    
}
