package app.src.main.java.org.example;

public interface IMailService {
    public abstract void sendFromGMail(String from, String pass, String[] to, String subject, String body);
}
