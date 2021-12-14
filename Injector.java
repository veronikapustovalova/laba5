//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public Injector() {
    }

    public <T> T inject(T object) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/company/properties.properties "));
        Field[] fields = object.getClass().getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];
            Annotation[] annotations = field.getAnnotations();
            Annotation[] var9 = annotations;
            int var10 = annotations.length;

            for(int var11 = 0; var11 < var10; ++var11) {
                Annotation annotation = var9[var11];
                if (annotation instanceof AutoInjectable) {
                    String fieldClass = field.getType().toString();
                    fieldClass = fieldClass.substring(fieldClass.indexOf(" ") + 1);
                    String classToInject = properties.getProperty(fieldClass);
                    field.set(object, Class.forName(classToInject).newInstance());
                }
            }
        }

        return object;
    }
}
