package chat;

import java.io.IOException;

public class TestaServidor {
        public static void main(String[] args) throws IOException {

            ConexoesAtivas conexoes = new ConexoesAtivas();
        
            Servidor principal = new Servidor(2000, conexoes);
            
            ThreadGerenciadorDeConexoes gerenciador;
            gerenciador = new ThreadGerenciadorDeConexoes(conexoes);
        

            principal.start();
            gerenciador.start();
        
    }
    
}
