package com.lrving.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by lhp on 2017/4/11.
 */
public class ObjectUtil {

    public static Boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }

        return false;
    }

    public static boolean nonEmpty(Object obj) {
        return !isEmpty(obj);
    }
    
    public static Map<String, Object> transBeanToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性

                if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
                    if (getter != null) {
                        Object value = getter.invoke(obj);
                        if (value != null) {
                            map.put(key, value);
                        }
                    }
				}
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;
	}


    public static <T> T nvl(T t, T d) {
        return Optional.ofNullable(t).orElse(d);
    }

    public static <T> T nvl(T t, Supplier<? extends T> supplier) {
        return Optional.ofNullable(t).orElseGet(supplier);
    }

    public static <T> Boolean anyEmpty(T... ts) {
        return Stream.of(ts).anyMatch( ObjectUtil::isEmpty );
    }

}
