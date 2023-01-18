package com.ebc.otp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SMSResponseDTO {

    private boolean isSent;

}
