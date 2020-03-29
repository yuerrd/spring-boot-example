package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <功能说明>:
 *
 * @author yangyong
 * @date 2020-02-09
 */
@Controller
public class BaseMainController {

    @GetMapping("/auth/login")
    public String loginPage(Model model) {

        model.addAttribute("loginProcessUrl", "/auth/authorize");

        return "base-login";
    }
}
