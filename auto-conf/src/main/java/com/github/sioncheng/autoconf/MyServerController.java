package com.github.sioncheng.autoconf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myserver")
public class MyServerController {

    @RequestMapping("list")
    public String list() {
        return "list";
    }
}
