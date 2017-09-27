package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    
//    String ip, nick;
//    int portaNegociacao, portaChat;
    int portaNegociacao;
    Conexao conexao;

    public Cliente(String ip, int portaNegociacao, String nick) {
        conexao = new Conexao(ip, nick);
        this.portaNegociacao = portaNegociacao;

    }
    
       
    
    @Override
    public void run() {
        try {
            //Negociação
            
            Socket clienteNegociacao = new Socket(this.conexao.getIp(), this.portaNegociacao);
            System.out.println("Negociando com servidor...");
            
            PrintStream saida = new PrintStream(clienteNegociacao.getOutputStream());
            Scanner entrada = new Scanner(clienteNegociacao.getInputStream());
            
            saida.println(this.conexao.getNick());
            
            this.conexao.setPortaChat(entrada.nextLine());
            
            System.out.println(this.conexao.getNick()+": O Servidor pediu para fazer a nova conexão na porta: \t"+this.conexao.getPortaChat());
            
            entrada.close();
            saida.close();
            
            //Inicializacao das novas threads
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
/* ////////////////Socket cliente = new Socket("127.0.0.1", 2000);
     ////////////////////////////System.out.println("O cliente se conectou ao servidor!");
     
     Scanner teclado = new Scanner(System.in);
     ///////////////////////PrintStream saida = new PrintStream(cliente.getOutputStream());
     
    //////////////////////////// Scanner entrada = new Scanner(cliente.getInputStream());
     
     while (teclado.hasNextLine()) {
       saida.println(teclado.nextLine());
       System.out.println("O SE4RVIDOR digitou: " + entrada.nextLine());
     }
     
     saida.close();
     teclado.close();*/