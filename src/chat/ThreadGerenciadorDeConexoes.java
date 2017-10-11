package chat;

import java.util.ArrayList;

public class ThreadGerenciadorDeConexoes extends Thread {

    ArrayList<Conexao> conexoesEnvio = new ArrayList<>();
    ArrayList<Conexao> conexoesRecebimento = new ArrayList<>();

    public ThreadGerenciadorDeConexoes(ArrayList<Conexao> envio, ArrayList<Conexao> recebimento) {
        this.conexoesEnvio = envio;
        this.conexoesRecebimento = recebimento;
    }

    @Override
    public void run() {
        //verificar se tem uma nova mensagem
        for (int i = 0; i < conexoesRecebimento.size(); i++) {
            if (conexoesRecebimento.get(i).isMensagemNova()) {
                System.out.println(conexoesRecebimento.get(i).getMensagem());
                conexoesRecebimento.get(i).setMensagemNova(false);
            }
        }
        //saida+=conexoesEnvio.get(i).toString()+"\n";
        //se tiver, exibir
        //E
        //enviar a todas conexoes ativas

    }

}
