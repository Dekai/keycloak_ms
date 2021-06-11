package com.dk.clms.controller;

import com.dk.clms.domain.Provider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    List<Provider> providers = Stream.of(
            new Provider("1", "PP1"),
            new Provider("2", "PP2")
    ).collect(Collectors.toList());

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable("id") String id) {
        Optional<Provider> provider = providers.stream().filter(p -> Objects.equals(id, p.getId())).findFirst();
        return provider.map(value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
