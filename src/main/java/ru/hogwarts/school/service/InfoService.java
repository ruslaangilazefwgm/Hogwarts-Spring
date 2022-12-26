package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    Logger logger = LoggerFactory.getLogger(InfoService.class);
    @Value("${server.port}")
    private String port;

    public String getPort() {
        logger.info("Was invoked method for getting port");
        return port;
    }
}
