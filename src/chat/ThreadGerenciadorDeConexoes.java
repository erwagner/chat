package chat;

import java.util.ArrayList;

public class ThreadGerenciadorDeConexoes extends Thread {

   ConexoesAtivas conexoes;

    public ThreadGerenciadorDeConexoes(ConexoesAtivas c) {
        this.conexoes = c;
        System.out.println("Gerenciador de Mensagens Ativo !");
    }

    @Override
    public void run() {
        while (true) {
            //verificar se tem uma nova mensagem
            for (int i = 0; i < conexoes.conexoesRecebimento.size(); i++) {
               if(i>0)
                    System.out.println("sadf");
                if (conexoes.conexoesRecebimento.get(i).mensagemNova) {
                    System.out.println("mensagem nova");
                    System.out.println(conexoes.conexoesRecebimento.get(i).getMensagem());
                    conexoes.conexoesRecebimento.get(i).setMensagemNova(false);
                }
            }
            //saida+=conexoesEnvio.get(i).toString()+"\n";
            //se tiver, exibir
            //E
            //enviar a todas conexoes ativas
        }

    }

}
