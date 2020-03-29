package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/song")
public class SongController {

    @RequestMapping(value = "/list")
    public String list() {
        return "song";
    }

}
