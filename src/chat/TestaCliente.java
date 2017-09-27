package chat;

import java.io.IOException;

public class TestaCliente {
     public static void main(String[] args) throws IOException {
         Cliente cl1 = new Cliente("127.0.0.1",2000,"Ederson");
         cl1.start();
         
     }
    
}
