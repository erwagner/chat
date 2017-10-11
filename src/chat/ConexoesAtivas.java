package chat;

import java.util.ArrayList;

public class ConexoesAtivas {
    
    ArrayList<Conexao> conexoesEnvio = new ArrayList<>();
    ArrayList<Conexao> conexoesRecebimento = new ArrayList<>();
    
    public void adicionarConexaoEnvio(Conexao temp){
        conexoesEnvio.add(temp);
    }

    public void adicionarConexaoRecebimento(Conexao temp){
        conexoesRecebimento.add(temp);
    }


    
    @Override
    public String toString(){
        String saida = "Conexões de Envio:\n";
        for(int i=0; i<conexoesEnvio.size();i++)
            saida+=conexoesEnvio.get(i).toString()+"\n";
        
        saida+= "\nConexões de Recebimento:\n";
        
        for(int i=0; i<conexoesRecebimento.size();i++)
            saida+=conexoesRecebimento.get(i).toString()+"\n";

        
        return saida;
    }
    
    
}
