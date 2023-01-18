package com.ebc.otp.helper;

import lombok.Getter;

public enum NotificationTypeEnum {

    EMAIL("EMAIL"), SMS("SMS");
    private final @Getter String value;

    NotificationTypeEnum(final String value) {
        this.value = value;
    }
}
