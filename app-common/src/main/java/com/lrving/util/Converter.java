package com.lrving.util;

import com.google.common.base.Function;

/**
* @Description: 实体之间转换抽象类
* @Author: luolang
* @Date: 2019/2/23
*/
public abstract class Converter<A, B> implements Function<A, B> {
    public abstract B doForward(A a);

    public abstract A doBackward(B b);

    @Override
    public B apply(A a) {
        return null;
    }
}
