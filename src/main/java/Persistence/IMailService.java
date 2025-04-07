package Persistence;

public interface IMailService {
    public void enviarCorreo(String destinatario, String asunto, String mensaje);
}