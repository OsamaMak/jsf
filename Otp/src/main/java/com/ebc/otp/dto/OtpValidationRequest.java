package com.ebc.otp.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OtpValidationRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String otpNumber;
    @NotBlank
    private String userType;
}
