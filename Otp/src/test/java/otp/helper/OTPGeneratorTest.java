package otp.helper;

import com.ebc.otp.helper.OTPGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OTPGeneratorTest {

    @Test
    public void generateSimpleOtp() {
        String otp = OTPGenerator.GENERATE_SIMPLE_OTP(4);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 4);
        String otp2 = OTPGenerator.GENERATE_SIMPLE_OTP(4);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);

        otp = OTPGenerator.GENERATE_SIMPLE_OTP(6);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 6);
        otp2 = OTPGenerator.GENERATE_SIMPLE_OTP(6);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);

        otp = OTPGenerator.GENERATE_SIMPLE_OTP(8);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 8);
        otp2 = OTPGenerator.GENERATE_SIMPLE_OTP(8);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);

    }

    @Test
    public void generateComplexOtp() {
        String otp = OTPGenerator.GENERATE_COMPLEX_OTP(4);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 4);
        String otp2 = OTPGenerator.GENERATE_COMPLEX_OTP(4);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);

        otp = OTPGenerator.GENERATE_COMPLEX_OTP(6);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 6);
        otp2 = OTPGenerator.GENERATE_COMPLEX_OTP(6);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);

        otp = OTPGenerator.GENERATE_COMPLEX_OTP(20);
        Assert.assertNotNull(otp);
        Assert.assertEquals(otp.length(), 20);
        otp2 = OTPGenerator.GENERATE_COMPLEX_OTP(20);
        Assert.assertNotNull(otp2);
        Assert.assertNotEquals(otp, otp2);
    }
}
