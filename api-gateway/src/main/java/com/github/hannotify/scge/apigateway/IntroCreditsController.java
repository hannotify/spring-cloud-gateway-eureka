package com.github.hannotify.scge.apigateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("intro-credits")
public class IntroCreditsController {
    private final WebClient.Builder webclient;

    @Autowired
    public IntroCreditsController(@Qualifier("LoadBalanced") WebClient.Builder webclient) {
        this.webclient = webclient;
    }

    @GetMapping
    public List<String> getIntroCredits() throws ExecutionException, InterruptedException {
        List<String> introList = Arrays.asList(
                Objects.requireNonNull(webclient.build().get().uri("lb://BS-INTRO/intro")
                        .retrieve().bodyToMono(String[].class).toFuture().get()));

        List<String> creditsList = Arrays.asList(
                Objects.requireNonNull(webclient.build().get().uri("lb://BS-CREDITS/credits")
                        .retrieve().bodyToMono(String[].class).toFuture().get()));

        return Stream.of(introList, creditsList)
                .flatMap(List::stream)
                .filter(s -> !s.contains("diagrams")) // only include real work
                .collect(Collectors.toList());
    }
}
