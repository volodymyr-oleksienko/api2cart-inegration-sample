package Email;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public EmailSender() throws AddressException {
        final String to = "vovazip2@gmail.com";
        final String too_password = "tlckcuaoxfmrylsm";

        final String from = "vova_zip@i.ua";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(to, too_password);
                    }
                }
        );
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(to));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(from));

            message.setSubject("From test");
            String msg = "<div style=\"color:red;\">BRIDGEYE</div>";
            message.setContent(msg, "text/html; charset=utf-8");
            System.out.println("Start sending an email");
            Transport.send(message);

            System.out.println("Message was sent");
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}

