package com.github.hannotify.scge.bscredits;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credits")
public class CreditsController {
    @GetMapping
    public List<String> getCredits() {
        return List.of(
                "Peter Williams - code reviews",
                "Raymond Patterson - hydration",
                "Dean Klampson - general health",
                "Hank Esterley - diagrams"
        );
    }
}
