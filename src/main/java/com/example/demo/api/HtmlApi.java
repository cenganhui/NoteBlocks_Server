package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面模板导航类
 */
@Controller
public class HtmlApi {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/share")
    public String share() {
        return "share";
    }

}
