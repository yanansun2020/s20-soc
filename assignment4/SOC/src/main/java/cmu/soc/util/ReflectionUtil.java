package cmu.soc.util;

import cmu.soc.parser.PaperDtd;
import cmu.soc.parser.PaperDtdAttribute;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static String getAttribute(Object obj, String nodeName){
        String methodNameSuffix  = nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1);
        String getMethodName = "get" + methodNameSuffix;
        try {
            Method method = obj.getClass().getMethod(getMethodName);
            String v = (String)method.invoke(obj);
            return StringUtils.isEmpty(v)? StringUtils.EMPTY : v;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    public static void putAttribute(Object obj, String nodeName, String value){
        String methodNameSuffix  = nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1);
        String setMethodName = "set" + methodNameSuffix;
        try {
            Method method = obj.getClass().getMethod(setMethodName, String.class);
            method.invoke(obj, value );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * replace the first $ on each property
     * @param obj
     * @return
     */
    public static void trimObj(Object obj){
        Field[] fields = new Field[0];
        if(obj instanceof PaperDtd){
            fields = PaperDtd.class.getDeclaredFields();
        }else if(obj instanceof PaperDtdAttribute){
            fields = PaperDtdAttribute.class.getDeclaredFields();
        }
        for(Field field : fields){
            String fieldName = field.getName();
            if("id".equals(fieldName) || "paperType".equals(fieldName) || "paperTypeInt".equals(fieldName)){
                continue;
            }
            if("paperDtdAttribute".equals(fieldName)){
                PaperDtd paperDtd = (PaperDtd)obj;
                trimObj(paperDtd.getPaperDtdAttribute());
                continue;
            }
            String fieldValue = ReflectionUtil.getAttribute(obj, fieldName);
            fieldValue = StringUtils.isEmpty(fieldValue)? StringUtils.EMPTY : fieldValue.substring(1);
            ReflectionUtil.putAttribute(obj, fieldName, fieldValue);
        }
    }
}
