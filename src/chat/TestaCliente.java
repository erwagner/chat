package chat;

import java.io.IOException;

public class TestaCliente {

    public static void main(String[] args) throws IOException {
        Cliente cl1 = new Cliente("127.0.0.1", 2000, "Ederson");
        Cliente cl2 = new Cliente("127.0.0.1", 2000, "Maria");
        Cliente cl3 = new Cliente("127.0.0.1", 2000, "Juliana");

        cl3.start();
        cl2.start();
        cl1.start();
        /*
        int N = 100;
        Cliente clientes[] = new Cliente[N];
        
        for(int i=0;i<N;i++)
            clientes[i] = new Cliente("127.0.0.1", 2000, "Usuario:\t"+(i+1)+"\t");
        
        for(int i=0;i<N;i++)
            clientes[i].start();
*/
    }

}
