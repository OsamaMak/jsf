package com.ebc.otp.dto;

import com.ebc.otp.helper.Language;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SMSRequestDTO {

    private Language language;
    private String subject;
    private String message;
    private String mobileNumber;
    private String reference;
    private String bank;
    private String system;

}
