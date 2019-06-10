package com.lrving.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

/**
 * @program: V1.1.10.1
 * @description 未实现
 * @author: luolang
 * @create: 2019-03-27 23:03
 **/
//@Deprecated
@Component
public class Serialized {
    @Autowired
    ObjectMapper objectMapper;


    /*public <T> T deserializeObject(Class<T> clazz,@NotBlank(message = "JSON不能为空") String json){
        try {
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(List.class,clazz);
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    /**
    * @Description:
    * @Param: clazz 转换类型
     * @param json JSON字段
    * @return: 返回类型List
    * @Author: luolang
    * @Date: 2019/3/28
    */
    public <T> List<T> deserializeList(Class<T> clazz, @NotBlank(message = "JSON不能为空") String json){
        try {
            return objectMapper.readValue(json, new TypeReference<List<T>>() {});
        } catch (IOException e) {
            //TODO:重写异常，主动拦截
            e.printStackTrace();
        }
        return null;
    }

}
