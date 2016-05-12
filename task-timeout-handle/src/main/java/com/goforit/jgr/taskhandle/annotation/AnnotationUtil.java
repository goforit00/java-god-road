package com.goforit.jgr.taskhandle.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junqingfjq on 16/5/12.
 */
public enum AnnotationUtil {

    INSTANCE{

        @Override
        protected Map<String, Object> loadFieldAnnotationValues(Class annotationClass, String annotationField,String className) throws Exception{

            Map<String,Object> map =new HashMap<String, Object>();

            Field[] fields=Class.forName(className).getDeclaredFields();

            for(Field field:fields){
                if(field.isAnnotationPresent(annotationClass)){
                    Annotation annotation=field.getAnnotation(annotationClass);

                    Method annMethod=annotation.getClass().getDeclaredMethod(annotationField,null);

                    Object value=annMethod.invoke(annotation,null);

                    map.put(field.getName(),value);
                }
            }
            return map;
        }

        @Override
        protected Map<String, Object> loadMethodAnnotationValues(Class annotationClass, String annotationField, String className) throws Exception {

            Map<String,Object> map=new HashMap<String, Object>();

            Method [] methods=Class.forName(className).getDeclaredMethods();

            for(Method method:methods){
                if(method.isAnnotationPresent(annotationClass)){
                    Annotation annotation=method.getAnnotation(annotationClass);

                    Method annMethod=annotation.getClass().getDeclaredMethod(annotationField, null);

                    Object value=annMethod.invoke(annotation,null);

                    map.put(method.getName(),value);
                }
            }

            return map;
        }
    };

    protected abstract Map<String, Object> loadFieldAnnotationValues(Class annotationClass,
                                                                     String annotationField,
                                                                     String className)
            throws Exception;

    protected abstract Map<String, Object> loadMethodAnnotationValues(Class annotationClass,
                                                                      String annotationField,
                                                                      String className)
            throws Exception;
}
