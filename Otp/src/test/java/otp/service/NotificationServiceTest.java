package otp.service;

import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.helper.SmsServiceClient;
import com.ebc.otp.service.EmailService;
import com.ebc.otp.service.NotificationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;
    @Mock
    private EmailService emailService;

    @Mock
    private SmsServiceClient smsServiceClient;

    private static String USERNAME= "OSAMA-MAKRAM";
    private static String OTP= "234567";
    @Before
    public void setup() {
        Mockito.when(emailService.sendEmail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(OTPEnum.SUCCESS);
        Mockito.when(smsServiceClient.sendSMS(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(OTPEnum.SUCCESS);
    }

    @Test
    public void notifyUser() {
        OTPEnum status = notificationService.notifyUser(USERNAME, OTP, "email");
        Assert.assertNotNull(status);
        Assert.assertEquals(status, OTPEnum.SUCCESS);
        status = notificationService.notifyUser(USERNAME, OTP, "sms");
        Assert.assertNotNull(status);
        Assert.assertEquals(status, OTPEnum.SUCCESS);
    }

}
