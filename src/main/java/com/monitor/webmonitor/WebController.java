package com.monitor.webmonitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/status")
    public String status() {

        return "status";
    }
}