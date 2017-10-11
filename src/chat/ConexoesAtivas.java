package chat;

import java.util.ArrayList;

public class ConexoesAtivas {
    
    ArrayList<Conexao> conexoesEnvio = new ArrayList<>();
    ArrayList<Conexao> conexoesRecebimento = new ArrayList<>();
    

    public void adicionarConexaoRecebimento(Conexao temp){
        conexoesRecebimento.add(temp);
        //gerar aqui a thread que irá receber as mensagens baseada na conexão
        ThreadRecebimento tr = new ThreadRecebimento(temp);
        tr.start();
    }



    public void adicionarConexaoEnvio(Conexao temp){
        conexoesEnvio.add(temp);
    }




    
    @Override
    public String toString(){
        String saida = "Conexões de Recebimento:\n";

        for(int i=0; i<conexoesRecebimento.size();i++)
            saida+=conexoesRecebimento.get(i).toString()+"\n";
        
        saida+= "\nConexões de Envio:\n";
        for(int i=0; i<conexoesEnvio.size();i++)
            saida+=conexoesEnvio.get(i).toString()+"\n";
        

        
        return saida;
    }
    
    
}
