package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {

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

            //System.out.println(this.conexao.getNick()+": O Servidor pediu para fazer a nova conexão na porta: \t"+this.conexao.getPortaChat());
            entrada.close();
            saida.close();
            clienteNegociacao.close();

            System.out.println("Estabelecendo conexão de ENVIO na porta: " + this.conexao.getPortaChat());
            Socket clienteChat = new Socket(this.conexao.getIp(), this.conexao.getPortaChat());
            saida = new PrintStream(clienteChat.getOutputStream());
            
            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }


        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
