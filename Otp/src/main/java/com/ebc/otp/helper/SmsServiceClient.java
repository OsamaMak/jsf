package com.ebc.otp.helper;

import com.ebc.otp.dto.SMSRequestDTO;
import com.ebc.otp.dto.SMSResponseDTO;
import com.ebc.otp.exception.GenericException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Setter
public class SmsServiceClient {

    @Value("${net.ebc.otp.sms.service.url}")
    private String url;

    public OTPEnum sendSMS(final String username, final String otp) {

        SMSRequestDTO requestDTO = null;
        try {
            requestDTO = SMSRequestDTO.builder().subject("Instapay").system("DPG-Portal").mobileNumber(username).language(Language.EN).message(TemplateContentLoader.GET_TEMPLATE(otp)).build();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();

            // Data attached to the request.
            HttpEntity<SMSRequestDTO> requestBody = new HttpEntity<>(requestDTO, headers);

            // Send request with POST method.
            SMSResponseDTO response = restTemplate.postForObject(url, requestBody, SMSResponseDTO.class);

            if (response == null) {
                throw new GenericException("Error while calling SMS service");
            }
            return response.isSent() ? OTPEnum.SUCCESS : OTPEnum.FAILED;
        } catch (Exception e) {
            throw new GenericException(e.getMessage(), e.getCause(), true, true);
        }

    }

}
