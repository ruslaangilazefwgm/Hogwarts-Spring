package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class InfoService {
    Logger logger = LoggerFactory.getLogger(InfoService.class);
    @Value("${server.port}")
    private String port;

    public String getPort() {
        logger.info("Was invoked method for getting port");
        return port;
    }

    public int getInt() {
    int sum = Stream.iterate(1, a -> a +1)
            .parallel()
            .limit(1_000_000)
            .reduce(0, (a, b) -> a + b );
        return sum;
    }
}
