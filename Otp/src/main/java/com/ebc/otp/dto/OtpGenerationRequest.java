package com.ebc.otp.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OtpGenerationRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String notificationType;
    @NotBlank
    private String userType;
}
