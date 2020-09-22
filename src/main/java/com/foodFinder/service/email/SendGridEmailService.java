package com.foodFinder.service.email;


import com.foodFinder.config.ConfigurationClass;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class SendGridEmailService implements EmailService{

    @Autowired
    private SendGrid sendGrid;


   /* @Autowired
    public SendGridEmailService(SendGrid sendGrid){
        this.sendGrid=sendGrid;
    }
    public SendGridEmailService(){}*/

    @Override
    public void sendText(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/plain", body));
        System.out.println("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    @Override
    public void sendHTML(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/html", body));
        System.out.println("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }

    private Response sendEmail(String from, String to, String subject, Content content) throws IOException {
        Mail mail = new Mail(new Email(from), subject, new Email(to),content);
        mail.setReplyTo(new Email("patrycja.guz1986@gmail.com"));
        Request request = new Request();
        Response response= new Response();


        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response=this.sendGrid.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
