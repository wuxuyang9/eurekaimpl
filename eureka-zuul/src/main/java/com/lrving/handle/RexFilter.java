package com.lrving.handle;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

/**
 * Created by goodwuxuyang on 2019/6/2.
 */
@Component
public class RexFilter extends ZuulFilter{

    //todo 自定义异常过滤器返回自定义异常，1，禁用SendErrorFilter, 2,
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        try {
            dosomthing();
        }catch (RException e){
            throw new ZuulRuntimeException(e);
        }

        return null;
    }
    private void dosomthing(){
        throw new RException("参数不能为空",CodeEnum.PARAMS_INVALID.getCode());
    }
}
