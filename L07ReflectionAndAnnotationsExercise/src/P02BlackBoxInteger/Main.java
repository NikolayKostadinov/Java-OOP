package P02BlackBoxInteger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class clazz = BlackBoxInt.class;
        Object instance = createInstance(clazz);
        Field field = getField(clazz);
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("_");
            String commandName = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method method = getMethod(clazz, commandName);
            method.invoke(instance, value);
            System.out.println(field.get(instance));
            input = scan.nextLine();
        }
    }

    private static Field getField(Class clazz) throws NoSuchFieldException {
        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);
        return field;
    }

    private static Method getMethod(Class clazz, String command)
            throws NoSuchMethodException {
        var method = clazz.getDeclaredMethod(command, int.class);
        method.setAccessible(true);
        return method;
    }

    private static Object createInstance(Class clazz)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        var ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        Object instance = ctor.newInstance();
        return instance;
    }
}
