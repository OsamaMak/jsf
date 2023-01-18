package otp.service;

import com.ebc.otp.config.OTPConfigProperties;
import com.ebc.otp.dto.OtpGenerationRequest;
import com.ebc.otp.dto.OtpValidationRequest;
import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.service.OTPService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OTPServiceTest {
    private OTPService otpService;
    @Mock
    private OTPConfigProperties properties;
    private static final String USERNAME = "osama.makram@sas.com";
    private static final String USER_TYPE = "Merchant";

    private OtpGenerationRequest generationRequest;
    private OtpValidationRequest validationRequest;

    @Before
    public void setup() {
        properties = new OTPConfigProperties();
        properties.setSimple(true);
        properties.setLength(6);
        properties.setExpiryInMinutes(1);
        otpService = new OTPService(properties);
        otpService.initializeCache();
        generationRequest = OtpGenerationRequest.builder().username(USERNAME).userType(USER_TYPE).notificationType("Email").build();
        validationRequest = OtpValidationRequest.builder().userType(USER_TYPE).username(USERNAME).build();
    }

    @Test
    public void generateOTP() {
        String otp = otpService.generateOTP(generationRequest);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 6);
        properties.setSimple(false);
        properties.setLength(6);
        String otp2 = otpService.generateOTP(generationRequest);
        Assert.assertNotNull(otp2);
        Assert.assertEquals(otp2.length(), 6);
        Assert.assertNotEquals(otp2, otp);
    }

    @Test
    public void validateOtp() {
        String otp = otpService.generateOTP(generationRequest);
        validationRequest.setOtpNumber(otp);
        OTPEnum status = otpService.validateOtp(validationRequest);
        Assert.assertNotNull(status);
        Assert.assertEquals(OTPEnum.VALID, status);

        status = otpService.validateOtp(validationRequest);
        Assert.assertNotNull(status);
        Assert.assertEquals(OTPEnum.NOT_VALID, status);
        otp = otpService.generateOTP(generationRequest);
        validationRequest.setOtpNumber(otp);
        try {
            Thread.sleep(31 * 2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        status = otpService.validateOtp(validationRequest);
        Assert.assertNotNull(status);
        Assert.assertEquals(OTPEnum.NOT_VALID, status);
    }


}
