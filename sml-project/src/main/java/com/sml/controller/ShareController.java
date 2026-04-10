package com.sml.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ShareController {

    private Map<String, String> storage = new HashMap<>();


    // SEND LINK
    @PostMapping("/send")
    public String sendLink(@RequestBody Map<String,String> request){

        String link = request.get("link");

        String code = generateCode();

        storage.put(code, link);

        return code;
    }


    // RECEIVE LINK
    @GetMapping("/receive/{code}")
    public String receiveLink(@PathVariable String code){

        return storage.get(code);
    }


    // GENERATE 6 DIGIT CODE
    private String generateCode(){

        Random random = new Random();

        int num = 100000 + random.nextInt(900000);

        return String.valueOf(num);
    }

}