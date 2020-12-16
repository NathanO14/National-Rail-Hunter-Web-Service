package com.nathanodong.nationaltrainhunterws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nathan Odong
 */
@RestController
public class DefaultController {
    @RequestMapping("/")
    public String getHome() {
        return "National Train Hunter Web Service";
    }
}