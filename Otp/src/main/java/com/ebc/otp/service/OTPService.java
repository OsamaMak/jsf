package com.ebc.otp.service;

import com.ebc.otp.config.OTPConfigProperties;
import com.ebc.otp.dto.OtpGenerationRequest;
import com.ebc.otp.dto.OtpValidationRequest;
import com.ebc.otp.helper.OTPEnum;
import com.ebc.otp.helper.OTPGenerator;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class OTPService {
    private final OTPConfigProperties properties;
    private LoadingCache<String, String> otpCache;

    private final Logger logger = LoggerFactory.getLogger(OTPService.class);

    @Autowired
    public OTPService(OTPConfigProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void initializeCache() {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String o) throws Exception {
                return o.toUpperCase();
            }
        };
        otpCache = CacheBuilder.newBuilder().weigher((key, value) -> 0).maximumWeight(1000L).expireAfterWrite(properties.getExpiryInMinutes(), TimeUnit.MINUTES).build(loader);
    }

    public String generateOTP(final OtpGenerationRequest request) {
        String otp = properties.isSimple() ? OTPGenerator.GENERATE_SIMPLE_OTP(properties.getLength()) : OTPGenerator.GENERATE_COMPLEX_OTP(properties.getLength());
        String key = request.getUserType() + "-" + request.getUsername();
        otpCache.put(key, otp);
        return otp;
    }


    public OTPEnum validateOtp(final OtpValidationRequest request) {
        if (request.getOtpNumber() != null) {
            String key = request.getUserType() + "-" + request.getUsername();
            String serverOtp = getOtp(key);
            if (serverOtp != null) {
                if (request.getOtpNumber().equals(serverOtp)) {
                    clearOTP(key);
                    logger.info("OTP validated successfully");
                    return OTPEnum.VALID;
                }
            }
        }
        logger.info("OTP is not valid");
        return OTPEnum.NOT_VALID;
    }

    //This method is used to return the OPT against Key->Key values is username
    private String getOtp(final String key) {
        try {
            return otpCache.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    //This method is used to clear the OTP cached already
    private void clearOTP(final String key) {
        otpCache.invalidate(key);
    }
}
