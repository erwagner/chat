package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecebimento extends Thread {

    Conexao conexao;

    public ThreadRecebimento(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public void run() {

        System.out.println("Abrindo conexão de RECEBIMENTO na porta " + this.conexao.getPortaChat());
        while (true) {

            ServerSocket serverConexaoRecebimento = null;
            Socket novoCliente = null;
            try {

                serverConexaoRecebimento = new ServerSocket(this.conexao.getPortaChat());;

                novoCliente = serverConexaoRecebimento.accept();

                
                Scanner entrada = new Scanner(novoCliente.getInputStream());

                while (entrada.hasNextLine()) {
                    String mensagem = entrada.nextLine();
                    this.conexao.setMensagem(mensagem);
                    this.conexao.setMensagemNova(true);
                    //System.out.println(this.conexao.getNick()+" digitou: "+mensagem);
                }

                entrada.close();
                

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
