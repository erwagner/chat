package chat;

import java.io.IOException;

public class TestaServidor {
        public static void main(String[] args) throws IOException {

            
        
            Servidor principal = new Servidor(2000);

            principal.start();
        
    }
    
}
