package com.dk.clms.controller;

import com.dk.clms.domain.Product;
import com.dk.clms.domain.Provider;
import com.dk.clms.proxies.ProviderProxy;
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
@RequestMapping("/products")
public class ProductController {
    private final ProviderProxy providerProxy;

    public List<Product> products = Stream.of(
            new Product("1", "iMac", "1"),
            new Product("2", "iPhone", "2"),
            new Product("3", "iPad", "3")
    ).collect(Collectors.toList());

    public ProductController(ProviderProxy providerProxy) {
        this.providerProxy = providerProxy;
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        Optional<Product> product = products.stream().filter(p -> Objects.equals(id, p.getId())).findFirst();
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product prodObj = product.get();
        Provider provider = providerProxy.getProvider(prodObj.getProviderId());
        prodObj.setProvider(provider);

        return new ResponseEntity<>(prodObj, HttpStatus.ACCEPTED);
    }
}
