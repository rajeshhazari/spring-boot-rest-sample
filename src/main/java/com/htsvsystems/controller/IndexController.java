package com.htsvsystems.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(path="/")
    public String home() {
        return "index";
    }

    @GetMapping(path="/index")
    public String index() {
        return "index";
    }

    @Value("${app.title:Hello world}")
    String appTitle;

    @GetMapping(path="/main")
    public ResponseEntity<String> main(@RequestParam(name = "message", required = false, defaultValue = "") String message , Model model) {
        message = StringUtils.isNotBlank(message) ? message : appTitle;
        model.addAttribute("message", message);
        return ResponseEntity.ok("admin/main");
    }

}
