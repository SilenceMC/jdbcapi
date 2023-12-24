package com.example.jdbcapi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class Repository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String script = read("select.sql");

    private static String read(String script) {
        try (InputStream is = new ClassPathResource(script).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){
        return namedParameterJdbcTemplate.queryForList(script, Map.of("name", name), String.class);
    }
}
