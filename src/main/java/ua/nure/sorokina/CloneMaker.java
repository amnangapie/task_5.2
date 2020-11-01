package ua.nure.sorokina;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;

public class CloneMaker {

    public static void main(String[] args) {
        try {
            printProperties(new Employee(1, "Bob", "Dylan",
                    new Address()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void printProperties(Object obj) throws IllegalAccessException {
        if (obj == null) return;
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object propValue = field.get(obj);
            if(field.getType().isArray()){
                int length = Array.getLength(propValue);
                StringBuilder sb = new StringBuilder("");
                sb.append(field.getName() + ":[");
                for (int i = 0; i < length - 1; i ++) {
                    Object arrayElement = Array.get(propValue, i);
                    sb.append(arrayElement.toString() + ", ");
                }
                Object arrayElement = Array.get(propValue, length - 1);
                sb.append(arrayElement.toString() + "]");
                System.out.println(sb);
            } else if (field.getType().getDeclaredFields().length != 0) {
                if (!(propValue instanceof String)) {
                    printProperties(propValue);
                } else {
                    System.out.println(field.getName() + ":" + propValue);
                }
            } else {
                System.out.println(field.getName() + ":" + propValue);
            }
        }
    }

}
