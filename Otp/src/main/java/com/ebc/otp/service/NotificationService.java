package com.ebc.otp.service;

import com.ebc.otp.helper.NotificationTypeEnum;
import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.helper.SmsServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final EmailService emailService;

    private final SmsServiceClient smsServiceClient;

    public OTPEnum notifyUser(final String username, final String otp, final String type) {
        OTPEnum response = null;
        if (NotificationTypeEnum.EMAIL.getValue().equals(type)) {
            response = emailService.sendEmail(username, otp);
        } else if (NotificationTypeEnum.SMS.getValue().equals(type)) {
            // call sms service
            response = smsServiceClient.sendSMS(username, otp);
        }
        return response;
    }
}
