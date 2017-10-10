package chat;

import java.io.IOException;

public class TestaServidor {
        public static void main(String[] args) throws IOException {

            ConexoesAtivas conexoes = new ConexoesAtivas();
        
            Servidor principal = new Servidor(2000, conexoes);

            principal.start();
        
    }
    
}
