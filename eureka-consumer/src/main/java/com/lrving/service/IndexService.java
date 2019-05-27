package com.lrving.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by goodwuxuyang on 2019/5/27.
 */
@FeignClient(value = "app-client",fallback = IndexServiceImpl.class)
public interface IndexService {
    @GetMapping("/list")
    String getList();
}
