package com.sml.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class LinkService {

    private Map<String, String> storage = new HashMap<>();

    public String saveLink(String link) {

        String code = generateCode();
        storage.put(code, link);

        return code;
    }

    public String getLink(String code) {
        return storage.get(code);
    }

    private String generateCode() {

        Random random = new Random();
        int number = 100000 + random.nextInt(900000);

        return String.valueOf(number);
    }
}
