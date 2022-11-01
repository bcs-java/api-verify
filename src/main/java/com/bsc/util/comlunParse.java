package com.bsc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class comlunParse {

    public static Object getParam(String name, Object[] param) {
        if (name.startsWith("#p")) {
            String substring = name.substring(2, name.length());
            String[] split = substring.split(".");
            if (split.length != 2 && !split[0].matches("\\d")) {
                throw new RuntimeException("cumlun Name is error format");
            }
            int index = Integer.parseInt(split[0]);
            Object arg = param[index];
            Object fieldByName = getFieldByName(param[index], split[1]);
            if (fieldByName != null) {
                return fieldByName;
            }
        } else if (param.length == 1) {
            Object fieldByName = getFieldByName(param[0], name);
            if (fieldByName != null) {
                return fieldByName;
            }
        }
        throw new RuntimeException("can not find param");
    }

    private static Object getFieldByName(Object arg, String name) {
        String getField = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        Class<?> aClass = arg.getClass();
        try {
            Method method = aClass.getMethod(getField);
            if (method == null) {
                return null;
            }
            return method.invoke(arg);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
