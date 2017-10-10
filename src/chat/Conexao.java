package chat;

public class Conexao {
    String ip, nick;
    int portaChat;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPortaChat() {
        return portaChat;
    }

    public void setPortaChat(int portaChat) {
        this.portaChat = portaChat;
    }
    
    public void setPortaChat(String portaChat) {
        this.portaChat = Integer.parseInt(portaChat);
    }

    
    Conexao(String ip, String nick) {
        this.ip = ip;
        this.nick = nick;
    }
     Conexao(String ip, String nick, int porta) {
        this.ip = ip;
        this.nick = nick;
        this.portaChat = porta;
    }
     
     @Override
    public String toString(){
        return this.nick+"->"+this.ip+":"+this.portaChat;
    }
    
}
