package chat;

import java.io.IOException;
import java.io.PrintStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    ServerSocket principal;
    int porta;

    public Servidor(int porta) throws IOException {
        this.porta = porta;
        principal = new ServerSocket(porta);
    }


    @Override
    public void run() {
        System.out.println("Servidor Principal Ativo !");
        while (true) {

            Socket novoCliente = null;
            try {
                novoCliente = principal.accept();

                System.out.println("Nova conexão com o cliente "
                        + novoCliente.getInetAddress().getHostAddress());

                PrintStream saida = new PrintStream(novoCliente.getOutputStream());

                Scanner entrada = new Scanner(novoCliente.getInputStream());


                System.out.println("O cliente digitou: " + entrada.nextLine());
                    saida.println("2001");
                

                entrada.close();
                saida.close();

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
