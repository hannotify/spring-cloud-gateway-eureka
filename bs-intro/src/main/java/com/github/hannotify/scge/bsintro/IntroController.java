package com.github.hannotify.scge.bsintro;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("intro")
public class IntroController {

    @GetMapping
    public List<String> getIntro() {
        return List.of(
                "The Ultimate Olympic Mission",
                "a film by Tom Kostner"
        );
    }
}
