package com.example.config;

import java.lang.reflect.Field;

public class Utils {
    /**
     * content : 输出STUDENT 类所有属性值
     * author : najianlin
     * email : naariahlin@163.com
     * date : 2024-10-30 10:19
     * version: V.1.0.0
     */
    public static void printValues(Object obj) throws Exception {
        if (obj == null) {
            System.out.println("printValues parameter obj is null");
            return;
        }
        Class clazz = obj.getClass();
        System.out.println("printValues parameter obj="+clazz.getName()+": {");
        System.out.print("  ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.print(field.getName() + ":" + field.get(obj) + ", ");
        }
        System.out.println("\n}");
    }
}
