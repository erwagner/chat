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
    int portaNegociacao;
    int portaAtual;
    

    public Servidor(int porta) throws IOException {
        this.portaNegociacao = porta;
        this.principal = new ServerSocket(porta);
        this.portaAtual = porta + 1;
    }

    @Override
    public void run() {

        System.out.println("Servidor Principal Ativo !");
        while (true) {

            // NEGOCIAÇÃO
            Socket novoCliente = null;
            try {
                novoCliente = principal.accept();
                
                PrintStream saida = new PrintStream(novoCliente.getOutputStream());
                Scanner entrada = new Scanner(novoCliente.getInputStream());

                
                String ip = novoCliente.getInetAddress().getHostAddress();
                String nick = entrada.nextLine();

                Conexao temp = new Conexao(ip,nick,portaAtual);
                
                
               // System.out.println("Nova conexão com o cliente " + novoCliente.getInetAddress().getHostAddress());

               // System.out.println("O cliente digitou: " + entrada.nextLine());
                saida.println(portaAtual);

                System.out.println(nick+" está online no ip "+ip+" e irá conextar na porta "+portaAtual);
                
                portaAtual+=2;
                
                entrada.close();
                saida.close();

                //GERAR UMA NOVA CONEXÃO NA PORTA SOLICITADA
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
