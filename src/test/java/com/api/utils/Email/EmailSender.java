package com.api.utils.Email;

import java.io.File;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {

    public static void sendEmailWithAttachments(String... filePaths) {
        final String senderEmail = "appemailsender7@gmail.com";
        final String appPassword = "oysatgayianaeevs";
        final String receiverEmail = "contacts.rishabh@gmail.com";

        // SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a new session with an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });

        try {
            // Create a new MimeMessage object
            Message message = new MimeMessage(session);

            // Set from/to/subject
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Test Automation Report & Logs");

            // Multipart for message + attachments
            Multipart multipart = new MimeMultipart();

            // Add text body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find attached the automation report and execution logs.\n\nRegards,\nAutomation Team");
            multipart.addBodyPart(messageBodyPart);

            // Add each file attachment
            for (String filePath : filePaths) {
                File file = new File(filePath);
                if (file.exists()) {
                    MimeBodyPart attachmentPart = new MimeBodyPart();
                    attachmentPart.attachFile(file);
                    multipart.addBodyPart(attachmentPart);
                } else {
                    System.err.println("Attachment not found: " + filePath);
                }
            }

            // Set content
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("✅ Email sent successfully with attachments.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
