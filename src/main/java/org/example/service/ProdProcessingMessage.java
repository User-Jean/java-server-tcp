package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@Profile("prod")
public class ProdProcessingMessage implements ProcessingMessage {

    @Override
    public String process(byte[] inputMessage) {
        String output = new String(inputMessage, StandardCharsets.UTF_8);
        log.info("Production " + output);
        return "Production " + output;
    }
}
