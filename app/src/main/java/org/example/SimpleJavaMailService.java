package app.src.main.java.org.example;

import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.*;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import java.util.Arrays;

public class SimpleJavaMailService implements app.src.main.java.org.example.IMailService {
    public void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Email email = EmailBuilder.startingBlank()
                .from(from)
                .toMultiple(to)
                .withSubject(subject)
                .withPlainText(body)
                .buildEmail();

        Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com",587,from,pass)
                        .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer();

        // Send the email
        try {
            mailer.sendMail(email);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
