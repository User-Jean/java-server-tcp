package org.example.presentation;

import lombok.extern.slf4j.Slf4j;
import org.example.config.TCPServerConfiguration;
import org.example.service.ProcessingMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@Slf4j
@MessageEndpoint
public class ServiceMessage {
    private ProcessingMessage processingMessage;
    private String propertyCommon;

    public ServiceMessage(ProcessingMessage processingMessage,
          @Value("${property.common}") String propertyCommon) {
        this.processingMessage = processingMessage;
        this.propertyCommon = propertyCommon;
    }

    @ServiceActivator(inputChannel = TCPServerConfiguration.TCP_DEFAULT_CHANNEL)
    public byte[] process(byte[] message) {
        processingMessage.process(message);
        log.info("property.common -> " + propertyCommon);
        return "hello".getBytes();
    }
}
