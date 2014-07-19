package org.shm.crawley.web.rest;

import org.shm.crawley.domain.Mail;
import org.shm.crawley.domain.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@Controller
public class SendMailRessource {

    private static final Logger log = Logger.getLogger(SendMailRessource.class.getName());


    @Value("${mail.from:}")
    String mailFrom;

    @Value("${mail.to:}")
    String mailTo;


    @Value("${fmail.cc:}")
    String mailCc;


    /**
     * @param mail
     * @return
     */
    @RequestMapping(value = "/mail",
            method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Result create(@RequestBody Mail mail) {

        Result result = new Result();
        result.setStatus("OK");
        //System.out.println("Post destinataire:" + mail.getDestinataire());
        log.info("Post destinataire:" + mail.getDestinataire());
        log.info("object:" + mail.getSubject());
        log.info("message:" + mail.getMsgBody());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Mail>> constraintViolations = validator.validate(mail);

        if (constraintViolations.isEmpty()) {
            try {
                sendMail(mail);
            } catch (AddressException e) {
                result.setStatus("KO");
                result.setCode(1);
                result.setMesssage(e.getMessage());
                log.severe("An error message.");

            } catch (MessagingException e) {
                result.setStatus("KO");
                result.setCode(2);
                result.setMesssage(e.getMessage());
                log.severe("An error message.");
            } catch (UnsupportedEncodingException e) {
                result.setStatus("KO");
                result.setCode(3);
                result.setMesssage(e.getMessage());
                log.severe("An error message.");
            }
        } else {
            result.setMessages(new ArrayList<String>());
            result.setStatus("KO");
            result.setCode(4);
            for (ConstraintViolation<Mail> constraintViolation : constraintViolations) {
                //System.out.println(constraintViolation.getMessage());
                //TODO save the last one ! not good !
                //FIXME improve structure for message List!
                result.setMesssage(constraintViolation.getMessage());
                result.getMessages().add(constraintViolation.getMessage());
            }

            log.info("Contrainte.");

        }
        return result;
    }

    /**
     * @param mail
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private void sendMail(Mail mail) throws MessagingException, UnsupportedEncodingException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(mailFrom));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        msg.addRecipient(Message.RecipientType.CC, new InternetAddress(mailCc));
        msg.setSubject("Message from :" + mail.getDestinataire());
        msg.setText(mail.getDestinataire() + " \n" + mail.getMsgBody());
        Transport.send(msg);

    }
}
