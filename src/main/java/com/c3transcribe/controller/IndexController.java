package com.c3transcribe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(path="/")
    public String home() {
        return "index";
    }

    @GetMapping(path="/index")
    public String index() {
        return "index";
    }

    @GetMapping(path="/main")
    public String main() {
        return "admin/main";
    }

}
