package com.lrving.controller;

import com.lrving.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by goodwuxuyang on 2019/5/27.
 */
@RestController
public class IndexContrller {

    @Autowired
    private IndexService indexService;
    @GetMapping("/consumer")
    public Object list(){
        String list = indexService.getList();
        return list;
    }

}
