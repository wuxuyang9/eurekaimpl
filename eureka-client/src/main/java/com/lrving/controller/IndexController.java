package com.lrving.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by goodwuxuyang on 2019/5/27.
 */
@RestController
public class IndexController {


    @GetMapping("/list")
    public Object getList(){
        return "list";
    }
}
