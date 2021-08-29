package com.chernyavskii.multifunctionalbot.controller;

import com.chernyavskii.multifunctionalbot.dto.CallbackDto;
import com.chernyavskii.multifunctionalbot.service.CallbackHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/callbacks")
public class MainController {

    private final CallbackHandleService callbackHandleService;

    @Autowired
    public MainController(CallbackHandleService callbackHandleService) {
        this.callbackHandleService = callbackHandleService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> handleCallback(@RequestBody CallbackDto callbackDto) {
        return new ResponseEntity<>(callbackHandleService.handleCallback(callbackDto), HttpStatus.OK);
    }

}
