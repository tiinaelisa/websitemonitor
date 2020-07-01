package com.monitor.webmonitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping
public class LogController {

  @CrossOrigin
  @GetMapping("/status")
    public List readURLList() throws IOException {

        List<URLs> listOfStatuses = ReadConfigFile.getList();

        return listOfStatuses;
    }
}
