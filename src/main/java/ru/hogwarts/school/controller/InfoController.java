package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;

@RestController
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/getPort")
    public ResponseEntity<String> getPort() {
        String port = infoService.getPort();
        return ResponseEntity.ok(port);
    }

    @GetMapping("/Get-int")
    public int getInt() {
        return infoService.getInt();
    }
}
