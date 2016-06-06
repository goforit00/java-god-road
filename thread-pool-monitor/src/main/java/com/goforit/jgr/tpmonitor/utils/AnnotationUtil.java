package com.goforit.jgr.tpmonitor.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class AnnotationUtil {

    /**
     *
     * @param annotationClass  注解类名称
     * @param annotationField  注解类的方法名称(属性名称)
     * @param className  类名称
     * @return  返回类上注解annotationClass 的 annotationField属性的值
     * @throws Exception
     */
    public static Object loadClassAnnotationValues(Class annotationClass,
                                                                  String annotationField,
                                                                  String className)
            throws Exception{

        if(!Class.forName(className).isAnnotationPresent(annotationClass)){
            return null;
        }

        Method method=annotationClass.getDeclaredMethod(annotationField);
        Object value=method.invoke(annotationClass);

        return value;

    }

    /**
     *
     * @param annotationClass
     * @param annotationField
     * @param className
     * @return 返回bean 中所有打了annotationClass 注解的field 的annotationField 的值
     * Map<String(fieldName),Object(注解值)>
     * @throws Exception
     */
    public static Map<String, Object> loadFieldsAnnotationValues(Class annotationClass,
                                                                String annotationField,
                                                                String className)
            throws Exception{

        Map<String,Object> result=new HashMap<String, Object>();

        Field [] fields=Class.forName(className).getDeclaredFields();
        for(Field f:fields){
            if(f.isAnnotationPresent(annotationClass)){
                Method m=annotationClass.getDeclaredMethod(annotationField);
                Object value=m.invoke(annotationClass);
                result.put(f.getName(),value);
            }
        }

        return result;
    }
}
