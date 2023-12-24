package com.example.jdbcapi.controller;

import com.example.jdbcapi.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    public final Repository repository;

    @GetMapping("/products/fetch-product")
    public ResponseEntity<List<String>> getProductByName (@RequestParam String name){
        return ResponseEntity.ok(repository.getProductName(name));
    }
}
