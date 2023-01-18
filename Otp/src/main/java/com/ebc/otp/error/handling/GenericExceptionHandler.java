package com.ebc.otp.error.handling;

import com.ebc.otp.dto.ResponseDTO;
import com.ebc.otp.exception.GenericException;
import com.ebc.otp.helper.OTPEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice("com.ebc.otp")
public class GenericExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(GenericException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO> handleMessageAlreadyProcessedException(final HttpServletRequest request, final GenericException ex) {
        log.error("An Exception occurred!", ex);
        return new ResponseEntity<>(ResponseDTO.builder().status(OTPEnum.FAILED.toString()).description(OTPEnum.FAILED.getValue()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
