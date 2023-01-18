package com.ebc.otp.helper;

import lombok.Getter;

public enum OTPEnum {
    VALID("Entered OTP is valid"),
    NOT_VALID("Entered OTP is NOT valid. Please Retry!"),
    SUCCESS("OTP Sent Successfully"),
    FAILED("Error while Sending OTP");
    private final @Getter String value;

    OTPEnum(final String value) {
        this.value = value;
    }
}
