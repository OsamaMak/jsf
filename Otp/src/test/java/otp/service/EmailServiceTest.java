package otp.service;

import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.service.EmailService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Before
    public void setup() {
        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));

    }

    @Test
    public void sendEmail() {

        OTPEnum status = emailService.sendEmail("osama.makram@gmail.com", "1234");
        Assert.assertNotNull(status);
        Assert.assertEquals(status, OTPEnum.SUCCESS);
    }
}
