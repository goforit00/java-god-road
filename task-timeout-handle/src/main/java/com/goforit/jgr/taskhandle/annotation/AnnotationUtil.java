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
        public Map<String, Object> loadFieldAnnotationValues(Class annotationClass, String annotationField,String className) throws Exception{

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
        public Map<String, Object> loadMethodAnnotationValues(Class annotationClass, String annotationField, String className) throws Exception {

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

        @Override
        public boolean hasAnnotationInMethods(Class annotationClass, String className) throws Exception {
            Method [] methods=Class.forName(className).getDeclaredMethods();

            boolean result=false;
            for(Method m:methods){
                if(m.isAnnotationPresent(annotationClass)){
                    result=true;
                }
            }

            return result;
        }

        @Override
        public Map<String, Object> loadMethodAnnotationValues(Class annotationClass, String className) throws Exception {
            Map<String,Object> map=new HashMap<String, Object>();

            Method [] classMethods=Class.forName(className).getDeclaredMethods();

            for(Method classMethod:classMethods){
                if(classMethod.isAnnotationPresent(annotationClass)){
                    Annotation annotation=classMethod.getAnnotation(annotationClass);

                    Method [] annMethods=annotation.getClass().getDeclaredMethods();
                    for(Method m:annMethods){
                        Object value=m.invoke(annotation);
                        map.put(m.getName(),value);
                    }

                    return map;

                }
            }

            return map;
        }
    };

    public abstract Map<String, Object> loadFieldAnnotationValues(Class annotationClass,
                                                                  String annotationField,
                                                                  String className)
                                                                                   throws Exception;

    public abstract Map<String, Object> loadMethodAnnotationValues(Class annotationClass,
                                                                   String annotationField,
                                                                   String className)
                                                                                    throws Exception;

    public abstract boolean hasAnnotationInMethods(Class annotationClass, String className)
                                                                                           throws Exception;

    //只适用于 一个类中只能有一个方法打注解
    public abstract Map<String, Object> loadMethodAnnotationValues(Class annotationClass,
                                                                   String className)
                                                                                    throws Exception;
}
