package com.ebc.otp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Component
@Configuration
@ConfigurationProperties(prefix = "net.ebc.otp")
public class OTPConfigProperties {

    private boolean simple;
    private int length;
    private int expiryInMinutes;
}
