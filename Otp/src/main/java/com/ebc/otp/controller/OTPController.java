package com.ebc.otp.controller;

import com.ebc.otp.dto.OtpGenerationRequest;
import com.ebc.otp.dto.OtpValidationRequest;
import com.ebc.otp.dto.ResponseDTO;
import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.service.NotificationService;
import com.ebc.otp.service.OTPService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/otp")
@AllArgsConstructor
public class OTPController {

    public final OTPService otpService;

    public final NotificationService notificationService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * generating OTP
     *
     * @param request Otp Generation Request
     * @return status of the request if the OTP send successfully of not
     */
    @PostMapping(value = "/generate")
    public ResponseDTO generateOtp(@RequestBody @Valid final OtpGenerationRequest request) {
        logger.info("start to generate OTP for username " + request.getUsername());
        String otp = otpService.generateOTP(request);
        logger.info("OTP generated successfully...");
        logger.info("start to notify user");
        OTPEnum res = notificationService.notifyUser(request.getUsername(), otp, request.getNotificationType());
        return ResponseDTO.builder().status(res.toString()).description(res.getValue()).build();
    }

    /**
     * Validating OTP
     *
     * @param request Otp Validation Request
     * @return status of the request if the OTP validated successfully of not
     */
    @PostMapping(value = "/validate")
    public ResponseDTO validateOtp(@RequestBody @Valid final OtpValidationRequest request) {
        logger.info("start to validate OTP");
        OTPEnum res = otpService.validateOtp(request);
        return ResponseDTO.builder().status(res.toString()).description(res.getValue()).build();
    }
}
