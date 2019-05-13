package jic.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Model {
    private static AtomicInteger next_id = new AtomicInteger();
    private Integer id;

    public Model() {
        id = next_id.incrementAndGet();
    }

    private Integer getId() {
        return id;
    }

    public static Model search(Scanner scanner, ArrayList<Model> objects) {
        int id_to_search;
        System.out.println("Enter the id: ");
        id_to_search = scanner.nextInt();
        for (Model object : objects) {
            if (object.getId() == id_to_search) {
                return object;
            }
        }
        System.out.println("Model not found: ");
        return null;
    }

    public static void validateAttribute(String validator_class, String attribute_name, String attribute) throws
        ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String validate_method_name = "validate" +
                attribute_name.substring(0,1).toUpperCase() +
                attribute_name.substring(1);
        Method method = Class.forName(validator_class).getDeclaredMethod(validate_method_name, String.class);
        method.invoke(validator_class, attribute);
    }
}
