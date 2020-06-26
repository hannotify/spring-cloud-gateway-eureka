package com.github.hannotify.scge.bsintro;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("intro")
public class IntroController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public List<String> getIntro() {
        return List.of(
                "The Ultimate Olympic Mission",
                "a film by Tom Kostner",
                "produced by service on port " + serverPort
        );
    }
}
