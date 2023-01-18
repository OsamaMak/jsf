package com.ebc.otp.service;

import com.ebc.otp.exception.GenericException;
import com.ebc.otp.helper.OTPEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.ebc.otp.helper.TemplateContentLoader.GET_TEMPLATE;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    // Method 1
    // To send a simple email

    public OTPEnum sendEmail(final String username, final String otp) {

        // Try block to check for exceptions
        try {
            logger.info("start to send OTP by mail");
//            String mailTemplate = loadTemplate();
            logger.info("mail template loaded successfully");

            String mailBody = GET_TEMPLATE(otp);
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(username);
            mailMessage.setText(mailBody);
            mailMessage.setSubject("Instapay");

            // Sending the mail
            javaMailSender.send(mailMessage);
            logger.info("mail sent successfully");
            return OTPEnum.SUCCESS;
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            throw new GenericException(e.getMessage(),e.getCause(),true,true);
        }
    }


}
	
