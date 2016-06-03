package com.goforit.jgr.tpmonitor.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class AnnotationUtil {

    public static Map<String, Object> loadClassAnnotationValues(Class annotationClass,
                                                                  String annotationField,
                                                                  String className)
            throws Exception{

        if(!Class.forName(className).isAnnotationPresent(annotationClass)){
            return null;
        }

        Map<String,Object> result=new HashMap<String, Object>();

        Method method=annotationClass.getDeclaredMethod(annotationField);
        Object value=method.invoke(annotationClass);

        result.put(annotationField,value);

        return result;
    }
}
