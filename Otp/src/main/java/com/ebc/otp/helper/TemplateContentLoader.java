package com.ebc.otp.helper;

import com.ebc.otp.exception.GenericException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TemplateContentLoader {

    private static String LOAD_TEMPLATE() throws Exception {
        ClassLoader classLoader = TemplateContentLoader.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("SendOtp.html")).getFile());
        String content;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new GenericException("Could not read template  = " + "SendOtp.html");
        }
        return content;

    }

    public static String GET_TEMPLATE(final String otp) throws Exception {
        String msg = LOAD_TEMPLATE();
        //Replace the String
        Map<String, String> replacements = new HashMap<>();
        replacements.put("otpnum", otp);
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            msg = msg.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return msg;
    }
}
