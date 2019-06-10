package com.lrving.handle;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * Created by goodwuxuyang on 2019/6/2.
 */
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run(){
        RequestContext currentContext = RequestContext.getCurrentContext();
        StringBuilder filterExecutionSummary = currentContext.getFilterExecutionSummary();
        System.out.println(filterExecutionSummary.toString());
        Throwable throwable = currentContext.getThrowable();
        Throwable cause = throwable.getCause();
        currentContext.set("sendErrorFilter.ran");
        return cause;
    }
}
